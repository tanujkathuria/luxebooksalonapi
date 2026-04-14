package com.developersworld.luxebooksalonapi.controller;

import com.developersworld.luxebooksalonapi.entity.Booking;
import com.developersworld.luxebooksalonapi.service.BookingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BookingController {
    // Autowire the service layer and add the
    @Autowired
    BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
        Booking savedBooking = bookingService.saveBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/booking")
    public ResponseEntity<List<Booking>> fetchAllBookings(){
         return ResponseEntity.ok(bookingService.fetchAllBookings());
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> fetchBooking(@PathVariable Integer bookingId) {
        return ResponseEntity.ok(bookingService.fetchBooking(bookingId));
    }
}
