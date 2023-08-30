package com.example.parkingslots.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingslots.Model.ParkingSpot;
import com.example.parkingslots.Repository.ParkingSpotRepository;

@Service
public class spotservice {
    

    @Autowired
    private ParkingSpotRepository spotrepo;
    //public List<ParkingSpot> findAvailableSpotslocation;

    public void Addspot(ParkingSpot u) {
        spotrepo.save(u);
    }

   
    public List<ParkingSpot> Addingspot() {
        return spotrepo.findAll();
    }

}
