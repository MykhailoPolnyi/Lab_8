package ua.lviv.iot.zoo.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.NoSuchElementException;

import ua.lviv.iot.zoo.rest.dal.AnimalRepository;
import ua.lviv.iot.zoo.rest.models.AnimalRepr;


@Service
@ApplicationScope
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public AnimalRepr addAnimal(AnimalRepr receivedAnimalRepr) {
        return repository.save(receivedAnimalRepr);
    }

    public List<AnimalRepr> getAnimalList() {
        return repository.findAll();
    }

    public AnimalRepr getAnimal(Integer id) {
        if (repository.existsById(id)){
            return repository.findById(id).get();
        }
        throw new NoSuchElementException("NOT FOUND: Cannot find animal with id:" + id + "in the system");
    }

    public AnimalRepr updateAnimal(Integer id, AnimalRepr receivedAnimalRepr) {
        if (repository.existsById(id)){
            return repository.findById(id).get();
        }
        throw new NoSuchElementException("NOT FOUND: Cannot find animal with id:" + id + "in the system");
    }

    public AnimalRepr deleteAnimal(Integer id) {
        AnimalRepr deletedAnimal = getAnimal(id);
        repository.deleteById(id);
        return deletedAnimal;
    }
}
