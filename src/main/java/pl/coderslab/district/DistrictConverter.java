package pl.coderslab.district;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class DistrictConverter implements Converter<String, District> {

    @Autowired
    private DistrictService districtService;

    @Override
    public District convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return districtService.read(id);
    }
}
