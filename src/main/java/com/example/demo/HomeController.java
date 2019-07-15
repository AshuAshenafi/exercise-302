package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    TODOListRepository todoListRepository;

    @RequestMapping("/")
    public String listTODOs(Model model){
        model.addAttribute("TODOs", todoListRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String todoForm(Model model){
        model.addAttribute("todo", new TODOList());
        return "todoform";
    }

    @PostMapping("/process")
    public String processForm(@Valid TODOList todoList, BindingResult result){
        if(result.hasErrors()){
            return "todoform";
        }

        todoListRepository.save(todoList);
        return "redirect:/";
    }



}
