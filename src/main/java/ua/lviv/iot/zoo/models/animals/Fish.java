package ua.lviv.iot.zoo.models.animals;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Fish extends AquariumAnimal {
    protected String color;
    protected boolean isCartilaginous;
}
