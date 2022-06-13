package ias.com.co.birdproject.bird.application.services;

import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.ports.input.UpdateBirdUseCase;
import ias.com.co.birdproject.bird.application.ports.output.BirdRepository;
import ias.com.co.birdproject.insfraestucture.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBirdService implements UpdateBirdUseCase {
    private final BirdRepository birdRepository;

    public UpdateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {
        Bird bird = birdDTO.toDomain();
        Optional<Bird> birdDB = birdRepository.get(bird.getId());

        if(birdDB.isPresent()) {
            if(birdRepository.getCommonName(bird.getCommonName()).isPresent()) {
                birdDTO.setStatus("Can not be updated, common name already exist");
            } else if(birdRepository.getScientificName(bird.getScientificName()).isPresent()) {
                birdDTO.setStatus("Can not be updated, scientific name already exist");
            } else if(birdRepository.getZoneName(bird.getZoneName()).isPresent()) {
                birdDTO.setStatus("Can not be updated, zone name already exist");
            } else {
                birdRepository.update(bird);
                birdDTO.setStatus("Updated");;
            }
        } else {
            birdDTO.setStatus("No updated");
        }
        return birdDTO;
    }
}
