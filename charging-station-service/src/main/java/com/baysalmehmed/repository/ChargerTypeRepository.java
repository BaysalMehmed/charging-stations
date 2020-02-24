package com.baysalmehmed.repository;

import com.baysalmehmed.model.dao.ChargerTypeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargerTypeRepository extends JpaRepository<ChargerTypeDao, Integer> {
}
