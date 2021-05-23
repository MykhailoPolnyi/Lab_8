package ua.lviv.iot.zoo.models.aquariums;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;
import ua.lviv.iot.zoo.models.animals.AquariumAnimal;
import ua.lviv.iot.zoo.models.enumerators.LightingLevel;

import java.util.List;

@Data
@ToString(exclude = {"inhabitants"})
@Builder
public class Aquarium {
    private float capacityInLiters;
    private int supportedMinTemperature;
    private int supportedMaxTemperature;
    @Singular("supportedLightingLevel")
    private List<LightingLevel> supportedLightingLevel;
    private List<AquariumAnimal> inhabitants;

    public void setInhabitants(List<AquariumAnimal> inhabitants) {
        inhabitants.forEach(aquariumAnimal -> aquariumAnimal.setCurrentAquarium(this));
        this.inhabitants = inhabitants;
    }
}
