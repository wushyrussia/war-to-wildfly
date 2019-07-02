package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")

public class Home {

    @Resource
    private ItemDao personDao;

    @GetMapping("/")
    public String people(Model model) {
        model.addAttribute("person", new Item());
        model.addAttribute("list", personDao.findAll());
        return "index";
    }

    @PostMapping
    public String submit(Item person) {
        System.out.println(person);
        personDao.save(person);
        return "redirect:/";
    }


}
