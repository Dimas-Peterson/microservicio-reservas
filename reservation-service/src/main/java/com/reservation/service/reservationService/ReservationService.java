package com.reservation.service.reservationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.service.reservationEntity.Reservation;
import com.reservation.service.reservationRepository.iReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private iReservationRepository reservationRepository;
	
	public List<Reservation> getAll(){
		return reservationRepository.findAll();
	}
	
	public Reservation getReservationById(int id) {
		return reservationRepository.findById(id).orElse(null);
	}
	
	public Reservation save(Reservation reservation) {
		Reservation newReservation = reservationRepository.save(reservation);
		return newReservation;
	}
	
	public List<Reservation> byUserId(int userId){
		return reservationRepository.findByUserId(userId);
	}
}
