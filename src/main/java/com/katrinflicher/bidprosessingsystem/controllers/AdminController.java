package com.katrinflicher.bidprosessingsystem.controllers;

import com.katrinflicher.bidprosessingsystem.domain.Request;
import com.katrinflicher.bidprosessingsystem.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    RequestRepository repository;

    @GetMapping("/adminmodule")
    public String main(Model model){
        Iterable<Request> requests = repository.findAll();
        model.addAttribute("requests",requests);
        if (requests!=null)
        statistics(requests, model);
        return "admin";
    }

   @PostMapping("accept")
    public String accept(@RequestParam Integer id,@RequestParam String action, Model model){
       int i = repository.setAcceptRequest(action, id);
       Iterable<Request> requests = repository.findAll();
        model.addAttribute("requests",requests);
      statistics(requests, model);
        return "admin";
    }


    private void statistics(Iterable<Request> requests, Model model){
        int countAccept = 0;
        int countReject = 0;
        for (Request request: requests){
            if (request.getAccept()!=null){
            if (request.getAccept().equals("Accept"))
                countAccept++;
            else countReject++;}
        }
        model.addAttribute("countAccept", countAccept);
        model.addAttribute("countReject", countReject);
    }


}
