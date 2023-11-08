package com.construction.systems.constech.customer.domain.service;

import com.construction.systems.constech.customer.domain.model.entities.Engineer;
import com.construction.systems.constech.customer.domain.model.entities.Project;

import java.util.List;

public interface EngineerService {

    Engineer save(Engineer engineer);

    List<Engineer>fetchAll();
}
