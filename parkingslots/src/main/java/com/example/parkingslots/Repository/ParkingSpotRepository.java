package com.example.parkingslots.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parkingslots.Model.ParkingSpot;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {

  
}

