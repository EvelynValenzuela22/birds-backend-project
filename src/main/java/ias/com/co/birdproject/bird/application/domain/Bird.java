package ias.com.co.birdproject.bird.application.domain;

import ias.com.co.birdproject.bird.application.domain.valueObjs.*;

public class Bird {
    private final BirdId id;
    private final BirdCommonName commonName;
    private final BirdScientificName scientificName;
    private final BirdZoneName zoneName;
    private final BirdConfirmedQuantity confirmedQuantity;

    public Bird(BirdId id, BirdCommonName commonName, BirdScientificName scientificName, BirdZoneName zoneName, BirdConfirmedQuantity confirmedQuantity) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.confirmedQuantity = confirmedQuantity;
    }

    public BirdId getId() {
        return id;
    }

    public BirdCommonName getCommonName() {
        return commonName;
    }

    public BirdScientificName getScientificName() {
        return scientificName;
    }

    public BirdZoneName getZoneName() {
        return zoneName;
    }

    public BirdConfirmedQuantity getConfirmedQuantity() {
        return confirmedQuantity;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", commonName=" + commonName +
                ", scientificName=" + scientificName +
                ", zoneName=" + zoneName +
                ", confirmedQuantity=" + confirmedQuantity +
                '}';
    }
}
