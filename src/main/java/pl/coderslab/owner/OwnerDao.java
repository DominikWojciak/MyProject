package pl.coderslab.owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OwnerDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void create(Owner owner) {
        entityManager.persist(owner);
    }

    public Owner read(Long id) {
        return entityManager.find(Owner.class, id);
    }

    public void update(Owner owner) {
        entityManager.merge(owner);
    }

    public void delete(Long id) {
        Owner owner = read(id);
        if (owner != null) {
            entityManager.remove(owner);
        }
    }

    public List<Owner> findAll() {
        Query query = entityManager.createQuery("select a from Owner a");
        return query.getResultList();
    }

}