package com.construction.systems.constech.customer.api;


import com.construction.systems.constech.customer.domain.model.entities.Engineer;
import com.construction.systems.constech.customer.domain.service.EngineerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor

@RequestMapping("/engineers")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}
)
public class EngineerController {

    private final EngineerService engineerService;

    @PostMapping
    public ResponseEntity<Engineer> createEngineer(@RequestBody Engineer engineer) {
        Engineer savedEngineer = engineerService.save(engineer);
        return ResponseEntity.ok(savedEngineer);
    }

    @GetMapping
    public ResponseEntity<List<Engineer>> getAllEngineers() {
        List<Engineer> engineers = engineerService.fetchAll();
        return ResponseEntity.ok(engineers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Engineer> getEngineerById(@PathVariable Integer id) {
        Engineer engineer = engineerService.findById(id);
        if (engineer != null) {
            return ResponseEntity.ok(engineer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Engineer> updateEngineer(@PathVariable Integer id, @RequestBody Engineer updatedEngineer) {
        Engineer engineer = engineerService.update(id, updatedEngineer);
        if (engineer != null) {
            return ResponseEntity.ok(engineer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEngineer(@PathVariable Integer id) {
        engineerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
