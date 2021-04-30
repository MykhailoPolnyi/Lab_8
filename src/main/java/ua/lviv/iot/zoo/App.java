package ua.lviv.iot.zoo;


import ua.lviv.iot.zoo.managers.AquariumsManager;
import ua.lviv.iot.zoo.managers.ZooManager;
import ua.lviv.iot.zoo.models.animals.AquariumAnimal;
import ua.lviv.iot.zoo.models.aquariums.Aquarium;
import ua.lviv.iot.zoo.models.animals.Fish;
import ua.lviv.iot.zoo.models.enumerators.LightingLevel;
import ua.lviv.iot.zoo.models.enumerators.ThermoregulationType;

import java.util.ArrayList;
import java.util.Arrays;


public class App {

    public static void main(String[] args) {
        Aquarium bigAquarium = Aquarium.builder()
                .capacityInLiters(300)
                .supportedMaxTemperature(23)
                .supportedMinTemperature(20)
                .supportedLightingLevel(LightingLevel.BRIGHT)
                .supportedLightingLevel(LightingLevel.MIDDLE)
                .build();

        Aquarium smallAquarium = Aquarium.builder()
                .capacityInLiters(150)
                .supportedMaxTemperature(25)
                .supportedMinTemperature(20)
                .supportedLightingLevel(LightingLevel.BRIGHT)
                .build();

        Aquarium middleAquarium = Aquarium.builder()
                .supportedLightingLevel(LightingLevel.DARK)
                .supportedLightingLevel(LightingLevel.MIDDLE)
                .supportedMinTemperature(22)
                .supportedMaxTemperature(25)
                .capacityInLiters(200)
                .build();


        Fish clownfish = Fish.builder()
                .color("Yellow")
                .animalType("Clownfish")
                .isCartilaginous(true)
                .weightInKg(5)
                .requiredAquariumCapacityLiters(100)
                .lifetimeYears(6)
                .requiredLightingLevel(LightingLevel.BRIGHT)
                .thermoregulation(ThermoregulationType.COLDBLOODED)
                .requiredTemperature(23)
                .currentAquarium(smallAquarium)
                .build();

        Fish shark = Fish.builder()
                .currentAquarium(bigAquarium)
                .thermoregulation(ThermoregulationType.COLDBLOODED)
                .requiredTemperature(22)
                .isCartilaginous(true)
                .weightInKg(200)
                .color("Gray")
                .animalType("Gray Shark")
                .requiredAquariumCapacityLiters(300)
                .lifetimeYears(7)
                .requiredLightingLevel(LightingLevel.MIDDLE)
                .build();

        AquariumAnimal dolphin = AquariumAnimal.builder()
                .requiredAquariumCapacityLiters(200)
                .lifetimeYears(4)
                .animalType("Dolphin")
                .requiredLightingLevel(LightingLevel.BRIGHT)
                .thermoregulation(ThermoregulationType.WARMBLOODED)
                .requiredTemperature(25)
                .weightInKg(80)
                .currentAquarium(middleAquarium)
                .build();


        ZooManager peter = new ZooManager(new ArrayList<>(Arrays.asList(clownfish, shark, dolphin)));

        AquariumsManager andrew = new AquariumsManager(
                new ArrayList<>(Arrays.asList(smallAquarium, bigAquarium, middleAquarium)),
                new ArrayList<>(Arrays.asList(clownfish, shark, dolphin))
        );


        System.out.println("\n-----Check AquariumsManager method - sortAquariumAnimalsByAquariumCapacity-----");
        System.out.println("Before sorting:");
        andrew.getAllAquariumAnimals()
                .forEach(aquariumAnimal -> System.out.println(aquariumAnimal.getCurrentAquarium()));
        andrew.sortAquariumAnimalsByAquariumCapacity(andrew.getAllAquariumAnimals(), true);
        System.out.println("After sorting(ascending sorting):");
        andrew.getAllAquariumAnimals()
                .forEach(aquariumAnimal -> System.out.println(aquariumAnimal.getCurrentAquarium()));

        System.out.println("\n-----Check AquariumsManager method - requestAquariumForAnimal-----");
        System.out.println(andrew.requestAquariumForAnimal(dolphin, 3));


        System.out.println("\n-----Check ZooManager method - getAllAnimalsOver5yo.-----\n"
                + "Animals also sorted by their type(ascending sorting): ");
        peter.getAllAnimalsOver5yo(peter.getAllAnimals(), true)
                .forEach(animal -> System.out.println(animal.toString()));

    }
}
