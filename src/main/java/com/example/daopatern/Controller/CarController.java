package com.example.daopatern.Controller;

import com.example.daopatern.dao.GenericDAO;
import com.example.daopatern.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final GenericDAO<CarModel> carDAO;

    @Autowired
    public CarController(GenericDAO<CarModel> carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cars", carDAO.getAll());
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carDAO.getById(id).orElse(null));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") CarModel carModel) {
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") CarModel carModel) {
        carDAO.create(carModel);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", carDAO.getById(id).orElse(null));
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") CarModel carModel, @PathVariable("id") int id) {
        carDAO.update(id, carModel);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carDAO.delete(id);
        return "redirect:/cars";
    }
}
