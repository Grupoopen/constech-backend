package com.construction.systems.constech.customer.domain.persistence;

import com.construction.systems.constech.customer.domain.model.entities.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository  extends JpaRepository<Engineer,Integer> {
}
