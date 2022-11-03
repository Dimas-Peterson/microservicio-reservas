package com.reservation.service.reservationController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.service.reservationEntity.Reservation;
import com.reservation.service.reservationService.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public ResponseEntity<List<Reservation>> listReservation(){
		List<Reservation> reservation = reservationService.getAll();
		if(reservation.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(reservation);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reservation> getReservation(@PathVariable("id") int id){
		Reservation reservation = reservationService.getReservationById(id);
		if(reservation == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(reservation);
	}
	
	@PostMapping
	public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
		Reservation newReservation = reservationService.save(reservation);
		return ResponseEntity.ok(newReservation);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Reservation>> listReservationByUserId(@PathVariable("userId") int id){
		List<Reservation> reservation = reservationService.byUserId(id);
		if(reservation.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(reservation);
	}
}
