package com.example.daopatern.Controller;

import com.example.daopatern.dao.GenericDAO;
import com.example.daopatern.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final GenericDAO<BookModel> bookDAO;

    @Autowired
    public BookController(GenericDAO<BookModel> bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.getAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getById(id).orElse(null));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") BookModel bookModel) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") BookModel bookModel) {
        bookDAO.create(bookModel);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.getById(id).orElse(null));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") BookModel bookModel, @PathVariable("id") int id) {
        bookDAO.update(id, bookModel);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
