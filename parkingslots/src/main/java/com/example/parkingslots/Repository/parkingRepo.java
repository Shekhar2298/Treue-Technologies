package com.example.parkingslots.Repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parkingslots.Model.ParkingModel;

public interface parkingRepo extends JpaRepository<ParkingModel, Integer>{

  //  List<ParkingModel> findAvailableSpots(String location, String date, String time);
    
}
