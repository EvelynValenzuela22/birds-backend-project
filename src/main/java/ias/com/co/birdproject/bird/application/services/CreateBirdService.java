package ias.com.co.birdproject.bird.application.services;

import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.ports.input.CreateBirdUseCase;
import ias.com.co.birdproject.bird.application.ports.output.BirdRepository;
import ias.com.co.birdproject.bird.application.domain.valueObjs.*;
import ias.com.co.birdproject.insfraestucture.models.BirdDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateBirdService implements CreateBirdUseCase {

    private final BirdRepository birdRepository;

    public CreateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {

        Bird bird = new Bird(
                null,
                new BirdCommonName(birdDTO.getCommonName()),
                new BirdScientificName(birdDTO.getScientificName()),
                new BirdZoneName(birdDTO.getZoneName()),
                new BirdConfirmedQuantity(birdDTO.getConfirmedQuantity())
        );

        if(birdRepository.getCommonName(bird.getCommonName()).isPresent()) {
            birdDTO.setStatus("Can not be created, common name already exist");
        } else if(birdRepository.getScientificName(bird.getScientificName()).isPresent()) {
            birdDTO.setStatus("Can not be created, scientific name already exist");
        } else if(birdRepository.getZoneName(bird.getZoneName()).isPresent()) {
            birdDTO.setStatus("Can not be created, zone name already exist");
        } else {
            birdRepository.store(bird);
            birdDTO.setStatus("Created");
        }

        return birdDTO;
    }
}
