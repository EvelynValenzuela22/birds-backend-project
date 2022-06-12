package ias.com.co.birdproject.bird.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdCommonName {
    private final String value;

    public BirdCommonName(String value) {
        Validate.isTrue(value.length() <= 30, "Bird common name can not be longer than 20 characters");
        Validate.notNull(value, "Bird common name can not be null");
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
