package com.construction.systems.constech.task.domain.persistence;

import com.construction.systems.constech.task.domain.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findByTitle(String title);

    Optional<Task> findByAssigned(String assigned);

}
