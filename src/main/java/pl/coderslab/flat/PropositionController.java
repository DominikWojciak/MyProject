package pl.coderslab.flat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.district.District;
import pl.coderslab.district.DistrictService;
import pl.coderslab.owner.Owner;
import pl.coderslab.owner.OwnerService;

import java.util.List;

@Controller
@RequestMapping("/propositions")
public class PropositionController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private OwnerService ownerService;


    @GetMapping("/list")
    public String getList(Model model) {
        List<Flat> propositions = flatService.findAllPropositions();
        model.addAttribute("propositions", propositions);
        return "propositionList";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("flat", new Flat());
        return "flat";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Validated(PropositionValidationGroup.class) Flat flat, BindingResult result) {
        if (result.hasErrors()) {
            return "flat";
        }
        flat.setProposition(true);
        flatService.create(flat);
        return "redirect:list";
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