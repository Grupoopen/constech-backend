package com.construction.systems.constech.customer.service;

import com.construction.systems.constech.customer.domain.model.entities.Engineer;
import com.construction.systems.constech.customer.domain.model.entities.Project;
import com.construction.systems.constech.customer.domain.persistence.EngineerRepository;
import com.construction.systems.constech.customer.domain.service.EngineerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EngineerServiceImpl implements EngineerService {
    private final EngineerRepository engineerRepository;
    @Override
    public Engineer save(Engineer engineer) {

        return engineerRepository.save(engineer);
    }

    @Override
    public List<Engineer> fetchAll() {

        return engineerRepository.findAll() ;
    }
}
