package com.construction.systems.constech.task.service;

import com.construction.systems.constech.shared.exception.ResourceNotFoundException;
import com.construction.systems.constech.shared.exception.ResourceValidationException;
import com.construction.systems.constech.task.domain.model.entities.Task;
import com.construction.systems.constech.task.domain.persistence.TaskRepository;
import com.construction.systems.constech.task.domain.service.TaskService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final Validator validator;

    @Override
    public Task save(Task task) {
        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        if (violations.isEmpty()){
            return taskRepository.save(task);
        }
        throw new ResourceValidationException("Task", violations);
    }

    @Override
    public List<Task> fetchAll() { return taskRepository.findAll(); }

    @Override
    public Task fetchByTitle(String title) {
        Optional<Task> optionalTask = taskRepository.findByTitle(title);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        throw  new ResourceNotFoundException("Task", "title", title);
    }

    @Override
    public Task fetchByAssigned(String assigned) {
        Optional<Task> optionalTask = taskRepository.findByAssigned(assigned);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        throw  new RuntimeException("No esta el asignado a buscar");
    }
}
