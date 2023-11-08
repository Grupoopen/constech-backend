package com.construction.systems.constech.customer.api;

import com.construction.systems.constech.customer.domain.model.entities.Engineer;
import com.construction.systems.constech.customer.domain.model.entities.Project;
import com.construction.systems.constech.customer.domain.service.EngineerService;
import com.construction.systems.constech.customer.domain.service.ProjectService;
import com.construction.systems.constech.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    private final EngineerService engineerService;

    @PostMapping
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @GetMapping
    public List<Project> fetchAll() {
        return projectService.fetchAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (projectService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Project", "id", String.valueOf(id), "deleted");
    }

  //  @GetMapping
   // public List<Engineer> listaEngineer(){
     //   return engineerService.listaEngineer();
    //}
}
