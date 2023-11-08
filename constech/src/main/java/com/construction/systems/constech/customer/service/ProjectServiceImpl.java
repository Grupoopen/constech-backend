package com.construction.systems.constech.customer.service;

import com.construction.systems.constech.customer.domain.model.entities.Project;
import com.construction.systems.constech.customer.domain.persistence.ProjectRepository;
import com.construction.systems.constech.customer.domain.service.ProjectService;
import com.construction.systems.constech.shared.exception.FetchIdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjectServiceImpl  implements ProjectService {
    private final ProjectRepository projectRepository;



    @Override
    public Project save(Project project) {

        return projectRepository.save(project);
    }

    @Override
    public List<Project> fetchAll() {

        return projectRepository.findAll() ;
    }


    @Override
    public boolean deleteById(Integer id) {
        if (projectRepository.existsById(id)) { // cuando la respuesta de busqueda es un solo elemento
            projectRepository.deleteById(id);
            if (projectRepository.existsById(id)) // Validar que se elimino
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Student", id);
    }
}
