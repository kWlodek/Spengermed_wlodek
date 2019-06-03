package at.spengergasse;


import at.spengergasse.repositories.IPatientRepository;
import at.spengergasse.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.aspectj.apache.bcel.classfile.Code;
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
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IPatientRepository patientRepository;

    @Test
    @Transactional
    public void testOnePatient(){

        // 1. Instanz von Patient erstellen, mit Daten befüllen
        Patient p = new Patient();
        p.setGender(Patient.GESCHLECHT.unknown);
        p.setBirthDate(LocalDate.of(2000,04,12));
        Set<Address> addresses = new HashSet<Address>(java.util.Arrays.
                asList(
                        new Address(
                                Address.Use.billing,
                                Address.Type.both,
                                "Address Text",
                                new HashSet<String>(Arrays.asList("Line 1", "Line 2")),
                                "Vienna",
                                "1180",
                                "Vienna",
                                "1180",
                                "Austria",
                                generatedPeriod()
                        ),
                        new Address(
                                Address.Use.home,
                                Address.Type.postal,
                                "Address Text2",
                                new HashSet<String>(Arrays.asList("Line 3", "Line 4")),
                                "Vienna",
                                "1220",
                                "Vienna",
                                "1220",
                                "Austria",
                                generatedPeriod()
                        )
                ));
        p.setAddress(addresses);

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
        p.setIdentifiers(identifiers);
        // 2. Patienten über das at.spengergasse.Repository in die DB speichern
        Patient savedPatient = patientRepository.save(p);
        patientRepository.flush();
        // 3. Patienten über das Repositry aus der DB laden
        Patient loadedPatient = patientRepository.findById(savedPatient.getId()).get();
        // 4. Vergleich Soll-Ist Daten
        Assert.assertEquals(savedPatient.getBirthDate(), loadedPatient.getBirthDate());
        Assert.assertEquals(savedPatient.getGender(), loadedPatient.getGender());
        Assert.assertTrue(CollectionUtils.isEqualCollection(savedPatient.getAddress(),loadedPatient.getAddress()));
        Set<Identifier> expectedIDs = savedPatient.getIdentifiers();
        Set<Identifier> actualIDs = loadedPatient.getIdentifiers();
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedIDs, actualIDs)); // der test geht ned
    }

    private Period generatedPeriod() {
        Random r = new Random();
        return new Period(
                LocalDate.of(r.nextInt(100) + 1900, r.nextInt(11)+1, r.nextInt(27)+1),
                LocalDate.of(r.nextInt(100) + 1900, r.nextInt(11)+1, r.nextInt(27)+1));
    }
}
