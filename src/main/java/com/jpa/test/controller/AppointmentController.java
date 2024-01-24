package com.jpa.test.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.model.Appointment;
import com.jpa.test.service.AppointmentService;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {
	private AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService)
	{
		this.appointmentService=appointmentService;
	}
	
	@GetMapping("/getAppointments")
	public List<Appointment> getAppointments() {
		System.out.println("All Appointments printed");
		return appointmentService.getAppointments();
	}
	
	@PostMapping("/postAppointment")
	public void registerNewAppointment(@RequestBody Appointment appointment) {
		appointmentService.addNewAppointment(appointment);
	}
	
	@DeleteMapping(path="/{appointmentId}")
	public void deleteAppointment(@PathVariable("appointmentId") Long appointmentId) {
		appointmentService.deleteAppointment(appointmentId);
	}
	
	@PutMapping(path="/{appointmentId}/{userId}/{userUsername}/{userPassword}")
	public void updateAppointment(
			@PathVariable("appointmentId") Long appointmentId,
			@PathVariable("userId") long userId,
			@PathVariable("userUsername") String username,
			@PathVariable("userPassword") String password,
			@RequestParam(required=false) LocalDateTime datetime) {
		appointmentService.updateAppointment(appointmentId, userId, username, password, datetime);
	}

}
