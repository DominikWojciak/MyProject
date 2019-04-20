package pl.coderslab.flat;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FlatService {

    @Autowired
    private FlatRepository flatRepository;

    public void create(Flat flat) {
        flatRepository.save(flat);
    }

    public Flat read(Long id) {
        return flatRepository.findById(id).orElse(null);
    }

    public Flat readWithOwners(Long id) {
        Flat flat = read(id);
        Hibernate.initialize(flat.getOwners());
        return flat;
    }

    public void update(Flat flat) {
        flatRepository.save(flat);
    }

    public void delete(Long id) {
        flatRepository.deleteById(id);
    }

    public List<Flat> findAll() {
        return flatRepository.findAll();
    }

    public List<Flat> findAllPropositions() {
        return flatRepository.findByProposition(true);
    }
}