package com.baysalmehmed.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "CHARGER_TYPE")
public class ChargerTypeDao {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charger_type_generator")
    @SequenceGenerator(name="charger_type_generator", sequenceName = "charger_type_seq", allocationSize=1)
    public Integer id;

    @Column(name = "TYPE", nullable = false, length = 50)
    public String type;

    public ChargerTypeDao() {
    }

    public ChargerTypeDao(String type) {
        this.type = type;
    }
}
