package pl.coderslab.flat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.district.District;
import pl.coderslab.district.DistrictService;
import pl.coderslab.owner.Owner;
import pl.coderslab.owner.OwnerService;
import java.util.List;

@Controller
@RequestMapping("/flats")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private OwnerService ownerService;


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("flat", new Flat());
        return "flat";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Validated(FlatValidationGroup.class) Flat flat, BindingResult result) {
        if (result.hasErrors()) {
            return "flat";
        }
        flatService.create(flat);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Flat> flats = flatService.findAll();
        model.addAttribute("flats", flats);
        return "flatList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        flatService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Flat flat = flatService.readWithOwners(id);
        model.addAttribute("flat", flat);
        return "flat";
    }/*
    @GetMapping(path="/login")
    public String getCredentials() {
        return "login";
    }
    @PostMapping(path = "/login")
    public String checkCredentials(@RequestParam String login, @RequestParam String password, HttpSession session) {
        User user = userRepo.findByLogin(login);
        if (user == null) {
            return "login";
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            session.setAttribute("user", user);
            return "redirect:/incidents/list";
        }
        return "incidentList";
    }*/

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Validated(FlatValidationGroup.class) Flat flat, BindingResult result) {
        if (result.hasErrors()) {
            return "flat";
        }
        flatService.update(flat);
        return "redirect:../list";
    }

    @ModelAttribute("districts")
    public List<District> getDistricts() {
        return districtService.findAll();
    }

    @ModelAttribute("owners")
    public List<Owner> getOwners() {
        return ownerService.findAll();
    }
}