package ias.com.co.birdproject.bird.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdConfirmedQuantity {
    private final Integer value;

    public BirdConfirmedQuantity(Integer value) {
        Validate.isTrue((value.toString().length() <=100000), "Bird Confirmed Quantity can not be longer than 100000 characters");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
