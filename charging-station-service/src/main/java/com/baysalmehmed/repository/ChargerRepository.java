package com.baysalmehmed.repository;

import com.baysalmehmed.model.dao.ChargerDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargerRepository extends JpaRepository<ChargerDao, Integer> {

    @Query(value = "select * from charger c where (\n" +
            "acos(sin(c.Latitude * 0.0175) * sin(?1 * 0.0175) \n" +
            "+ cos(c.Latitude * 0.0175) * cos(?1 * 0.0175) *    \n" +
            "cos((?2 * 0.0175) - (c.Longitude * 0.0175))\n" +
            ") * 3959 <= ?3)", nativeQuery = true)
    public List<ChargerDao> getChargersWithinRadius(Double latitude, Double longitude, Double miles);
}
