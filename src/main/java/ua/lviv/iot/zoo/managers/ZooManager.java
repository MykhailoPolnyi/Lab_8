package ua.lviv.iot.zoo.managers;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import ua.lviv.iot.zoo.models.animals.Animal;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZooManager {
    private List<Animal> allAnimals;

    protected List<Animal> sortAnimalListByType(final List<Animal> animalListToSort, boolean isSortAsc) {
        animalListToSort.sort(Comparator.comparing(Animal::getAnimalType));
        if (!isSortAsc) {
            Collections.reverse(animalListToSort);
        }
        return animalListToSort;
    }

    public List<Animal> getAllAnimalsOver5yo(final @NonNull List<Animal> checkedAnimalList, boolean isSortAsc) {
        List<Animal> resultAnimalList = checkedAnimalList.stream()
                .filter(animal -> animal.getLifetimeYears() >= 5)
                .collect(Collectors.toList());
        return sortAnimalListByType(resultAnimalList, isSortAsc);
    }
}
