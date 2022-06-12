package ias.com.co.birdproject.insfraestucture.models;

import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BirdDAO {
    private Long id;
    private String commonName;
    private String scientificName;
    private String zoneName;
    private Integer confirmedQuantity;

    public BirdDAO(Long id, String commonName, String scientificName, String zoneName, Integer confirmedQuantity) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.confirmedQuantity = confirmedQuantity;
    }

    public BirdDAO() {
    }

    public Bird toDomain() {
        return new Bird(
                new BirdId(id),
                new BirdCommonName(commonName),
                new BirdScientificName(scientificName),
                new BirdZoneName(zoneName),
                new BirdConfirmedQuantity(confirmedQuantity)
        );
    }
    public static BirdDAO fromDomain(Bird bird) {
        return new BirdDAO(
                bird.getId().getValue(),
                bird.getCommonName().getValue(),
                bird.getScientificName().getValue(),
                bird.getZoneName().getValue(),
                bird.getConfirmedQuantity().getValue()
        );
    }

    public static BirdDAO fromResultSet(ResultSet resultSet) throws SQLException {
        BirdDAO birdDAO = new BirdDAO();
        birdDAO.setId(resultSet.getLong("id"));
        birdDAO.setCommonName(resultSet.getString("common_name"));
        birdDAO.setZoneName(resultSet.getString("zone_name"));
        birdDAO.setScientificName(resultSet.getString("scientific_name"));
        birdDAO.setConfirmedQuantity(resultSet.getInt("confirmed_quantity"));
        return birdDAO;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setZoneName(String zonaName) {
        this.zoneName = zonaName;
    }

    public Integer getConfirmedQuantity() {
        return confirmedQuantity;
    }

    public void setConfirmedQuantity(Integer confirmedQuantity) {
        this.confirmedQuantity = confirmedQuantity;
    }
}
