package ua.lviv.iot.zoo.models.animals;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import ua.lviv.iot.zoo.models.enumerators.ThermoregulationType;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {
    protected float weightInKg;
    protected ThermoregulationType thermoregulation;
    protected float lifetimeYears;
    @NonNull
    protected String animalType;
}

