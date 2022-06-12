package ias.com.co.birdproject.insfraestucture.models;

import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.domain.valueObjs.*;

public class BirdDTO {
    private Long birdId;
    private String commonName;
    private String scientificName;
    private String zoneName;
    private Integer confirmedQuantity;
    private String status;

    public Long getBirdId() {
        return birdId;
    }

    public BirdDTO(Long birdId, String commonName, String scientificName, String zoneName, Integer confirmedQuantity) {
        this.birdId = birdId;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.confirmedQuantity = confirmedQuantity;
    }

    public BirdDTO() {
    }

    public Bird toDomain() {
        return new Bird(
                new BirdId(birdId),
                new BirdCommonName(commonName),
                new BirdScientificName(scientificName),
                new BirdZoneName(zoneName),
                new BirdConfirmedQuantity(confirmedQuantity)
        );
    }
    public static BirdDTO fromDomain(Bird bird) {
        return new BirdDTO(
                bird.getId().getValue(),
                bird.getCommonName().getValue(),
                bird.getScientificName().getValue(),
                bird.getZoneName().getValue(),
                bird.getConfirmedQuantity().getValue()
        );
    }
    public void setBirdId(Long birdId) {
        this.birdId = birdId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getConfirmedQuantity() {
        return confirmedQuantity;
    }

    public void setConfirmedQuantity(Integer confirmedQuatity) {
        this.confirmedQuantity = confirmedQuatity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
