package pl.coderslab.flat;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class FlatDaoImpl implements FlatDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void resetYear(int year) {
        Query query = entityManager.createQuery("update Flat b set b.year = :year");
        query.setParameter("year", year);
        query.executeUpdate();
    }
}