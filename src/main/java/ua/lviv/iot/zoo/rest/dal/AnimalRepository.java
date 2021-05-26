package ua.lviv.iot.zoo.rest.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.zoo.rest.models.AnimalRepr;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalRepr, Integer> {

}
