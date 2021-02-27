package ru.itmonopoly.java01.stock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmonopoly.java01.stock.repo.ModelRepository;
import ru.itmonopoly.java01.stock.repo.TypeRepository;


@Controller

@RequestMapping("types/model")
public class ModelController {

    private final ModelRepository modelRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public ModelController(ModelRepository modelRepository, TypeRepository typeRepository) {
        this.modelRepository = modelRepository;
        this.typeRepository = typeRepository;
    }

    @GetMapping("/{id}")
    public String model(@PathVariable("id") Long id, Model model) {
        model.addAttribute("models", modelRepository.findAll());
        return "types/model";
    }

    @GetMapping("/{id}/new")
    public String addModel(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", id);
        return "model/add_model";
    }

    @PostMapping("/{id}/new")
    public String create(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("vendor_code") String vendor_code) {
        ru.itmonopoly.java01.stock.model.Model model = new ru.itmonopoly.java01.stock.model.Model();
        model.setName(name);
        model.setVendorCode(vendor_code);

        modelRepository.save(model);

        return "redirect:types/model/{id}";
    }


}
