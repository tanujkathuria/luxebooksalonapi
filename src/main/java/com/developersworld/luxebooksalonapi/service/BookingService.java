package com.developersworld.luxebooksalonapi.service;

import com.developersworld.luxebooksalonapi.entity.Booking;
import com.developersworld.luxebooksalonapi.entity.ServiceEntity;
import com.developersworld.luxebooksalonapi.repository.BookingRepository;
import com.developersworld.luxebooksalonapi.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public Booking saveBooking(Booking booking){
        if(validateBooking(booking))
            throw new RuntimeException("invalid booking");
        ServiceEntity serviceEntity = booking.getService();
        ServiceEntity savedService = serviceRepository.save(serviceEntity);
        booking.setService(savedService);
        return bookingRepository.save(booking);
    }

    public List<Booking> fetchAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking fetchBooking(Integer bookingId){
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("booking id is not found"));
    }

    private boolean validateBooking(Booking booking){
        return booking == null || booking.getService() == null;
    }
}
