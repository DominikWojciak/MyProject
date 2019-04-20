package pl.coderslab.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OwnerService {

    @Autowired
    private OwnerDao ownerDao;

    public void create(Owner owner) {
        ownerDao.create(owner);
    }

    public Owner read(Long id) {
        return ownerDao.read(id);
    }

    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    public void delete(Long id) {
        ownerDao.delete(id);
    }

    public List<Owner> findAll() {
        return ownerDao.findAll();
    }
}