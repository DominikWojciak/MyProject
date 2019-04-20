package pl.coderslab.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;


    @GetMapping("/list")
    public String getList(Model model) {
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "ownerList";
    }

    @GetMapping("/add")
    public String addOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner";
    }

    @PostMapping("/add")
    public String addOwner(@ModelAttribute @Valid Owner owner, BindingResult result){
        if (result.hasErrors()) {
            return "owner";
        }
        ownerService.create(owner);
        return "redirect:list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Owner owner = ownerService.read(id);
        model.addAttribute("owner", owner);
        return "owner";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "owner";
        }
        ownerService.update(owner);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        ownerService.delete(id);
        return "redirect:../list";
    }


}