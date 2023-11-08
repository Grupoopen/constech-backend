package com.construction.systems.constech.customer.domain.persistence;

import com.construction.systems.constech.customer.domain.model.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends JpaRepository<Project,Integer> {

}
