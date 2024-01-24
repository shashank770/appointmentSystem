package com.jpa.test.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
    @SequenceGenerator(
			name="appointment_seq",
			sequenceName="appointment_seq",
			allocationSize=1
	)
    @GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="appointment_seq"
	)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate date;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long id, User user, LocalDate date) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
	}

	public Appointment(User user, LocalDate date) {
		super();
		this.user = user;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", user=" + user + ", dateTime=" + date + "]";
	}   
}
