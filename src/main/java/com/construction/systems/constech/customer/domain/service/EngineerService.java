package com.construction.systems.constech.customer.domain.service;

import com.construction.systems.constech.customer.domain.model.entities.Engineer;

import java.util.List;

public interface EngineerService {

    Engineer save(Engineer engineer);

    List<Engineer> fetchAll();

    Engineer findById(Integer id);

    Engineer update(Integer id, Engineer engineer);

    void deleteById(Integer id);
}
