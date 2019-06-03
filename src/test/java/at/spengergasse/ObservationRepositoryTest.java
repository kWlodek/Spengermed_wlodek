package at.spengergasse;

import at.spengergasse.repositories.IObservationRepository;
import at.spengergasse.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ObservationRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IObservationRepository observationRepository;

    @Test
    @Transactional
    public void testOneObservation(){

        // 1. Instanz von Patient erstellen, mit Daten befüllen
        Observation o = new Observation();

        CodeableConcept cc1 = new CodeableConcept(
                new HashSet<Coding>(
                        java.util.Arrays.asList(
                                new Coding("iwas",
                                        "1", "DL", "Drivers License Number", false))),
                "CC1");

        CodeableConcept cc2 = new CodeableConcept(
                new HashSet<Coding>(
                        java.util.Arrays.asList(
                                new Coding("iwas",
                                        "1", "PPN", "Passport Number", false))),
                "CC2");

        Set<Identifier> identifiers = new HashSet<Identifier>(
                java.util.Arrays.asList(
                        new Identifier(Identifier.Use.official,
                                cc1,
                                "System",
                                "Value",
                                generatedPeriod()),
                        new Identifier(Identifier.Use.old,
                                cc2,
                                "System",
                                "Value",
                                generatedPeriod())
                )
        );



        Set<Reference> partOf = new HashSet<Reference>(
                java.util.Arrays.asList(
                        new Reference(
                                "Iwas","Type of Reference",
                                new Identifier(Identifier.Use.old,
                                        cc1,
                                        "System",
                                        "Value",
                                        generatedPeriod()),
                                "Display"),
                        new Reference(
                                "Iwas 2", "Anderer type",
                                new Identifier(Identifier.Use.official,
                                        cc2,
                                        "System 2",
                                        "Value 2",
                                        generatedPeriod()),
                                "Display"))
        );



        o.setStatus(new Reference("Iwas 3","noch ein anderer type",
                new Identifier(Identifier.Use.temp,
                        cc1,
                        "System 3",
                        "Value 3",
                        generatedPeriod()),
                "display 3"
        ))
        ;

        o.setIdentifiers(identifiers);
        o.setPartOf(partOf);
        o.setCode(cc1);
        o.setSubject(new Reference("Iwas 4", "noch iwas",
                new Identifier(Identifier.Use.usual,
                        cc2,
                        "System 4",
                        "Value 4",
                        generatedPeriod()),
                "display")

        );

        // 2. Patienten über das at.spengergasse.Repository in die DB speichern

        Observation savedObservation = observationRepository.save(o);
        observationRepository.flush();
        // 3. Patienten über das Repositry aus der DB laden
        Observation loadedObservation = observationRepository.findById(savedObservation.getId()).get();
        // 4. Vergleich Soll-Ist Daten

        Set<Identifier> expectedIDs = o.getIdentifiers();
        Set<Identifier> actualIDs = savedObservation.getIdentifiers();
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedIDs, actualIDs));

        Set<Reference> expectedPartOf = o.getPartOf();
        Set<Reference> actualPartOf = savedObservation.getPartOf();
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedPartOf, actualPartOf));

        Assert.assertEquals(o.getStatus(), savedObservation.getStatus());
        Assert.assertEquals(o.getCode(), savedObservation.getCode());
        Assert.assertEquals(o.getSubject(), savedObservation.getSubject());
        // der test geht ned
    }

    private Period generatedPeriod() {
        Random r = new Random();
        return new Period(
                LocalDate.of(r.nextInt(100) + 1900, r.nextInt(11)+1, r.nextInt(27)+1),
                LocalDate.of(r.nextInt(100) + 1900, r.nextInt(11)+1, r.nextInt(27)+1));
    }
}
