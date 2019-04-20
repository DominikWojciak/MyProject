package pl.coderslab.district;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DistrictDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void create(District district) {
        entityManager.persist(district);
    }

    public District read(Long id) {
        return entityManager.find(District.class, id);
    }

    public void update(District district) {
        entityManager.merge(district);
    }

    public void delete(Long id) {
        District district = read(id);
        if (district != null) {
            entityManager.remove(district);
        }
    }

    public List<District> findAll(){
        Query query = entityManager.createQuery("select p from District p");
        return query.getResultList();
    }
}