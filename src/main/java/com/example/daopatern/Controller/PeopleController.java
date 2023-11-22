package com.example.daopatern.Controller;

import com.example.daopatern.dao.GenericDAO;
import com.example.daopatern.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final GenericDAO<PersonModel> personDAO;

    @Autowired
    public PeopleController(GenericDAO<PersonModel> personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.getAll());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getById(id).orElse(null));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") PersonModel personModel) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") PersonModel personModel) {
        personDAO.create(personModel);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.getById(id).orElse(null));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") PersonModel personModel, @PathVariable("id") int id) {
        personDAO.update(id, personModel);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
