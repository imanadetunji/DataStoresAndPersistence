package com.example.entitiesexercise1.data;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NamedQuery(name = "Delivery.findByName",
        query = "select delivery from Delivery delivery where delivery.name = :name")
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    @Nationalized
    private String name;
    private LocalDateTime localDateTime;
    @Column(name = "address_full", length = 500)
    private String address;
//    @Type(type = "yes_no")
    private Boolean completed = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public Delivery() {
    }

    public Delivery(String name, String address, LocalDateTime localDateTime) {
        this.name = name;
        this.address = address;
        this.localDateTime = localDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
