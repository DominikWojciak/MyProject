package pl.coderslab.owner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class OwnerConverter implements Converter<String, Owner> {

    @Autowired
    private OwnerService ownerService;

    @Override
    public Owner convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return ownerService.read(id);
    }
}