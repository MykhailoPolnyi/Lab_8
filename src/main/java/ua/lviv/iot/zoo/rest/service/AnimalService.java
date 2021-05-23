package ua.lviv.iot.zoo.rest.service;


import lombok.Getter;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import ua.lviv.iot.zoo.rest.models.AnimalRepr;

@Service
@ApplicationScope
public class AnimalService {

    static private AtomicInteger id = new AtomicInteger(0);

    @Getter
    private Map<Integer, AnimalRepr> animalMap = new HashMap<Integer, AnimalRepr>();

    public List<AnimalRepr> getAnimalList() {
        return animalMap.values().stream().collect(Collectors.toList());
    }

    public AnimalRepr getAnimal(Integer id) {
            return animalMap.get(id);
    }

    public AnimalRepr addAnimal(AnimalRepr receivedAnimalRepr) {
        receivedAnimalRepr.setId(id.incrementAndGet());
        animalMap.put(receivedAnimalRepr.getId(), receivedAnimalRepr);
        return receivedAnimalRepr;
    }

    public AnimalRepr updateAnimal(Integer id, AnimalRepr receivedAnimalRepr) {
        receivedAnimalRepr.setId(id);
        return animalMap.put(id, receivedAnimalRepr);
    }

    public AnimalRepr deleteAnimal(Integer id) {
        return animalMap.remove(id);
    }
}
