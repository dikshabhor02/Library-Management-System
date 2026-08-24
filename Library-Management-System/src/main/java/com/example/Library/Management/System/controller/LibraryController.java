package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.entity.User;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Library.Management.System.entity.Book;



@Controller
public class LibraryController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BookRepository bookRepo;


    // Login Page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }


    // Login
    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password) {

        User user = userRepo.findByUsernameAndPassword(username, password);

        if (user != null) {
            return "redirect:/home";
        }

        return "redirect:/";
    }


    // Registration Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }


    // Register User
    @PostMapping("/register")
    public String register(User user) {

        userRepo.save(user);

        return "redirect:/";
    }


    // Home Page
    @GetMapping("/home")
    public String home() {
        return "home";
    }


    // Add Book Page
    @GetMapping("/add")
    public String addPage() {
        return "add";
    }


    // Add Book
    @PostMapping("/add")
    public String addBook(Book book) {

        bookRepo.save(book);

        return "redirect:/list";
    }


    // Book List
    @GetMapping("/list")
    public String bookList(Model model) {

        model.addAttribute("books", bookRepo.findAll());

        return "list";
    }


    // Update Book Page
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Long id, Model model) {

        Book book = bookRepo.findById(id).orElse(null);

        model.addAttribute("book", book);

        return "update";
    }


    // Update Book
    @PostMapping("/update")
    public String updateBook(Book book) {

        bookRepo.save(book);

        return "redirect:/list";
    }

    @GetMapping("/update")
    public String updatePage() {
        return "update";
    }





}