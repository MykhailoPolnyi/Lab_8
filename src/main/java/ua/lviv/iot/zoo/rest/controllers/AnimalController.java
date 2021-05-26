package ua.lviv.iot.zoo.rest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import ua.lviv.iot.zoo.rest.models.AnimalRepr;
import ua.lviv.iot.zoo.rest.service.AnimalService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/animals")
public class AnimalController {

    private static final Logger LOGGER = Logger.getLogger("ua/lviv/iot/zoo/rest/controllers/AnimalController");

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<AnimalRepr>> getAnimalList() {
            return new ResponseEntity<>(animalService.getAnimalList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AnimalRepr> addAnimal(@RequestBody AnimalRepr newAnimalRepr) {
        if (newAnimalRepr.getId() != null) {
            LOGGER.severe("BAD REQUEST: trying to set created object`s id externally");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(animalService.addAnimal(newAnimalRepr), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AnimalRepr> getAnimal(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(animalService.getAnimal(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            LOGGER.severe(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<AnimalRepr> updateAnimal(@RequestBody AnimalRepr newAnimalRepr) {
        try {
            return new ResponseEntity<>(animalService.updateAnimal(newAnimalRepr), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            LOGGER.severe(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AnimalRepr> deleteAnimal(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(animalService.deleteAnimal(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            LOGGER.severe(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
