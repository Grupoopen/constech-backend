package com.construction.systems.constech.customer.domain.service;

import com.construction.systems.constech.customer.domain.model.entities.Project;

import java.util.List;

public interface ProjectService {
    Project save(Project project);

    List<Project>fetchAll();
    boolean deleteById(Integer id);
}