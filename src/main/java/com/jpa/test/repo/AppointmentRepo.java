package com.jpa.test.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{
	
}