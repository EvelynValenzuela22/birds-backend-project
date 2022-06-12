package ias.com.co.birdproject.bird.application.ports.input;

import ias.com.co.birdproject.commons.UseCase;
import ias.com.co.birdproject.insfraestucture.models.BirdDTO;

import java.util.Optional;

public interface QueryBirdByIdUseCase extends UseCase<Long, Optional<BirdDTO>> {
}
