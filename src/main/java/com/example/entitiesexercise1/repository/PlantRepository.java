package com.example.entitiesexercise1.repository;

import com.example.entitiesexercise1.data.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    @Query("SELECT p.delivery.completed FROM Plant p WHERE p.id = :plantId")
    Boolean deliveryCompleted(Long plantId);

    List<Plant> findByPriceLessThan(BigDecimal price);
}
