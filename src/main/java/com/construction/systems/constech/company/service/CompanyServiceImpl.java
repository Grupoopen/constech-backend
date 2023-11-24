package com.construction.systems.constech.company.service;

import com.construction.systems.constech.shared.exception.FetchIdNotFoundException;
import com.construction.systems.constech.shared.exception.ResourceNotFoundException;
import com.construction.systems.constech.shared.exception.ResourceValidationException;
import com.construction.systems.constech.company.domain.model.entities.Company;
import com.construction.systems.constech.company.domain.persistence.CompanyRepository;
import com.construction.systems.constech.company.domain.service.CompanyService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final Validator validator;

    @Transactional
    @Override
    public Company save(Company company) {
        Set<ConstraintViolation<Company>> violations = validator.validate(company);
        if (violations.isEmpty()){
            return companyRepository.save(company);
        }
        throw new ResourceValidationException("Company", violations);
    }


    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (companyRepository.existsById(id)) { // cuando la respuesta de busqueda es un solo elemento
            companyRepository.deleteById(id);
            if (companyRepository.existsById(id)) // Validar que se elimino
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Company", id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> fetchAll() { return companyRepository.findAll(); }


    @Transactional(readOnly = true)
    @Override
    public Company fetchByTitle(String title) {
        Optional<Company> optionalCompany = companyRepository.findByTitle(title);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        throw  new ResourceNotFoundException("Company", "title", title);
    }

    @Transactional(readOnly = true)
    @Override
    public Company fetchByAssigned(String assigned) {
        Optional<Company> optionalCompany = companyRepository.findByAssigned(assigned);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        throw  new RuntimeException("No esta el asignado a buscar");
    }

    @Transactional
    @Override
    public Company update(Integer id, Company request) {

        Set<ConstraintViolation<Company>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException("Company", violations);
        }


        Company updatedCompany = companyRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setAssigned(request.getAssigned());
                    existingCompany.setTitle(request.getTitle());
                    existingCompany.setDescription(request.getDescription());
                    existingCompany.setStatus(request.getStatus());
                    existingCompany.setInitialDate(request.getInitialDate());
                    existingCompany.setDeadline(request.getDeadline());
                    return companyRepository.save(existingCompany);
                })
                .orElseThrow(() -> new FetchIdNotFoundException("Company", id));


        return updatedCompany;
    }
}

