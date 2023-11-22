package com.construction.systems.constech.task.api;

import com.construction.systems.constech.task.domain.model.entities.Task;
import com.construction.systems.constech.task.domain.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST})
public class TaskController {
    private final TaskService taskService;



    @PostMapping
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping
    public List<Task> fetchAll() {
        return taskService.fetchAll();
    }

    @GetMapping("title/{title}")
    public Task fetchTitle(@PathVariable("title") String title){
        return taskService.fetchByTitle(title);
    }

    @GetMapping("assigned/{assigned}")
    public Task fetchAsssigned(@PathVariable("assigned") String assigned){
        return taskService.fetchByAssigned(assigned);
    }
}
