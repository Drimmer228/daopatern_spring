package com.example.daopatern.Controller;

import com.example.daopatern.dao.GenericDAO;
import com.example.daopatern.model.HouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/houses")
public class HouseController {

    private final GenericDAO<HouseModel> houseDAO;

    @Autowired
    public HouseController(GenericDAO<HouseModel> houseDAO) {
        this.houseDAO = houseDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("houses", houseDAO.getAll());
        return "houses/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("house", houseDAO.getById(id).orElse(null));
        return "houses/show";
    }

    @GetMapping("/new")
    public String newHouse(@ModelAttribute("house") HouseModel houseModel) {
        return "houses/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("house") HouseModel houseModel) {
        houseDAO.create(houseModel);
        return "redirect:/houses";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("house", houseDAO.getById(id).orElse(null));
        return "houses/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("house") HouseModel houseModel, @PathVariable("id") int id) {
        houseDAO.update(id, houseModel);
        return "redirect:/houses";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        houseDAO.delete(id);
        return "redirect:/houses";
    }
}