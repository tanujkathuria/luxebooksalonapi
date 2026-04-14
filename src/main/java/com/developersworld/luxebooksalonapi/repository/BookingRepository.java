package com.developersworld.luxebooksalonapi.repository;

import com.developersworld.luxebooksalonapi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
