package pl.coderslab.district;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;


    @GetMapping("/list")
    public String getList(Model model) {
        List<District> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "districtList";
    }

    @GetMapping("/add")
    public String addDistrict(Model model) {
        model.addAttribute("owner", new District());
        return "district";
    }

    @PostMapping("/add")
    public String addOwner(@ModelAttribute @Valid District district, BindingResult result){
        if (result.hasErrors()) {
            return "district";
        }
        districtService.create(district);
        return "redirect:list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        District district = districtService.read(id);
        model.addAttribute("district", district);
        return "district";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid District district, BindingResult result) {
        if (result.hasErrors()) {
            return "district";
        }
        districtService.update(district);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        districtService.delete(id);
        return "redirect:../list";
    }
}