package com.example.entitiesexercise1.repository;

import com.example.entitiesexercise1.data.Delivery;
import com.example.entitiesexercise1.data.Plant;
import com.example.entitiesexercise1.data.RecipientAndPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {
    @PersistenceContext
    EntityManager entityManager;
    // persist()
    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }
    // find()
    public Delivery find(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        return delivery;
    }

    // merge()
    public Delivery merge(Delivery delivery) {
        Delivery managedDelivery = entityManager.merge(delivery);
        return managedDelivery;
    }
    // delete()
    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

    public List<Delivery> findByName(String name) {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = criteriaBuilder.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.select(
                criteriaBuilder.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        criteriaBuilder.sum(root.get("price"))))
                .where(criteriaBuilder.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(query).getSingleResult();
    }

}
