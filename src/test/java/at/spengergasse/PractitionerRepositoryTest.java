package at.spengergasse;



import at.spengergasse.repositories.IPractitionerRepository;
import at.spengergasse.model.*;
import org.apache.commons.collections4.CollectionUtils;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PractitionerRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IPractitionerRepository practitionerRepository;

    @Test
    @Transactional
    public void testOnePractitioner(){
        Practitioner practitioner1 = new Practitioner();
        practitioner1.setActive(true);
        practitioner1.setGender(Practitioner.Geschlecht.male);
        practitioner1.setBirthDate(LocalDate.of(2001,05,23));
        Set<Address> addresses = new HashSet<Address>(java.util.Arrays.
                asList(
                        new Address(
                                Address.Use.home,
                                Address.Type.both,
                                "Address1 Texti text",
                                new HashSet<String>(Arrays.asList("lalalalla", "Line 2")),
                                "Vienna",
                                "1180",
                                "Vienna",
                                "1180",
                                "Austria",
                                generatedPeriod()
                        ),
                        new Address(
                                Address.Use.billing,
                                Address.Type.postal,
                                "Address2 Texti text",
                                new HashSet<String>(Arrays.asList("Line 3", "Line 4")),
                                "Vienna",
                                "1140",
                                "Vienna",
                                "1140",
                                "Austria",
                                generatedPeriod()
                        )
                ));
        practitioner1.setAddress(addresses);

        //CodeableConcept sowie Identifiers wurden aus dem Beispiel aus der Stunde übernommen

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
        practitioner1.setIdentifiers(identifiers);

        //nur einen Namen, weil, naja, ich hab nur einen :P
        Set<HumanName> humanNames = new HashSet<HumanName>(
                java.util.Arrays.asList(
                        new HumanName(HumanName.Use.old,
                                "texti text 3",
                                "mueller",
                                new HashSet<String>(Arrays.asList("Vinzenz", "Calvin")),
                                new HashSet<String>(Arrays.asList("Mr", "Dr")),
                                new HashSet<String>(Arrays.asList("", "")),
                                generatedPeriod()
                        )
                )
        );
        practitioner1.setNames(humanNames);

        //Practitioner speichern
        Practitioner savedPractitioner = practitionerRepository.save(practitioner1);
        practitionerRepository.flush();
        // Practitioner aus der DB laden
        Practitioner loadedPractitioner = practitionerRepository.findById(savedPractitioner.getId()).get();
        // Vergleich Soll-Ist Daten

        //GebDat Vergleich
        Assert.assertEquals(savedPractitioner.getBirthDate(), loadedPractitioner.getBirthDate());
        //Gender Vergleich (auch wenn natürlich alle Gender Equal sind :P )
        Assert.assertEquals(savedPractitioner.getGender(), loadedPractitioner.getGender());
        //Active Vergleich
        Assert.assertEquals(savedPractitioner.getActive(), loadedPractitioner.getActive());
        //Address Vergleich
        Assert.assertTrue(CollectionUtils.isEqualCollection(savedPractitioner.getAddress(),loadedPractitioner.getAddress()));
        //Identifier Vergleich
        Set<Identifier> expectedIDs = savedPractitioner.getIdentifiers();
        Set<Identifier> actualIDs = loadedPractitioner.getIdentifiers();
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedIDs, actualIDs));
        //HumanNames Vergleich
        Assert.assertTrue(CollectionUtils.isEqualCollection(savedPractitioner.getNames(),loadedPractitioner.getNames()));
    }

    private Period generatedPeriod() {
        Random r = new Random();
        return new Period(
                LocalDate.of(r.nextInt(100) + 1900, r.nextInt(11)+1, r.nextInt(27)+1),
                LocalDate.of(r.nextInt(100) + 1900, r.nextInt(11)+1, r.nextInt(27)+1));
    }
}
