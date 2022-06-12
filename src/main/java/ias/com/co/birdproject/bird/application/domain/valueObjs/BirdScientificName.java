package ias.com.co.birdproject.bird.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdScientificName {
    private final String value;

    public BirdScientificName(String value) {
        Validate.isTrue(value.length() <= 30, "Bird zone name can not be longer than 20 characters");
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
