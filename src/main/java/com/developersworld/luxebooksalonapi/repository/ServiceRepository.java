package com.developersworld.luxebooksalonapi.repository;

import com.developersworld.luxebooksalonapi.entity.ServiceEntity;
import com.developersworld.luxebooksalonapi.service.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository  extends JpaRepository<ServiceEntity, Integer> {
}
