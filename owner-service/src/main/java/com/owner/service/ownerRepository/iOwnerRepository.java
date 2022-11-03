package com.owner.service.ownerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owner.service.ownerEntity.Owner;

@Repository
public interface iOwnerRepository extends JpaRepository<Owner, Integer>{
	
}

