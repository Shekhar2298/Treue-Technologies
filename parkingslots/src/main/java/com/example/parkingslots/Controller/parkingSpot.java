package com.example.parkingslots.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.parkingslots.Model.ParkingSpot;
import com.example.parkingslots.Service.spotservice;

@Controller
public class parkingSpot {

 @Autowired
    private spotservice spotserv;


       @GetMapping("/data")
    public String SpotHome(Model model) {
        List<ParkingSpot> us = spotserv.Addingspot();
        model.addAttribute("data", us);
        return "parkData";
    }

    @PostMapping("/parkSpot")
    public String Spotpark(@ModelAttribute ParkingSpot use, Model model) {
        spotserv.Addspot(use);
        return "search";
    }

}
