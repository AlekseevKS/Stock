package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmonopoly.java01.stock.model.Parts;
import ru.itmonopoly.java01.stock.repo.ModelRepository;
import ru.itmonopoly.java01.stock.repo.PartRepository;

@Controller
@RequestMapping("types/model/{id}/parts")
public class PartController {

    private final PartRepository partRepository;

    private final ModelRepository modelRepository;

    public PartController(PartRepository partRepository, ModelRepository modelRepository) {

        this.partRepository = partRepository;
        this.modelRepository = modelRepository;
    }

    @GetMapping
    public String parts(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("parts", partRepository.findAll());
        return "parts/index";
    }

    @GetMapping("/new")
    public String newPart() {
        return "parts/new";
    }

    @PostMapping
    public String create(@RequestParam("name") String name) {
        Parts part = new Parts();
        partRepository.save(part);
        return "redirect:/parts";
    }

}

