package com.owner.service.ownerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.owner.service.feignClients.FieldFeignClient;
import com.owner.service.models.Field;
import com.owner.service.ownerEntity.Owner;
import com.owner.service.ownerRepository.iOwnerRepository;

@Service
public class OwnerService {
	

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private iOwnerRepository ownerRepository;
	
	@Autowired
	private FieldFeignClient fieldFeignClient;

	// Find and list owners
	public List<Owner> getAll() {
		return ownerRepository.findAll();
	}

	// Find owner by Id
	public Owner getOwnerById(int id) {
		return ownerRepository.findById(id).orElse(null);
	}

	// Create new owner
	public Owner save(Owner owner) {
		Owner newOwner = ownerRepository.save(owner);
		return newOwner;
	}

	// Get fields. Communication with field-service microservice using RestTemplate
	public List<Field> getFields(int ownerId) {
		List<Field> fields = restTemplate.getForObject("http://localhost:8002/field/owner/" + ownerId, List.class);
		return fields;
	}
	
	// Post fields with feign clients
	public Field saveField(int ownerId, Field field) {
		field.setOwnerId(ownerId);
		Field newField = fieldFeignClient.save(field);
		return newField;
	}
	
	
	// Get field by id

	// Save field

}
