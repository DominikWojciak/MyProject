package pl.coderslab.district;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DistrictService {

    @Autowired
    private DistrictDao districtDao;

    public void create(District district) {
        districtDao.create(district);
    }

    public District read(Long id) {
        return districtDao.read(id);
    }

    public void update(District district) {
        districtDao.update(district);
    }

    public void delete(Long id) {
        districtDao.delete(id);
    }

    public List<District> findAll(){
        return districtDao.findAll();
    }
}