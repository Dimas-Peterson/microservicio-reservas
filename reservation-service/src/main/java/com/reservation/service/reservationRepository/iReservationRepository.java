package com.reservation.service.reservationRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.service.reservationEntity.Reservation;

@Repository
public interface iReservationRepository extends JpaRepository<Reservation, Integer>{

	List<Reservation> findByUserId(int userId);
	
}
