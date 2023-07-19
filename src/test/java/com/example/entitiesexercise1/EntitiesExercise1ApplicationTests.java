package com.example.entitiesexercise1;

import com.example.entitiesexercise1.data.Delivery;
import com.example.entitiesexercise1.data.Plant;
import com.example.entitiesexercise1.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
class EntitiesExercise1ApplicationTests {
	@Autowired
	TestEntityManager testEntityManager;

	@Autowired
	PlantRepository plantRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testPriceLessThan() {
		Plant plantOne = testEntityManager.persist(new Plant("Foo Leaf", 4.99));
		testEntityManager.persist(new Plant("Bar Weed", 5.01));

		List<Plant> cheapPlants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(5));
		Assertions.assertEquals(1, cheapPlants.size(), "Size");
		Assertions.assertEquals(plantOne.getId(), cheapPlants.get(0).getId(), "Id");
	}

	@Test
	public void testDeliveryCompleted() {
		Plant plant = testEntityManager.persist(new Plant("Foo Leaf", 4.99));
		Delivery delivery = testEntityManager.persist(new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now()));

		delivery.setPlants(Lists.newArrayList(plant));
		plant.setDelivery(delivery);

		Assertions.assertFalse(plantRepository.deliveryCompleted(plant.getId()));
		delivery.setCompleted(true);
		Assertions.assertTrue(plantRepository.deliveryCompleted(plant.getId()));
	}
}
