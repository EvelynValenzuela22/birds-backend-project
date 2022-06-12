package ias.com.co.birdproject.bird.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdZoneName {
    private final String value;

    public BirdZoneName(String value) {
        Validate.isTrue(value.length() <= 20, "Bird zone name can not be longer than 20 characters");
        Validate.notNull(value, "Bird zone name can not be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
