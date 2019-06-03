package at.spengergasse;

/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ILocationRepository locationRepository;

    @Test
    public void testOnePatient() {
        Location loc = new Location();


        Set<Reference> partofs = new HashSet<Reference>(
                Arrays.asList(
                        new Reference(Address.Use.billing,
                                Reference.Type.both,
                                "Reference Text",
                                new HashSet<String>(Arrays.asList("Line 1", "Line 2")),
                                "Konrad",
                                "Wlodek",
                                "456",
                                "345",
                                generatePeriod()
                        ),
                        new Reference()
                ));
        loc.setReference(partofs);



        CodeableConcept cc1 = new CodeableConcept(
                new HashSet<Coding>(
                        Arrays.asList(
                                new Coding("https://terminology.hl7.org/CodeSystem/v2-0203",
                                        "1", "Konrad", "Wlodek", false))),
                "CC1");

        CodeableConcept cc2 = new CodeableConcept(
                new HashSet<Coding>(
                        Arrays.asList(
                                new Coding("https://terminology.hl7.org/CodeSystem/v2-0203",
                                        "2", "Konrad4", "Wlodek4", false))),
                "CC2");

        loc.setPhysicalType(Location.location.planned);

        BackboneElement physicalType = new BackboneElement();



        Location savedLocation = locationRepository.save(loc);
        Location loadedLocation = locationRepository.findById(savedLocation.getId()).get();


        Assert.assertTrue(CollectionUtils.isEqualCollection(loc.getPartOf(), loadedLocation.getPartOf()));
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedIDs, actualIDs));
        Assert.assertEquals(loc.getMode(), loadedLocation.getMode());
        Assert.assertEquals(loc.getHoo(), loadedLocation.getHoo());
        Assert.assertEquals(loc.getOperationStatus(), loadedLocation.getOperationStatus());


    }



}
*/