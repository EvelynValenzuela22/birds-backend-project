package ias.com.co.birdproject.bird.application.services;

import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.ports.input.DeleteBirdUseCase;
import ias.com.co.birdproject.bird.application.ports.output.BirdRepository;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBirdService implements DeleteBirdUseCase {

    private final BirdRepository birdRepository;

    public DeleteBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Boolean execute(Long id) {
        BirdId birdId = new BirdId(id);
        Optional<Bird> bird = birdRepository.get(birdId);
        if(bird.isPresent()) {
            birdRepository.delete(birdId);
            return true;
        } else {
            return false;
        }
    }
}
