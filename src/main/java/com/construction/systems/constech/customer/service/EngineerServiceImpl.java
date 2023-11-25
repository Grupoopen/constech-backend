package com.construction.systems.constech.customer.service;

import com.construction.systems.constech.customer.domain.model.entities.Engineer;
import com.construction.systems.constech.customer.domain.persistence.EngineerRepository;
import com.construction.systems.constech.customer.domain.service.EngineerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return engineerRepository.findAll();
    }

    @Override
    public Engineer findById(Integer id) {
        Optional<Engineer> optionalEngineer = engineerRepository.findById(id);
        return optionalEngineer.orElse(null);
    }

    @Override
    public Engineer update(Integer id, Engineer engineer) {
        Optional<Engineer> optionalExistingEngineer = engineerRepository.findById(id);

        if (optionalExistingEngineer.isPresent()) {
            Engineer existingEngineer = optionalExistingEngineer.get();
            existingEngineer.setFirstName(engineer.getFirstName());
            existingEngineer.setLastName(engineer.getLastName());
            return engineerRepository.save(existingEngineer);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        engineerRepository.deleteById(id);
    }
}
