package ias.com.co.birdproject.bird.application.services;

import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.ports.input.QueryBirdByIdUseCase;
import ias.com.co.birdproject.bird.application.ports.output.BirdRepository;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdId;
import ias.com.co.birdproject.insfraestucture.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryBirdByIdService implements QueryBirdByIdUseCase {
    private final BirdRepository birdRepository;

    public QueryBirdByIdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Optional<BirdDTO> execute(Long id) {
        Optional<Bird> bird = birdRepository.get(new BirdId(id));
        return bird.map(BirdDTO::fromDomain);
    }
}
