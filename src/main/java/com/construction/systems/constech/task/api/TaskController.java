package com.construction.systems.constech.task.api;

import com.construction.systems.constech.shared.exception.InternalServerErrorException;
import com.construction.systems.constech.task.domain.model.entities.Task;
import com.construction.systems.constech.task.domain.service.TaskService;
import com.construction.systems.constech.task.mapping.TaskMapper;
import com.construction.systems.constech.task.resource.CreateTaskResource;
import com.construction.systems.constech.task.resource.TaskResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST})
public class TaskController {
    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @PostMapping
    public ResponseEntity<TaskResource> save(@RequestBody CreateTaskResource task) {
        return new ResponseEntity<>(
                taskMapper.toResource(taskService.save(taskMapper.toEntity(task))),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<Task> fetchAll() {
        return taskService.fetchAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (taskService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Student", "id", String.valueOf(id), "deleted");
    }

    @GetMapping("title/{title}")
    public ResponseEntity<TaskResource> fetchTitle(@PathVariable("title") String title){
        return ResponseEntity.ok(
                taskMapper.toResource(taskService.fetchByTitle(title)));
    }


    @GetMapping("assigned/{assigned}")
    public ResponseEntity<Task> fetchAsssigned(@PathVariable("assigned") String assigned){
        return ResponseEntity.ok(taskService.fetchByTitle(assigned));
    }
}
