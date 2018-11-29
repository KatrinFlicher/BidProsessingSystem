package com.katrinflicher.bidprosessingsystem.controllers;

import com.katrinflicher.bidprosessingsystem.domain.Request;
import com.katrinflicher.bidprosessingsystem.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    RequestRepository repository;

    @GetMapping("/usermodule")
    public String main(Model model){
        return "user";
    }

    @PostMapping("add")
    public String add(@RequestParam String text, @RequestParam Double bid, @RequestParam Data data, Model model){
        Request request = new Request(text, bid, data);
        Request request1 = repository.save(request);
        if (request1!=null){
            model.addAttribute("message", "Your request are successfully added!");
        }
        else model.addAttribute("message", "Something went wrong");
        return "user";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model){
        Request request = repository.findByText(filter);
        if (request.getAccept().equals("Accept"))
        model.addAttribute("accept", "Your request was accepted.");
        else model.addAttribute("accept","Your request was rejected.");
        return "user";

    }

}
