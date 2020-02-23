package com.baysalmehmed.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "CHARGER")
public class ChargerDao {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name="author_generator", sequenceName = "charger_seq", allocationSize=1)
    public Integer id;

    @Column(name = "TYPE", nullable = false, length = 50)
    public String type;

    @Column(name = "DESCRIPTION", nullable = true, length = 50)
    public String description;

    @Column(name = "TOTAL_SPACES", nullable = false, length = 3)
    public Integer totalSpaces;

    @Column(name = "USED_SPACES", nullable = false, length = 3)
    public Integer usedSpaces;

    @Column(name = "LONGITUDE", nullable = false, length = 126)
    public Double longitude;

    @Column(name = "LATITUDE", nullable = false, length = 126)
    public Double latitude;

    public ChargerDao() {
    }

    public ChargerDao(String type, String description, Integer totalSpaces, Integer usedSpaces, Double longitude, Double latitude) {
        this.type = type;
        this.description = description;
        this.totalSpaces = totalSpaces;
        this.usedSpaces = usedSpaces;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
