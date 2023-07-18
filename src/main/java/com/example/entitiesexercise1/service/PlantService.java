package com.example.entitiesexercise1.service;

import com.example.entitiesexercise1.data.Plant;
import com.example.entitiesexercise1.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;
    public Plant getPlantByName(String name) {
        return new Plant();
    }
    public Long save(Plant plant){
        plantRepository.save(plant);
        return plant.getId();
    }

    public Boolean delivered(Long id) {
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
