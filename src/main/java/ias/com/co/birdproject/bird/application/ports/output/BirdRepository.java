package ias.com.co.birdproject.bird.application.ports.output;

import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdCommonName;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdId;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdScientificName;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdZoneName;
import ias.com.co.birdproject.insfraestucture.models.BirdDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BirdRepository {

    void store(Bird bird);
    void update(Bird bird);
    Optional<Bird> get(BirdId birdId);
    Boolean delete(BirdId birdId);
    Optional<Bird> getCommonName(BirdCommonName birdCommonName);
    Optional<Bird> getScientificName(BirdScientificName birdScientificName);
    Optional<Bird> getZoneName(BirdZoneName birdZoneName);

}
