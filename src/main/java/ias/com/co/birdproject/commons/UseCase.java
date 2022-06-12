package ias.com.co.birdproject.commons;

public interface UseCase<Input,Output > {
     Output execute(Input input);
}
