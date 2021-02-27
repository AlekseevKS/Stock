package ru.itmonopoly.java01.stock.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.dialect.TypeNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmonopoly.java01.stock.model.Type;
import ru.itmonopoly.java01.stock.repo.TypeRepository;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;

@Controller

@RequestMapping("/types")
public class TypeController {

    private final TypeRepository typeRepository;


    @Autowired
    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping
    public String types(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        return "type/index";
    }

    @GetMapping("/new")
    public String newType() {
        return "type/new";
    }

    @PostMapping("/new")
    public String create(@RequestParam("typeName") String name) {
        Type type = new Type(name);
        typeRepository.save(type);
        return "redirect:/types";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        typeRepository.deleteById(id);
        return "redirect:/types";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", id);
        return "type/edit";
    }

    @PostMapping("/edit/{id}")
    public String change(@PathVariable("id") Long id, @RequestParam("typeName") String name) {
        Type type = typeRepository.findById(id).get();
        type.setTypeName(name);
        typeRepository.save(type);
        return "redirect:/types";
    }



}
