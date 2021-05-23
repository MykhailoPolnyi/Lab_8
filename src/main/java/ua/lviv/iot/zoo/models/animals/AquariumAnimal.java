package ua.lviv.iot.zoo.models.animals;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;

import ua.lviv.iot.zoo.models.aquariums.Aquarium;
import ua.lviv.iot.zoo.models.enumerators.LightingLevel;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AquariumAnimal extends Animal {
    protected float requiredAquariumCapacityLiters;
    protected int requiredTemperature;
    protected LightingLevel requiredLightingLevel;
    @NonNull
    protected Aquarium currentAquarium;
}
