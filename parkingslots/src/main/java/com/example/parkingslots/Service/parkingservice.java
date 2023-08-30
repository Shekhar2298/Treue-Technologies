package com.example.parkingslots.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingslots.Model.ParkingModel;
import com.example.parkingslots.Repository.parkingRepo;

@Service
public class parkingservice {
    @Autowired
    private parkingRepo repo;
    public List<ParkingModel> findAvailableSpotslocation;

    public void AddAll(ParkingModel u) {
        repo.save(u);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<ParkingModel> Adding() {
        return repo.findAll();
    }

    public ParkingModel updateid(Integer id) {
        Optional<ParkingModel> tab = repo.findById(id);
        if (tab.isPresent()) {
            return tab.get();
        } else {
            return null;
        }
    }

//     public boolean confirmBooking(ParkingModel bookingRequest) {
//         // Get the selected parking spot by ID from the repository
//        ParkingModel parkingSpot = repo.findById(bookingRequest.getId())
//                 .orElseThrow(() -> new IllegalArgumentException("Invalid parking spot ID"));

//         if (!parkingSpot.isAvailable()) {
//             throw new IllegalStateException("Selected parking spot is not available for booking.");
//         }

//         // Update parking spot status
//         parkingSpot.setAvailable(false);
//         parkingSpotRepository.save(parkingSpot);

//         // Create a new booking
//         Booking booking = new Booking();
//         booking.setParkingSpot(parkingSpot);
//         booking.setName(bookingRequest.getName());
//         booking.setEmail(bookingRequest.getEmail());
//         booking.setBookingDate(new Date()); // Set the current date as booking date
//         bookingRepository.save(booking);
//     }
// }
// }

    // public class ParkingSpotService {

    //     public List<ParkingModel> findAvailableSpots(String location, String date, String time) {
    //         // Implement your database query logic
    //         List<ParkingModel> availableSpots = repo.findAvailableSpots(location, date, time);
    //         return availableSpots;
    //     }
    // }

    // public List<ParkingModel> findAvailableSpots(String location, String date, String time) {
    //     return null;
    // }

}
