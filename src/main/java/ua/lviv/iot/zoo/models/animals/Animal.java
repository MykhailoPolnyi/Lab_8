package ua.lviv.iot.zoo.models.animals;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import ua.lviv.iot.zoo.models.enumerators.ThermoregulationType;

@Data
@SuperBuilder
public abstract class Animal {
    protected float weightInKg;
    protected ThermoregulationType thermoregulation;
    protected float lifetimeYears;
    @NonNull
    protected final String animalType;
}

