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

import ua.lviv.iot.zoo.rest.models.Animal;
import ua.lviv.iot.zoo.rest.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping(path = "/animals")
public class AnimalController {

    @Autowired
    public AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> getAnimalList() {
        return new ResponseEntity<>(animalService.getAnimalList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal newAnimal) {
            return new ResponseEntity<>(animalService.addAnimal(newAnimal), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Integer id) {
        if (animalService.getAnimalMap().containsKey(id)){
            return new ResponseEntity<>(animalService.getAnimal(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Integer id, @RequestBody Animal newUpdAnimal) {
        if (animalService.getAnimalMap().containsKey(id)) {
            return new ResponseEntity<>(animalService.updateAnimal(id, newUpdAnimal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Animal> deleteAnimal(@PathVariable Integer id){
        if (animalService.getAnimalMap().containsKey(id)) {

            return new ResponseEntity<>(animalService.deleteAnimal(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
