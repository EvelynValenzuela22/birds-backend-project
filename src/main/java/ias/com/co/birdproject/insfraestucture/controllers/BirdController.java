package ias.com.co.birdproject.insfraestucture.controllers;

import ias.com.co.birdproject.bird.application.ports.input.CreateBirdUseCase;
import ias.com.co.birdproject.bird.application.ports.input.DeleteBirdUseCase;
import ias.com.co.birdproject.bird.application.ports.input.QueryBirdByIdUseCase;
import ias.com.co.birdproject.bird.application.ports.input.UpdateBirdUseCase;
import ias.com.co.birdproject.insfraestucture.models.ApplicationError;
import ias.com.co.birdproject.insfraestucture.models.BirdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/birds")
public class BirdController {

    private final CreateBirdUseCase createBirdUseCase;
    private final UpdateBirdUseCase updateBirdUseCase;
    private final DeleteBirdUseCase deleteBirdUseCase;
    private final QueryBirdByIdUseCase queryBirdByIdUseCase;

    public BirdController(CreateBirdUseCase createBirdUseCase,
                          UpdateBirdUseCase updateBirdUseCase,
                          DeleteBirdUseCase deleteBirdUseCase,
                          QueryBirdByIdUseCase queryBirdByIdUseCase) {
        this.createBirdUseCase = createBirdUseCase;
        this.updateBirdUseCase = updateBirdUseCase;
        this.deleteBirdUseCase = deleteBirdUseCase;
        this.queryBirdByIdUseCase = queryBirdByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BirdDTO birdDTO) {
        try {
            BirdDTO birdDTOOutput = createBirdUseCase.execute(birdDTO);
            return ResponseEntity.status(CREATED).body(birdDTOOutput);
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", e.getMessage()));
            return ResponseEntity.status(BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            Optional<BirdDTO> birdDTO = queryBirdByIdUseCase.execute(id);
            if(birdDTO.isPresent()) {
                return ResponseEntity.ok(birdDTO.get());
            } else {
                return ResponseEntity.status(NO_CONTENT).body("No exist a bird with this id");
            }

        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", e.getMessage()));
            return ResponseEntity.status(BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BirdDTO birdDTO) {
        try {
            BirdDTO birdDTOOutput = updateBirdUseCase.execute(birdDTO);
            return ResponseEntity.ok(birdDTOOutput);
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", e.getMessage()));
            return ResponseEntity.status(BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            Boolean result = deleteBirdUseCase.execute(id);
            if(result) {
                return ResponseEntity.ok("Deleted");
            } else {
                return  ResponseEntity.status(BAD_REQUEST).body("Bird can be deleted");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", e.getMessage()));
            return ResponseEntity.status(BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(applicationError);
        }

    }
}
