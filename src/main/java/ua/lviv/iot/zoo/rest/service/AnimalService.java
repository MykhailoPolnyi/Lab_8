package ua.lviv.iot.zoo.rest.service;


import lombok.Getter;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import ua.lviv.iot.zoo.rest.models.Animal;

@Service
@ApplicationScope
public class AnimalService {

    static private AtomicInteger id = new AtomicInteger(0);

    @Getter
    private Map<Integer, Animal> animalMap = new HashMap<Integer, Animal>();

    public List<Animal> getAnimalList() {
        return animalMap.values().stream().collect(Collectors.toList());
    }

    public Animal getAnimal(Integer id) {
            return animalMap.get(id);
    }

    public Animal addAnimal(Animal receivedAnimal) {
        receivedAnimal.setId(id.incrementAndGet());
        animalMap.put(receivedAnimal.getId(), receivedAnimal);
        return receivedAnimal;
    }

    public Animal updateAnimal(Integer id, Animal receivedAnimal) {
        receivedAnimal.setId(id);
        return animalMap.put(id, receivedAnimal);
    }

    public Animal deleteAnimal(Integer id) {
        return animalMap.remove(id);
    }
}
