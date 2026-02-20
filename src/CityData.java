import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CityData {

    public static City getIstanbul() {
        
        List<Place> places = Arrays.asList(); 

        List<SeasonalClimate> climates = Arrays.asList(
            new SeasonalClimate("Spring", LocalDate.of(2025, 3, 21), LocalDate.of(2050, 6, 20), 17, 60, "Light jacket"),
            new SeasonalClimate("Summer", LocalDate.of(2025, 6, 21), LocalDate.of(2050, 9, 22), 28, 30, "T-shirt and sunscreen"),
            new SeasonalClimate("Autumn", LocalDate.of(2025, 9, 23), LocalDate.of(2050, 12, 21), 19, 50, "Sweater or light coat"),
            new SeasonalClimate("Winter", LocalDate.of(2025, 12, 22), LocalDate.of(2050, 3, 20), 8, 70, "Warm coat and umbrella")
        );

        List<TransportOption> transports = Arrays.asList(
            new TransportOption("Metro", 0.6, "06:00-00:00"),
            new TransportOption("Tram", 0.5, "06:00-00:00"),
            new TransportOption("Bus", 0.6, "24/7 on main lines"),
            new TransportOption("Ferry", 1.0, "07:00-22:00"),
            new TransportOption("Taxi", 3.5, "24/7"),
            new TransportOption("Dolmus", 0.7, "06:00–01:00")
        );
       List<Accomodation> accomodations = Arrays.asList(
    new Accomodation("Hotel", 90.0, "Taksim", "https://www.trivago.com.tr/tr/lm/otel-titanic-city-taksim-istanbul?search=100-912965;500-1314535;dr-20250601-20250602-s;rc-1-1#::hasInteracted=true"),
    new Accomodation("Hostel", 35.0, "Kadıköy", "https://www.tripadvisor.com.tr/Hotel_Review-g293974-d16805903-Reviews-Moda_Drei_Concept_Hostel-Istanbul.html"),
    new Accomodation("Airbnb", 65.0, "Beşiktaş", "https://www.airbnb.com.tr/rooms/845680469667232115?adults=1&check_in=2025-05-29&check_out=2025-05-30&search_mode=regular_search&source_impression_id=p3_1747655002_P34LkVu-pbK4YRqn&previous_page_section_name=1000&federated_search_id=ab4d075d-66cb-4d6d-b9f3-39574ba3cce6")
);

        List<BestTimeToVisit> bestTimes = Arrays.asList(
    new BestTimeToVisit(
        "Summer", "High", "28–32°C", 5, "$$$",
        Arrays.asList("Istanbul Jazz Festival", "Bosphorus Swim"),
        "June–August", "Ideal for sightseeing and nightlife"
    )
);
 
        Cultural hagiaSophia = new Cultural();
        hagiaSophia.setName("Hagia Sophia Tour");
        hagiaSophia.setVenue("Sultanahmet");
        hagiaSophia.setPrice(15);
        hagiaSophia.setGuideIncluded(true);

        Cultural topkapi = new Cultural();
        topkapi.setName("Topkapi Palace Visit");
        topkapi.setVenue("Topkapi Palace");
        topkapi.setPrice(20);
        topkapi.setGuideIncluded(false);

        Cultural blueMosque = new Cultural();
        blueMosque.setName("Blue Mosque Tour");
        blueMosque.setVenue("Sultanahmet");
        blueMosque.setPrice(10);
        blueMosque.setGuideIncluded(true);

        Cultural sultanahmetWalk = new Cultural();
        sultanahmetWalk.setName("Sultanahmet Walking Tour");
        sultanahmetWalk.setVenue("Sultanahmet District");
        sultanahmetWalk.setPrice(10);
        sultanahmetWalk.setGuideIncluded(true);

        Cultural basilicaCistern = new Cultural();
        basilicaCistern.setName("Basilica Cistern Tour");
        basilicaCistern.setVenue("Sultanahmet");
        basilicaCistern.setPrice(15);
        basilicaCistern.setGuideIncluded(false);

        Cultural galata = new Cultural();
        galata.setName("Galata Tower Visit");
        galata.setVenue("Galata");
        galata.setPrice(30);
        galata.setGuideIncluded(false);

        Cultural dolmabahce = new Cultural();
        dolmabahce.setName("Dolmabahçe Palace Tour");
        dolmabahce.setVenue("Beşiktaş");
        dolmabahce.setPrice(40);
        dolmabahce.setGuideIncluded(true);

        Cultural grandBazaar = new Cultural();
        grandBazaar.setName("Grand Bazaar Exploration");
        grandBazaar.setVenue("Beyazıt");
        grandBazaar.setPrice(0);
        grandBazaar.setGuideIncluded(false);

        Cultural suleymaniye = new Cultural();
        suleymaniye.setName("Süleymaniye Mosque Visit");
        suleymaniye.setVenue("Fatih");
        suleymaniye.setPrice(0);
        suleymaniye.setGuideIncluded(true);

        Cultural kizKulesi = new Cultural();
        kizKulesi.setName("Maiden's Tower Tour");
        kizKulesi.setVenue("Salacak");
        kizKulesi.setPrice(30);
        kizKulesi.setGuideIncluded(false);

        Cultural peraMuseum = new Cultural();
        peraMuseum.setName("Pera Museum Visit");
        peraMuseum.setVenue("Beyoğlu");
        peraMuseum.setPrice(10);
        peraMuseum.setGuideIncluded(false);

        Cultural mehmedTomb = new Cultural();
        mehmedTomb.setName("Tomb of Mehmed the Magnificent");
        mehmedTomb.setVenue("Fatih");
        mehmedTomb.setPrice(0);
        mehmedTomb.setGuideIncluded(false);

        Cultural archaeologyMuseum = new Cultural();
        archaeologyMuseum.setName("Istanbul Archaeological Museums Visit");
        archaeologyMuseum.setVenue("Fatih");
        archaeologyMuseum.setPrice(15);
        archaeologyMuseum.setGuideIncluded(false);

        Adventure kayaking = new Adventure();
        kayaking.setName("Bosphorus Kayaking");
        kayaking.setPrice(40);
        kayaking.setDifficultyLevel("Medium");
        kayaking.setEquipmentRequired(true);

        Adventure belgrad = new Adventure();
        belgrad.setName("Hiking in Belgrad Forest");
        belgrad.setPrice(0);
        belgrad.setDifficultyLevel("Easy");
        belgrad.setEquipmentRequired(false);

        Adventure cycling = new Adventure();
        cycling.setName("Prince Islands Cycling Tour");
        cycling.setPrice(25);
        cycling.setDifficultyLevel("Easy");
        cycling.setEquipmentRequired(true);

        Adventure diving = new Adventure();
        diving.setName("Scuba Diving in Tuzla");
        diving.setPrice(90);
        diving.setDifficultyLevel("Hard");
        diving.setEquipmentRequired(true);

        Nightlife reina = new Nightlife();
        reina.setName("Reina Club");
        reina.setPrice(10);
        reina.setVenueType("Nightclub");
        reina.setOpeningTime("22:00");
        reina.setAgeRestriction(18);

        Nightlife supclub = new Nightlife();
        supclub.setName("Supperclub Istanbul");
        supclub.setPrice(20);
        supclub.setVenueType("Lounge & Club");
        supclub.setOpeningTime("23:00");
        supclub.setAgeRestriction(21);

        Nightlife babylon = new Nightlife();
        babylon.setName("Babylon Bomonti");
        babylon.setPrice(12);
        babylon.setVenueType("Live Music Venue");
        babylon.setOpeningTime("21:00");
        babylon.setAgeRestriction(18);

        Nightlife threeSixty = new Nightlife();
        threeSixty.setName("360 Istanbul");
        threeSixty.setPrice(15);
        threeSixty.setVenueType("Bar & Club");
        threeSixty.setOpeningTime("20:00");
        threeSixty.setAgeRestriction(18);

        Relaxation hamam = new Relaxation();
        hamam.setName("Cağaloğlu Hamam");
        hamam.setLocation("Fatih");
        hamam.setPrice(40);
        hamam.setIncludesMassage(true);

        Relaxation park = new Relaxation();
        park.setName("Gülhane Park");
        park.setLocation("Sirkeci");
        park.setPrice(0);
        park.setIncludesMassage(false);

        Relaxation moda = new Relaxation();
        moda.setName("Moda Coastal Walk");
        moda.setLocation("Kadıköy");
        moda.setPrice(0);
        moda.setIncludesMassage(false);

        Relaxation polonezkoy = new Relaxation();
        polonezkoy.setName("Polonezköy Nature Park");
        polonezkoy.setLocation("Beykoz");
        polonezkoy.setPrice(5);
        polonezkoy.setIncludesMassage(false);

        Relaxation islandsTour = new Relaxation();
        islandsTour.setName("Princes' Islands Tour");
        islandsTour.setLocation("Büyükada");
        islandsTour.setPrice(25);
        islandsTour.setIncludesMassage(false);

        hamam.setLocationType("Historical Bath");
        park.setLocationType("Park");
        moda.setLocationType("Seaside Walk");
        polonezkoy.setLocationType("Forest Park");
        islandsTour.setLocationType("Islands");

        List<Activity> activities = Arrays.asList(
            hagiaSophia, topkapi, blueMosque, sultanahmetWalk, basilicaCistern, galata, dolmabahce, grandBazaar, suleymaniye, kizKulesi, peraMuseum, mehmedTomb, archaeologyMuseum,          
            kayaking, belgrad, cycling, diving,
            reina, supclub, babylon, threeSixty,
            hamam, park, moda, polonezkoy, islandsTour
        );

    kayaking.setDescription("Paddle through the Bosphorus while enjoying city views and a light breeze.");
    kayaking.setRequiredEquipment(Arrays.asList("Life jacket", "Water shoes", "Dry bag"));

    belgrad.setDescription("A peaceful hike in Istanbul's largest forest, suitable for all levels.");

    cycling.setDescription("Explore the scenic Prince Islands by bike with sea views and quiet roads.");
    cycling.setRequiredEquipment(Arrays.asList("Bicycle", "Helmet", "Water bottle"));

    diving.setDescription("Dive into the Marmara Sea to explore marine life near the Tuzla coast.");
    diving.setRequiredEquipment(Arrays.asList("Scuba gear", "Wetsuit", "Oxygen tank"));

    hagiaSophia.setDescription("Discover the magnificent architecture and history of this former cathedral and mosque.");
    topkapi.setDescription("Explore the palace of Ottoman sultans with artifacts, weapons, and stunning views.");
    blueMosque.setDescription("Visit the iconic blue-tiled mosque and experience its spiritual atmosphere.");
    sultanahmetWalk.setDescription("Take a guided walk through the historical Sultanahmet district full of monuments.");
    basilicaCistern.setDescription("Visit the mysterious underground cistern with its iconic Medusa head columns.");
    galata.setDescription("Enjoy panoramic views of Istanbul from this medieval stone tower.");
    dolmabahce.setDescription("Explore the opulent halls of the palace that once housed Ottoman sultans and Atatürk.");
    grandBazaar.setDescription("Wander through one of the world's oldest covered markets with thousands of shops.");
    suleymaniye.setDescription("Admire the grandeur of this iconic mosque designed by architect Mimar Sinan.");
    kizKulesi.setDescription("Visit the legendary tower on a small islet, offering scenic views and tales of ancient love.");
    peraMuseum.setDescription("Explore exhibits of Orientalist art, Anatolian weights, and modern Turkish works.");
    mehmedTomb.setDescription("Pay respects at the tomb of the Ottoman Sultan who conquered Constantinople.");
    archaeologyMuseum.setDescription("Explore ancient artifacts and archaeological treasures from across the former Ottoman Empire.");


    reina.setVibeDescription("Upscale clubbing experience with Bosphorus views and live DJs.");
    supclub.setVibeDescription("Chic lounge with gourmet food and electronic beats.");
    babylon.setVibeDescription("Popular venue for live alternative and indie music.");
    threeSixty.setVibeDescription("Trendy rooftop bar with cocktails and panoramic city views.");

    hamam.setDescription("Historic Turkish bath offering steam rooms and massage packages.");
    park.setDescription("Peaceful park for picnics and walks among centuries-old trees.");
    moda.setDescription("Seaside walking path perfect for sunset views and relaxation.");
    polonezkoy.setDescription("Lush forest escape near the city for outdoor leisure.");
    islandsTour.setDescription("Enjoy a peaceful escape with horse-drawn carriages, seaside views, and charming streets.");

        List<FoodOption> foodOptions = Arrays.asList(
           new FoodOption("Kebap", "Zübeyir Ocakbaşı", "Istanbul", 15.0),
           new FoodOption("Balık Ekmek", "Eminönü Sahil", "Istanbul", 5.0),
           new FoodOption("Lahmacun", "Borsam Taşfırın", "Istanbul", 4.0),
           new FoodOption("Kumpir", "Ortaköy Meydanı", "Istanbul", 7.0),
           new FoodOption("Künefe", "Hatay Medeniyetler Sofrası", "Istanbul", 9.0),
           new FoodOption("Baklava", "Karaköy Güllüoğlu", "Istanbul", 10.0)
        );
        return new City(
    "Istanbul",
    "Turkey",
    "A historical city that bridges Europe and Asia.",
    places,
    transports,
    climates,
    accomodations,
    bestTimes,
    activities,
    foodOptions
);

    }
    public static City getParis() {
        List<Place> places = Arrays.asList();

        List<SeasonalClimate> climates = Arrays.asList(
            new SeasonalClimate("Spring", LocalDate.of(0, 3, 21), LocalDate.of(0, 6, 20), 16, 45, "Light jacket and umbrella"),
            new SeasonalClimate("Summer", LocalDate.of(0, 6, 21), LocalDate.of(0, 9, 22), 25, 20, "T-shirt and sunglasses"),
            new SeasonalClimate("Autumn", LocalDate.of(0, 9, 23), LocalDate.of(0, 12, 21), 14, 55, "Sweater and light raincoat"),
            new SeasonalClimate("Winter", LocalDate.of(0, 12, 22), LocalDate.of(0, 3, 20), 6, 60, "Warm coat, scarf, gloves")
        );

        List<TransportOption> transports = Arrays.asList(
            new TransportOption("Metro", 1.9, "05:30–01:15"),
            new TransportOption("RER Train", 2.5, "05:00–00:30"),
            new TransportOption("Bus", 1.9, "05:30–00:30"),
            new TransportOption("Tram", 1.9, "05:30–00:30"),
            new TransportOption("Taxi", 4.0, "24/7")
        );

        List<Accomodation> accomodations = Arrays.asList(
    new Accomodation("Hotel", 200.0, "Champs-Élysées", "https://www.trivago.com.tr/tr/oar/otel-rochester-champs-elysees-paris?search=100-50676"),
    new Accomodation("Hostel", 40.0, "Belleville", "https://www.trivago.com.tr/tr/oar/hostel-the-people-paris-belleville?search=100-5053390"),
    new Accomodation("Airbnb", 80.0, "Le Marais", "https://www.airbnb.com.tr/rooms/595477875637048954?adults=1&check_in=2025-06-09&check_out=2025-06-10&location=Le%20Marais%2C%20Paris%2C%20France&search_mode=regular_search&category_tag=Tag%3A8678&photo_id=1413931516&source_impression_id=p3_1747656366_P3fmAYPDehkkKfaY&previous_page_section_name=1001&federated_search_id=f2a3a63e-05fa-4652-94f2-4591584e655b")
);

        List<BestTimeToVisit> bestTimes = Arrays.asList(
    new BestTimeToVisit(
        "Spring", "Medium", "15–20°C", 4, "$$",
        Arrays.asList("Paris Marathon", "Nuit des Musées"),
        "April–May", "Romantic weather and blooming gardens"
    ),
    new BestTimeToVisit(
        "Autumn", "Low", "14–18°C", 3, "$",
        Arrays.asList("Montmartre Wine Harvest Festival"),
        "September–October", "Cool air and fewer tourists"
    )
);
        Cultural eiffel = new Cultural();
        eiffel.setName("Eiffel Tower Tour");
        eiffel.setVenue("Champ de Mars");
        eiffel.setPrice(25);
        eiffel.setGuideIncluded(true);

        Cultural louvre = new Cultural();
        louvre.setName("Louvre Museum Tour");
        louvre.setVenue("Louvre Museum");
        louvre.setPrice(17);
        louvre.setGuideIncluded(true);

        Cultural sainteChapelle = new Cultural();
        sainteChapelle.setName("Sainte-Chapelle Visit");
        sainteChapelle.setVenue("Île de la Cité");
        sainteChapelle.setPrice(11.5);
        sainteChapelle.setGuideIncluded(true);

        Cultural montSaintMichel = new Cultural();
        montSaintMichel.setName("Mont Saint-Michel Day Trip");
        montSaintMichel.setVenue("Normandy (Departs from Paris)");
        montSaintMichel.setPrice(90);
        montSaintMichel.setGuideIncluded(true);

        Adventure disneyland = new Adventure();
        disneyland.setName("Disneyland Paris Day Trip");
        disneyland.setPrice(105);
        disneyland.setDifficultyLevel("Easy");
        disneyland.setEquipmentRequired(false);

        Adventure balloon = new Adventure();
        balloon.setName("Hot Air Balloon Ride ");
        balloon.setPrice(200);
        balloon.setDifficultyLevel("Medium");
        balloon.setEquipmentRequired(false);

        Adventure bikeTour = new Adventure();
        bikeTour.setName("Seine River Bike Tour");
        bikeTour.setPrice(30);
        bikeTour.setDifficultyLevel("Easy");
        bikeTour.setEquipmentRequired(true);

        Relaxation tuileries = new Relaxation();
        tuileries.setName("Tuileries Garden");
        tuileries.setLocation("Near Louvre");
        tuileries.setPrice(0);
        tuileries.setIncludesMassage(false);

        Relaxation luxembourg = new Relaxation();
        luxembourg.setName("Luxembourg Gardens");
        luxembourg.setLocation("6th arrondissement");
        luxembourg.setPrice(0);
        luxembourg.setIncludesMassage(false);

        Relaxation seineWalk = new Relaxation();
        seineWalk.setName("Seine River Sunset Walk");
        seineWalk.setLocation("Seine Riverside");
        seineWalk.setPrice(0);
        seineWalk.setIncludesMassage(false);

        Relaxation spa = new Relaxation();
        spa.setName("Spa My Blend by Clarins");
        spa.setLocation("Le Royal Monceau");
        spa.setPrice(120);
        spa.setIncludesMassage(true);
        tuileries.setLocationType("Garden");
        luxembourg.setLocationType("Garden");
        seineWalk.setLocationType("River Walk");
        spa.setLocationType("Spa");

        tuileries.setDescription("Classic Parisian garden perfect for lounging and people-watching.");
        luxembourg.setDescription("A formal garden with fountains, statues and lawns.");
        seineWalk.setDescription("Romantic riverbank stroll especially beautiful at sunset.");
        spa.setDescription("Luxury spa experience inside a palace hotel near the Arc de Triomphe.");


        Nightlife moulinRouge = new Nightlife();
        moulinRouge.setName("Moulin Rouge Show");
        moulinRouge.setPrice(90);
        moulinRouge.setVenueType("Cabaret");
        moulinRouge.setOpeningTime("20:00");
        moulinRouge.setAgeRestriction(18);

        Nightlife seineCruise = new Nightlife();
        seineCruise.setName("Seine River Night Cruise");
        seineCruise.setPrice(25);
        seineCruise.setVenueType("Boat Tour");
        seineCruise.setOpeningTime("19:30");
        seineCruise.setAgeRestriction(0);

        Nightlife lesEtoiles = new Nightlife();
        lesEtoiles.setName("Les Étoiles Club");
        lesEtoiles.setPrice(15);
        lesEtoiles.setVenueType("Nightclub");
        lesEtoiles.setOpeningTime("22:00");
        lesEtoiles.setAgeRestriction(18);

        List<Activity> activities = Arrays.asList(
            eiffel, louvre, sainteChapelle, montSaintMichel,
            disneyland, balloon, bikeTour,
            tuileries, luxembourg, seineWalk, spa,
            moulinRouge, seineCruise, lesEtoiles
        );
        eiffel.setDescription("Climb to the top or take in the view from this world-famous iron tower.");
        louvre.setDescription("Discover world-renowned art including the Mona Lisa and Venus de Milo.");
        sainteChapelle.setDescription("Admire the stained glass windows in this Gothic-style royal chapel.");
        montSaintMichel.setDescription("Take a day trip to a historic island commune surrounded by tidal waters.");

        disneyland.setDescription("Enjoy thrilling rides and magical Disney shows just outside Paris.");
        balloon.setDescription("Float above the countryside in a colorful hot air balloon.");
        bikeTour.setDescription("Cycle along the Seine River with scenic stops and historical views.");
        bikeTour.setRequiredEquipment(Arrays.asList("Helmet", "Bicycle", "Water bottle"));

        tuileries.setDescription("Classic Parisian garden perfect for lounging and people-watching.");
        luxembourg.setDescription("A formal garden with fountains, statues and lawns.");
        seineWalk.setDescription("Romantic riverbank stroll especially beautiful at sunset.");
        spa.setDescription("Luxury spa experience inside a palace hotel near the Arc de Triomphe.");

        moulinRouge.setVibeDescription("Iconic cabaret shows with elaborate costumes and lively music.");
        seineCruise.setVibeDescription("Romantic and relaxing river cruise under Parisian bridges.");
        lesEtoiles.setVibeDescription("Trendy nightclub with international DJs and a youthful crowd.");
        List<FoodOption> foodOptions = Arrays.asList(
            new FoodOption("Croissant", "Du Pain et des Idées", "Paris", 2.5),
            new FoodOption("Escargot", "L'Escargot Montorgueil", "Paris", 15.0),
            new FoodOption("French Onion Soup", "Le Comptoir du Relais", "Paris", 12.0),
            new FoodOption("Crêpes", "Breizh Café", "Paris", 8.0),
            new FoodOption("Macarons", "Pierre Hermé", "Paris", 10.0),
            new FoodOption("Ratatouille", "Le Procope", "Paris", 18.0)
        );

        return new City(
            "Paris",
            "France",
            "The romantic and cultural capital of Europe.",
            places,
            transports,
            climates,
            accomodations,
            bestTimes,
            activities,
            foodOptions
        );
    }
     public static City getRome() {
        List<Place> places = Arrays.asList();

        List<SeasonalClimate> climates = Arrays.asList(
            new SeasonalClimate("Spring", LocalDate.of(0, 3, 21), LocalDate.of(0, 6, 20), 18, 40, "Light jacket or sweater"),
        new SeasonalClimate("Summer", LocalDate.of(0, 6, 21), LocalDate.of(0, 9, 22), 31, 25, "T-shirt, hat, sunscreen"),
        new SeasonalClimate("Autumn", LocalDate.of(0, 9, 23), LocalDate.of(0, 12, 21), 20, 35, "Light layers"),
        new SeasonalClimate("Winter", LocalDate.of(0, 12, 22), LocalDate.of(0, 3, 20), 11, 50, "Coat and umbrella")
        );

        List<TransportOption> transports = Arrays.asList(
            new TransportOption("Metro", 1.5, "05:30–23:30"),
            new TransportOption("Bus", 1.5, "05:00–00:00"),
            new TransportOption("Tram", 1.5, "05:00–00:00"),
            new TransportOption("Taxi", 3.0, "24/7"),
            new TransportOption("Bike Sharing", 0.5, "24/7")
        );

        List<Accomodation> accomodations = Arrays.asList(
    new Accomodation("Hotel", 190.0, "City Center", "https://www.tripadvisor.com.tr/Hotel_Review-g187791-d21358351-Reviews-Sonder_Piazza_San_Pietro-Rome_Lazio.html"),
    new Accomodation("Hostel", 80.0, "Trastevere", "https://www.etstur.com/The-Romehello--Hostel-21219975"),
    new Accomodation("Airbnb", 75.0, "Campo de' Fiori", "https://www.airbnb.com.tr/rooms/34475090?adults=1&check_in=2025-05-29&check_out=2025-05-30&search_mode=regular_search&source_impression_id=p3_1747656649_P3HadXeCfjyn6A7f&previous_page_section_name=1000&federated_search_id=dc431d8e-fced-43b6-a656-ee386752584e")
);

       List<BestTimeToVisit> bestTimes = Arrays.asList(
    new BestTimeToVisit(
        "Spring", "High", "18–24°C", 4, "$$",
        Arrays.asList("Roma Spring Fair"),
        "March–May", "Pleasant weather and vibrant city life"
    )
);

        Cultural colosseum = new Cultural();
        colosseum.setName("Colosseum Guided Tour");
        colosseum.setVenue("Colosseum");
        colosseum.setPrice(18);
        colosseum.setGuideIncluded(true);

        Cultural vatican = new Cultural();
        vatican.setName("Vatican Museums & Sistine Chapel");
        vatican.setVenue("Vatican City");
        vatican.setPrice(25);
        vatican.setGuideIncluded(true);

        Cultural pantheon = new Cultural();
        pantheon.setName("Pantheon Visit");
        pantheon.setVenue("Piazza della Rotonda");
        pantheon.setPrice(0);
        pantheon.setGuideIncluded(false);

        Cultural forum = new Cultural();
        forum.setName("Roman Forum & Palatine Hill");
        forum.setVenue("Via dei Fori Imperiali");
        forum.setPrice(16);
        forum.setGuideIncluded(true);

        Cultural angelCastle = new Cultural();
        angelCastle.setName("Castel Sant'Angelo Visit");
        angelCastle.setVenue("Lungotevere Castello");
        angelCastle.setPrice(14);
        angelCastle.setGuideIncluded(false);

        Adventure segway = new Adventure();
        segway.setName("Rome Segway Tour");
        segway.setPrice(45);
        segway.setDifficultyLevel("Easy");
        segway.setEquipmentRequired(true);

        Adventure vespa = new Adventure();
        vespa.setName("Vespa City Tour");
        vespa.setPrice(60);
        vespa.setDifficultyLevel("Medium");
        vespa.setEquipmentRequired(true);

        Adventure bike = new Adventure();
        bike.setName("Appian Way Bike Ride");
        bike.setPrice(25);
        bike.setDifficultyLevel("Easy");
        bike.setEquipmentRequired(true);

        Adventure tiberRafting = new Adventure();
        tiberRafting.setName("Rafting on the Tiber River");
        tiberRafting.setPrice(35);
        tiberRafting.setDifficultyLevel("Medium");
        tiberRafting.setEquipmentRequired(true);

        Relaxation park = new Relaxation();
        park.setName("Villa Borghese Gardens");
        park.setLocation("City Center");
        park.setPrice(0);
        park.setIncludesMassage(false);

        Relaxation spa = new Relaxation();
        spa.setName("QC Terme Roma Spa");
        spa.setLocation("Fiumicino");
        spa.setPrice(50);
        spa.setIncludesMassage(true);

        Relaxation janiculum = new Relaxation();
        janiculum.setName("Janiculum Hill Walk");
        janiculum.setLocation("Trastevere");
        janiculum.setPrice(0);
        janiculum.setIncludesMassage(false);
        park.setLocationType("Urban Park");
        spa.setLocationType("Spa");
        janiculum.setLocationType("Hill Walk");

        park.setDescription("Relax in the lush greenery of Rome’s most famous public park.");
        spa.setDescription("Pamper yourself at a luxurious Roman spa with full massage services.");
        janiculum.setDescription("Enjoy panoramic views of Rome during a peaceful hilltop walk.");
        Nightlife trastevere = new Nightlife();
        trastevere.setName("Trastevere Bar Crawl");
        trastevere.setPrice(20);
        trastevere.setVenueType("Pub Crawl");
        trastevere.setOpeningTime("21:00");
        trastevere.setAgeRestriction(18);

        Nightlife gilda = new Nightlife();
        gilda.setName("Gilda Club");
        gilda.setPrice(15);
        gilda.setVenueType("Nightclub");
        gilda.setOpeningTime("23:00");
        gilda.setAgeRestriction(18);

        Nightlife shariVari = new Nightlife();
        shariVari.setName("Shari Vari Playhouse");
        shariVari.setPrice(10);
        shariVari.setVenueType("Dance Club");
        shariVari.setOpeningTime("22:00");
        shariVari.setAgeRestriction(18);

        List<Activity> activities = Arrays.asList(
            colosseum, vatican, pantheon, forum, angelCastle,
            segway, vespa, bike, tiberRafting,
            park, spa, janiculum,
            trastevere, gilda, shariVari
        );

        List<FoodOption> foodOptions = Arrays.asList(
            new FoodOption("Carbonara", "Roscioli", "Rome", 14.0),
            new FoodOption("Cacio e Pepe", "Felice a Testaccio", "Rome", 13.0),
            new FoodOption("Gelato", "Giolitti", "Rome", 5.0),
            new FoodOption("Pizza", "Pizzarium", "Rome", 6.0),
            new FoodOption("Tiramisu", "Pompi", "Rome", 6.0),
            new FoodOption("Artichokes (Carciofi)", "Nonna Betta", "Rome", 12.0),
            new FoodOption("Lasagna", "Trattoria Vecchia Roma", "Rome", 11.0)
        );
        colosseum.setDescription("Tour the ancient Roman amphitheater and learn its gladiator history.");
        vatican.setDescription("Explore the vast art collections and Sistine Chapel of the Vatican Museums.");
        pantheon.setDescription("Marvel at the domed temple dedicated to Roman gods.");
        forum.setDescription("Walk through the ruins of political and religious life in ancient Rome.");
        angelCastle.setDescription("Visit this round castle with panoramic views of the Tiber River.");

        segway.setDescription("Glide through Rome's streets effortlessly with a Segway tour.");
        segway.setRequiredEquipment(Arrays.asList("Helmet", "Segway"));

        vespa.setDescription("Ride like a local through Rome's charming alleys on a Vespa.");
        vespa.setRequiredEquipment(Arrays.asList("Vespa", "Helmet"));

        bike.setDescription("Pedal along the Appian Way, one of the oldest roads of ancient Rome.");
        bike.setRequiredEquipment(Arrays.asList("Bike", "Helmet"));

        tiberRafting.setDescription("Experience an urban rafting adventure through the Tiber River.");
        tiberRafting.setRequiredEquipment(Arrays.asList("Life jacket", "Rafting paddle", "Waterproof gear"));

        park.setDescription("Relax in the lush greenery of Rome’s most famous public park.");
        spa.setDescription("Pamper yourself at a luxurious Roman spa with full massage services.");
        janiculum.setDescription("Enjoy panoramic views of Rome during a peaceful hilltop walk.");

        trastevere.setVibeDescription("Lively and laid-back with a mix of tourists and locals.");
        gilda.setVibeDescription("Trendy and upscale nightlife experience in the heart of Rome.");
        shariVari.setVibeDescription("High-energy dance music in a modern Roman club setting.");
        return new City(
            "Rome",
            "Italy",
            "The Eternal City full of ancient wonders and romantic streets.",
            places,
            transports,
            climates,
            accomodations,
            bestTimes,
            activities,
            foodOptions
        );
    }
    public static City getBerlin() {
        List<Place> places = Arrays.asList();

        List<SeasonalClimate> climates = Arrays.asList(
            new SeasonalClimate("Spring", LocalDate.of(0, 3, 21), LocalDate.of(0, 6, 20), 12, 40, "Light sweater"),
            new SeasonalClimate("Summer", LocalDate.of(0, 6, 21), LocalDate.of(0, 9, 22), 24, 30, "T-shirt and shorts"),
            new SeasonalClimate("Autumn", LocalDate.of(0, 9, 23), LocalDate.of(0, 12, 21), 14, 50, "Light jacket"),
            new SeasonalClimate("Winter", LocalDate.of(0, 12, 22), LocalDate.of(0, 3, 20), 2, 60, "Winter coat")
        );

        List<TransportOption> transports = Arrays.asList(
            new TransportOption("U-Bahn", 3.0, "04:30–01:00"),
            new TransportOption("S-Bahn", 3.0, "04:30–01:00"),
            new TransportOption("Bus", 2.8, "Frequent"),
            new TransportOption("Tram", 2.8, "Frequent"),
            new TransportOption("Bike", 0.0, "24/7")
        );

        List<Accomodation> accomodations = Arrays.asList(
    new Accomodation("Hotel", 200.0, "Alexanderplatz", "https://www.etstur.com/Classik-Hotel-Alexander-Plaza-525997"),
    new Accomodation("Hostel", 70.0, "Friedrichshain", "https://www.tripadvisor.com.tr/Hotel_Review-g187323-d285486-Reviews-Sunflower_Hostel_Berlin-Berlin.html"),
    new Accomodation("Airbnb", 160.0, "Kreuzberg", "https://www.airbnb.com.tr/rooms/1331360749251423773?adults=1&check_in=2025-05-30&check_out=2025-05-31&search_mode=regular_search&source_impression_id=p3_1747657489_P3uzD5gvq9O7D-ab&previous_page_section_name=1000&federated_search_id=39aa5b6e-6993-43ae-97fe-e6e958bcaa65")
);

        List<BestTimeToVisit> bestTimes = Arrays.asList(
    new BestTimeToVisit(
        "Summer", "High", "22–26°C", 5, "$$$",
        Arrays.asList("Berlin Music Festival"),
        "June–August", "Great for outdoor festivals and sightseeing"
    )
);

        Cultural museumIsland = new Cultural();
        museumIsland.setName("Museum Island Tour");
        museumIsland.setVenue("Museum Island");
        museumIsland.setPrice(18);
        museumIsland.setGuideIncluded(true);

        Cultural berlinWall = new Cultural();
        berlinWall.setName("Berlin Wall Memorial Visit");
        berlinWall.setVenue("Bernauer Str.");
        berlinWall.setPrice(0);
        berlinWall.setGuideIncluded(false);

        Cultural brandenburg = new Cultural();
        brandenburg.setName("Brandenburg Gate Visit");
        brandenburg.setVenue("Pariser Platz");
        brandenburg.setPrice(0);
        brandenburg.setGuideIncluded(true);
 
        Cultural jewishMuseum = new Cultural();
        jewishMuseum.setName("Jewish Museum Berlin");
        jewishMuseum.setVenue("Lindenstrasse");
        jewishMuseum.setPrice(8);
        jewishMuseum.setGuideIncluded(true);
    
        Cultural streetArtTour = new Cultural();
        streetArtTour.setName("Street Art Walking Tour");
        streetArtTour.setVenue("Kreuzberg");
        streetArtTour.setPrice(15);
        streetArtTour.setGuideIncluded(true);

        Adventure hiking  = new Adventure();
        hiking.setName("Teufelsberg Hiking");
        hiking.setPrice(0);
        hiking.setDifficultyLevel("Easy");
        hiking.setEquipmentRequired(false);

        Adventure climbing = new Adventure();
        climbing.setName("Climbing in Magic Mountain");
        climbing.setPrice(25);
        climbing.setDifficultyLevel("Medium");
        climbing.setEquipmentRequired(true);

        Adventure paddling = new Adventure();
        paddling.setName("Stand-Up Paddling on Müggelsee");
        paddling.setPrice(20);
        paddling.setDifficultyLevel("Easy");
        paddling.setEquipmentRequired(true);

        Adventure canoe = new Adventure();
        canoe.setName("Canoeing at Wannsee");
        canoe.setPrice(25);
        canoe.setDifficultyLevel("Medium");
        canoe.setEquipmentRequired(true);

        Adventure highSwing = new Adventure();
        highSwing.setName("High Swing Parkour");
        highSwing.setPrice(35);
        highSwing.setDifficultyLevel("Hard");
        highSwing.setEquipmentRequired(true);

        Nightlife berghain = new Nightlife();
        berghain.setName("Berghain");
        berghain.setPrice(20);
        berghain.setVenueType("Techno Club");
        berghain.setOpeningTime("00:00");
        berghain.setAgeRestriction(18);

        Nightlife maxxim = new Nightlife();
        maxxim.setName("Maxxim Berlin");
        maxxim.setPrice(10);
        maxxim.setVenueType("Nightclub");
        maxxim.setOpeningTime("22:00");
        maxxim.setAgeRestriction(18);

        Nightlife sisyphos = new Nightlife();
        sisyphos.setName("Sisyphos Club");
        sisyphos.setPrice(15);
        sisyphos.setVenueType("Open-Air Club");
        sisyphos.setOpeningTime("22:00");
        sisyphos.setAgeRestriction(18);

        Nightlife clärchens = new Nightlife();
        clärchens.setName("Clärchens Ballhaus");
        clärchens.setPrice(8);
        clärchens.setVenueType("Dance Hall & Bar");
        clärchens.setOpeningTime("20:00");
        clärchens.setAgeRestriction(18);

        Relaxation spa = new Relaxation();
        spa.setName("Vabali Spa");
        spa.setLocation("Tiergarten");
        spa.setPrice(35);
        spa.setIncludesMassage(true);

        Relaxation park = new Relaxation();
        park.setName("Tiergarten Park");
        park.setLocation("Central Berlin");
        park.setPrice(0);
        park.setIncludesMassage(false);

        Relaxation lake = new Relaxation();
        lake.setName("Liepnitzsee Lake");
        lake.setLocation("Brandenburg");
        lake.setPrice(0);
        lake.setIncludesMassage(false);

        Relaxation garden = new Relaxation();
        garden.setName("Botanical Garden");
        garden.setLocation("Lichterfelde");
        garden.setPrice(6);
        garden.setIncludesMassage(false);
        spa.setLocationType("Spa");
        park.setLocationType("Park");
        lake.setLocationType("Lake");
        garden.setLocationType("Botanical Garden");

        spa.setDescription("Asian-inspired wellness spa offering pools, saunas, and massages.");
        park.setDescription("Central Berlin’s most famous park for walks and sunbathing.");
        lake.setDescription("Nature escape ideal for swimming and relaxation.");
        garden.setDescription("Botanical collection with greenhouses and rare plants.");

        List<Activity> activities = Arrays.asList(
            museumIsland, berlinWall, brandenburg, jewishMuseum, streetArtTour, 
            hiking, climbing, paddling, canoe, highSwing,
            berghain, maxxim, sisyphos, clärchens,
            spa, park, lake, garden
        );
        museumIsland.setDescription("Discover five world-class museums on a single island in Berlin.");
        berlinWall.setDescription("Explore the historic remains of the Berlin Wall and learn about the Cold War.");
        brandenburg.setDescription("Visit Berlin's iconic neoclassical gate and symbol of unity.");
        jewishMuseum.setDescription("Explore the largest Jewish museum in Europe with unique architecture.");
        streetArtTour.setDescription("Experience Berlin’s edgy and creative spirit through graffiti and murals.");

        hiking.setDescription("An easy hike up a man-made hill with great city views.");
        climbing.setDescription("Indoor rock climbing challenge for all skill levels.");
        climbing.setRequiredEquipment(Arrays.asList("Climbing shoes", "Harness", "Helmet"));

        paddling.setDescription("Paddle peacefully on Müggelsee, Berlin’s largest lake.");
        paddling.setRequiredEquipment(Arrays.asList("Paddle board", "Life jacket"));

        canoe.setDescription("Canoe adventure around forested lakes and calm waters.");
        canoe.setRequiredEquipment(Arrays.asList("Canoe", "Paddle", "Water shoes"));

        highSwing.setDescription("Test your courage on a high-ropes parkour adventure.");
        highSwing.setRequiredEquipment(Arrays.asList("Harness", "Helmet", "Gloves"));

        berghain.setVibeDescription("Legendary underground club with strict door policy and techno beats.");
        maxxim.setVibeDescription("Glamorous clubbing venue with multiple floors and pop music.");
        sisyphos.setVibeDescription("Open-air clubbing space with artistic installations and Berlin flair.");
        clärchens.setVibeDescription("Old-school ballroom dance hall with a cozy garden vibe.");

        spa.setDescription("Asian-inspired wellness spa offering pools, saunas, and massages.");
        park.setDescription("Central Berlin’s most famous park for walks and sunbathing.");
        lake.setDescription("Nature escape ideal for swimming and relaxation.");
        garden.setDescription("Botanical collection with greenhouses and rare plants.");

        List<FoodOption> foodOptions = Arrays.asList(
            new FoodOption("Currywurst", "Curry 36", "Berlin", 4.5),
            new FoodOption("Döner", "Mustafa's Gemüse Kebap", "Berlin", 5.0),
            new FoodOption("Berliner Pfannkuchen", "Bäckerei Siebert", "Berlin", 2.0),
            new FoodOption("Schnitzel", "Zur letzten Instanz", "Berlin", 16.0),
            new FoodOption("Kartoffelsalat", "Max & Moritz", "Berlin", 6.5),
            new FoodOption("Apfelstrudel", "Café Einstein", "Berlin", 5.5)
);


        return new City(
            "Berlin",
            "Germany",
            "A city of culture, history, and vibrant modern life.",
            places,
            transports,
            climates,
            accomodations,
            bestTimes,
            activities,
            foodOptions
        );
    }
    public static City getBarcelona() {
        List<Place> places = Arrays.asList();

        List<SeasonalClimate> climates = Arrays.asList(
            new SeasonalClimate("Spring", LocalDate.of(0, 3, 21), LocalDate.of(0, 6, 20), 18, 40, "Light clothing, jacket for evenings"),
            new SeasonalClimate("Summer", LocalDate.of(0, 6, 21), LocalDate.of(0, 9, 22), 29, 20, "Shorts, t-shirt, sunscreen"),
            new SeasonalClimate("Autumn", LocalDate.of(0, 9, 23), LocalDate.of(0, 12, 21), 21, 45, "Light jacket or sweater"),
            new SeasonalClimate("Winter", LocalDate.of(0, 12, 22), LocalDate.of(0, 3, 20), 13, 50, "Coat or warm layers")
        );

        List<TransportOption> transports = Arrays.asList(
            new TransportOption("Metro", 2.4, "05:00–00:00"),
            new TransportOption("Bus", 2.4, "24/7"),
            new TransportOption("Tram", 2.4, "05:00–00:00"),
            new TransportOption("Bike Rental", 1.5, "24/7"),
            new TransportOption("Taxi", 3.0, "24/7")
        );

        List<Accomodation> accomodations = Arrays.asList(
    new Accomodation("Hotel", 230.0, "La Rambla", "https://www.tripadvisor.com.tr/Hotel_Review-g187497-d232778-Reviews-Hotel_Arc_La_Rambla-Barcelona_Catalonia.html"),
    new Accomodation("Hostel", 70.0, "El Raval", "https://www.trivago.com.tr/tr/lm/hellobcn-youth-hostel-barcelona-barselona?search=100-1189100;dr-20250601-20250602-s;rc-1-1#::hasInteracted=true"),
    new Accomodation("Airbnb", 85.0, "Gràcia", "https://www.airbnb.com.tr/rooms/1284672054446846600?adults=1&check_in=2025-05-29&check_out=2025-05-30&location=Gr%C3%A0cia%2C%20Barcelona%2C%20Spain&search_mode=regular_search&category_tag=Tag%3A8678&photo_id=2025646368&source_impression_id=p3_1747657737_P34Nkvt6unXSNQMJ&previous_page_section_name=1001&federated_search_id=60f1e5f6-8619-4e2c-b9f3-eeec5e2bd01a")
);

        List<BestTimeToVisit> bestTimes = Arrays.asList(
    new BestTimeToVisit(
        "Spring", "High", "17–22°C", 5, "$$$",
        Arrays.asList("Primavera Sound Festival", "Sant Jordi Day"),
        "April–June", "Festive atmosphere and beach days"
    )
);

        Cultural sagrada = new Cultural();
        sagrada.setName("Sagrada Familia Tour");
        sagrada.setVenue("Eixample");
        sagrada.setPrice(26);
        sagrada.setGuideIncluded(true);

        Cultural parkGuell = new Cultural();
        parkGuell.setName("Park Güell Visit");
        parkGuell.setVenue("Gràcia");
        parkGuell.setPrice(10);
        parkGuell.setGuideIncluded(false);

        Cultural gothic = new Cultural();
        gothic.setName("Gothic Quarter Walking Tour");
        gothic.setVenue("Old City");
        gothic.setPrice(15);
        gothic.setGuideIncluded(true);

        Cultural picasso = new Cultural();
        picasso.setName("Picasso Museum Visit");
        picasso.setVenue("El Born");
        picasso.setPrice(12);
        picasso.setGuideIncluded(false);

        Cultural montjuic = new Cultural();
        montjuic.setName("Montjuïc Castle Visit");
        montjuic.setVenue("Montjuïc Hill");
        montjuic.setPrice(5);
        montjuic.setGuideIncluded(true);


        Adventure jetski = new Adventure();
        jetski.setName("Jet Ski in Barceloneta");
        jetski.setPrice(70);
        jetski.setDifficultyLevel("Medium");
        jetski.setEquipmentRequired(true);

        Adventure montserrat = new Adventure();
        montserrat.setName("Montserrat Hiking Tour");
        montserrat.setPrice(40);
        montserrat.setDifficultyLevel("Medium");
        montserrat.setEquipmentRequired(true);

        Adventure kayak = new Adventure();
        kayak.setName("Kayaking & Snorkeling Tour");
        kayak.setPrice(60);
        kayak.setDifficultyLevel("Medium");
        kayak.setEquipmentRequired(true);

        Adventure ebike = new Adventure();
        ebike.setName("Electric Bike City Tour");
        ebike.setPrice(35);
        ebike.setDifficultyLevel("Easy");
        ebike.setEquipmentRequired(true);

        Relaxation beach = new Relaxation();
        beach.setName("Barceloneta Beach");
        beach.setLocation("Seaside");
        beach.setPrice(0);
        beach.setIncludesMassage(false);

        Relaxation ciutadella = new Relaxation();
        ciutadella.setName("Ciutadella Park Picnic");
        ciutadella.setLocation("Ciutat Vella");
        ciutadella.setPrice(0);
        ciutadella.setIncludesMassage(false);

        Relaxation rooftop = new Relaxation();
        rooftop.setName("Rooftop Sunset Walk");
        rooftop.setLocation("City Center Terraces");
        rooftop.setPrice(0);
        rooftop.setIncludesMassage(false);

        Relaxation baths = new Relaxation();
        baths.setName("Aire Ancient Baths");
        baths.setLocation("El Born");
        baths.setPrice(70);
        baths.setIncludesMassage(true);
        beach.setLocationType("Beach");
        ciutadella.setLocationType("Park");
        rooftop.setLocationType("Terrace");
        baths.setLocationType("Spa");

        beach.setDescription("Barcelona’s iconic beach perfect for sunbathing and swimming.");
        ciutadella.setDescription("Historic city park with zoo, museums, and lush lawns.");
        rooftop.setDescription("Enjoy panoramic rooftop views at sunset from city terraces.");
        baths.setDescription("Ancient-style bathhouse with relaxing pools and massage rooms.");


        Nightlife opium = new Nightlife();
        opium.setName("Opium Barcelona");
        opium.setPrice(20);
        opium.setVenueType("Beach Club");
        opium.setOpeningTime("23:00");
        opium.setAgeRestriction(18);

        Nightlife razzmatazz = new Nightlife();
        razzmatazz.setName("Razzmatazz");
        razzmatazz.setPrice(15);
        razzmatazz.setVenueType("Concert Venue & Club");
        razzmatazz.setOpeningTime("22:30");
        razzmatazz.setAgeRestriction(18);

        Nightlife flamenco = new Nightlife();
        flamenco.setName("Flamenco Night Show");
        flamenco.setPrice(35);
        flamenco.setVenueType("Live Performance");
        flamenco.setOpeningTime("20:30");
        flamenco.setAgeRestriction(0);

        Nightlife icebar = new Nightlife();
        icebar.setName("Icebar Barcelona");
        icebar.setPrice(18);
        icebar.setVenueType("Ice Lounge");
        icebar.setOpeningTime("17:00");
        icebar.setAgeRestriction(18);

        List<Activity> activities = Arrays.asList(
            sagrada, parkGuell, gothic, picasso,montjuic,
            jetski, montserrat, kayak, ebike,
            beach, ciutadella, rooftop, baths,
            opium, razzmatazz, flamenco, icebar
        );
        sagrada.setDescription("Marvel at Gaudí’s unfinished cathedral and its surreal architecture.");
        parkGuell.setDescription("Wander through colorful mosaics and sculpted gardens by Gaudí.");
        gothic.setDescription("Walk through narrow alleys filled with history in the Gothic Quarter.");
        picasso.setDescription("Explore Picasso's early works and artistic journey.");
        montjuic.setDescription("Visit the mountaintop castle with panoramic views of the city.");

        jetski.setDescription("Ride a jet ski along Barcelona’s sunny coastline.");
        jetski.setRequiredEquipment(Arrays.asList("Jet ski", "Life jacket"));

        montserrat.setDescription("A scenic hike through rugged mountains with stunning views.");
        montserrat.setRequiredEquipment(Arrays.asList("Hiking shoes", "Backpack", "Snacks"));

        kayak.setDescription("Combine kayaking and snorkeling in hidden beach coves.");
        kayak.setRequiredEquipment(Arrays.asList("Kayak", "Snorkel gear", "Water shoes"));

        ebike.setDescription("Effortlessly explore the city with an electric bike tour.");
        ebike.setRequiredEquipment(Arrays.asList("E-bike", "Helmet"));

        beach.setDescription("Barcelona’s iconic beach perfect for sunbathing and swimming.");
        ciutadella.setDescription("Historic city park with zoo, museums, and lush lawns.");
        rooftop.setDescription("Enjoy panoramic rooftop views at sunset from city terraces.");
        baths.setDescription("Ancient-style bathhouse with relaxing pools and massage rooms.");

        opium.setVibeDescription("Trendy beachside club with international DJs and ocean views.");
        razzmatazz.setVibeDescription("Massive club with multiple music halls and concert stage.");
        flamenco.setVibeDescription("Traditional flamenco performance with dinner and drinks.");
        icebar.setVibeDescription("Frozen bar experience with drinks served below 0°C.");
        List<FoodOption> foodOptions = Arrays.asList(
            new FoodOption("Tapas", "El Xampanyet", "Barcelona", 12.0),
            new FoodOption("Paella", "7 Portes", "Barcelona", 18.0),
            new FoodOption("Patatas Bravas", "Bar Tomás", "Barcelona", 5.0),
            new FoodOption("Churros", "Granja Dulcinea", "Barcelona", 4.0),
            new FoodOption("Seafood Platter", "La Paradeta", "Barcelona", 22.0),
            new FoodOption("Crema Catalana", "Can Culleretes", "Barcelona", 6.0)
        );

        return new City(
            "Barcelona",
            "Spain",
            "A vibrant seaside city of art, architecture, and nightlife.",
            places,
            transports,
            climates,
            accomodations,
            bestTimes,
            activities,
            foodOptions
        );
    }
}    