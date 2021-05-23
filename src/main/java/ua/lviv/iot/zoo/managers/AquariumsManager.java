package ua.lviv.iot.zoo.managers;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.EqualsAndHashCode;
import ua.lviv.iot.zoo.models.animals.AquariumAnimal;
import ua.lviv.iot.zoo.models.aquariums.Aquarium;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class AquariumsManager extends ZooManager{
    private List<Aquarium> allAquariums;
    private List<AquariumAnimal> allAquariumAnimals;

    public List<AquariumAnimal> sortAquariumAnimalsByAquariumCapacity(final List<AquariumAnimal> animalListToSort, boolean isSortAsc) {
        animalListToSort.sort(
                Comparator.comparing(AquariumAnimal::getRequiredAquariumCapacityLiters)
        );
        if (!isSortAsc) {
            Collections.reverse(animalListToSort);
        }
        return animalListToSort;
    }

    public Aquarium requestAquariumForAnimal(final AquariumAnimal chosenAnimal, final int temperatureDeviation) {
        return Aquarium.builder()
                .capacityInLiters(chosenAnimal.getRequiredAquariumCapacityLiters())
                .supportedMaxTemperature(
                        chosenAnimal.getRequiredTemperature() + temperatureDeviation
                )
                .supportedMinTemperature(
                        chosenAnimal.getRequiredTemperature() - temperatureDeviation
                )
                .supportedLightingLevel(chosenAnimal.getRequiredLightingLevel())
                .build();
    }
}
