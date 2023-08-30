package com.example.parkingslots.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.parkingslots.Model.ParkingModel;
//import com.example.parkingslots.Model.ParkingSpot;
import com.example.parkingslots.Service.parkingservice;
//import com.example.parkingslots.Service.spotservice;

@Controller
public class parkingcontroller {

    @Autowired
    private parkingservice serv;
 
    @GetMapping("/database")
    public String Home(Model model) {
        List<ParkingModel> us = serv.Adding();
        model.addAttribute("data", us);
        return "Database";
    }

    @PostMapping("/park")
    public String Park(@ModelAttribute ParkingModel use, Model model) {
        serv.AddAll(use);
        return "search";
    }
  
    @GetMapping("/deletedata/{id}")
    public String deleteid(@PathVariable Integer id, Model model) {
        serv.delete(id);
        model.addAttribute("data", serv.Adding());

        return "Database";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ParkingModel user, Model model) {
        List<ParkingModel> us = serv.Adding();
        model.addAttribute("data", us);
        model.addAttribute("updatedata", user.getName());
        serv.AddAll(user);
        return "Database";

    }

    @GetMapping("/update/{id}")
    public String Updatebyid(@PathVariable Integer id, Model model) {
        ParkingModel u = serv.updateid(id);

        model.addAttribute("updatedata", u);
        return "update";
    }

    @GetMapping("/")
    public String Register() {
        return "index";
    }

    @GetMapping("/search")
    public String Search() {
        return "search";
    }

    @GetMapping("/book")
    public String Book() {
        return "bookslot";
    }

    @GetMapping("/login")
    public String Login() {
        return "loginpage";
    }

    // @Autowired
    // private ParkingSpotRepository parkingSpotRepository;

    // @GetMapping("/search")
    // public ResponseEntity<List<ParkingSpot>> searchParkingSpots(
    // @RequestParam String location,
    // @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // LocalDateTime startTime,
    // @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // LocalDateTime endTime) {
    // List<ParkingSpot> availableSpots = parkingSpotRepository
    // .findByLocation(
    // location, startTime, endTime);
    // return ResponseEntity.ok(availableSpots);

    // }

    // @GetMapping("/search")
    // public String searchParking(@RequestParam String location,
    // @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime
    // startTime,
    // @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime
    // endTime,
    // Model model) {

    // List<ParkingSpot> availableSpots = parkingSpotRepository.findAll(location,
    // startTime, endTime, false);

    // model.addAttribute("availableSpots", availableSpots);
    // return "search-results";
    // }
}
