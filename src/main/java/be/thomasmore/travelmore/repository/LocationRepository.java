package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocationRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Location findById(int id) {
        return entityManager.find(Location.class, id);
    }

    public List<Location> findAll() {
        return entityManager.createNamedQuery(Location.FIND_ALL, Location.class).getResultList();
    }

    public Location findByCode(String code) {
        return entityManager.createNamedQuery(Location.FIND_BY_CODE, Location.class).setParameter("code", code).getSingleResult();
    }

    public Location insert(Location location) {
        entityManager.persist(location);

        return location;
    }
}
