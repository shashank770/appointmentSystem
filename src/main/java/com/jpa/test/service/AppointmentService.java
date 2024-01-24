package com.jpa.test.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.model.Appointment;
import com.jpa.test.repo.AppointmentRepo;

@Service
public class AppointmentService {
	
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	public AppointmentService (AppointmentRepo appointmentRepo) {
		this.appointmentRepo=appointmentRepo;
	}

	public List<Appointment> getAppointments() {
		return appointmentRepo.findAll();
	}

	public void addNewAppointment(Appointment appointment) {
			appointmentRepo.save(appointment);		
	}

	public void deleteAppointment(Long appointmentId) {
		boolean exists=appointmentRepo.existsById(appointmentId);
		if(!exists) {
			throw new IllegalStateException("student with id");			
		}
		else {
			appointmentRepo.deleteById(appointmentId);
		}		
	}

	public void updateAppointment(Long appointmentId, Long userId, String username, String password, LocalDateTime datetime) {
		Optional<Appointment> appointment = appointmentRepo.findById(appointmentId);
		if(appointment.isPresent()) {
			
		}
		else {
			throw new IllegalStateException("appointment id not found");
		}
	}

}
