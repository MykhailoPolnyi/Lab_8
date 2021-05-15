package ua.lviv.iot.zoo.rest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized @SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Animal extends ua.lviv.iot.zoo.models.animals.Animal {
    private Integer id;
}
