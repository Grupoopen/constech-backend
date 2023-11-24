package com.construction.systems.constech.company.domain.service;

import com.construction.systems.constech.company.domain.model.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company save(Company company);
    List<Company> fetchAll();

    Company fetchByCompanyName(String companyName);

    Company update(Integer id,Company company);

    boolean deleteById(Integer id);
    
    Company fetchByRuc(String ruc);
}
