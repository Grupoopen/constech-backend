package com.construction.systems.constech.task.api;

import com.construction.systems.constech.shared.exception.InternalServerErrorException;
import com.construction.systems.constech.task.domain.model.entities.Task;
import com.construction.systems.constech.task.domain.service.TaskService;
import com.construction.systems.constech.task.mapping.TaskMapper;
import com.construction.systems.constech.task.resource.CreateTaskResource;
import com.construction.systems.constech.task.resource.TaskResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "tasks", description = "Everything about your Tasks")
@AllArgsConstructor
@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
public class TaskController {
    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @Operation(
            summary = "Add a new task to the constech" ,
            description = "Add a new task to the constech",
            operationId = "addTask",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TaskResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
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

    @PutMapping("{id}")
    public ResponseEntity<TaskResource> update(@PathVariable("id") Integer id, @RequestBody Task request) {
        Task updatedTask = taskService.update(id, request);
        return ResponseEntity.ok(taskMapper.toResource(updatedTask));
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
