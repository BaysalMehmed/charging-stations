package com.baysalmehmed.repository;

import com.baysalmehmed.model.dao.ChargerDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargerRepository extends JpaRepository<ChargerDao, Integer> {
}
