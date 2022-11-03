package com.owner.service.ownerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.owner.service.models.Field;
import com.owner.service.ownerEntity.Owner;
import com.owner.service.ownerService.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	

	@Autowired
	private OwnerService ownerService;
	
	@GetMapping
	public ResponseEntity<List<Owner>> listOwner() {
		List<Owner> owners = ownerService.getAll();
		if(owners.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(owners);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Owner> getOwner(@PathVariable("id") int id) {
		Owner owner = ownerService.getOwnerById(id);
		if(owner == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(owner);
	}
	
	@PostMapping
	public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
		Owner newOwner = ownerService.save(owner);
		return ResponseEntity.ok(newOwner);
	}
	
	//Communication with field-service with RestTemplate service
	@GetMapping("/field/{ownerId}")
	public ResponseEntity<List<Field>> listFields(@PathVariable("ownerId") int id){
		//Find owner by id
		Owner owner = ownerService.getOwnerById(id);
		if(owner == null) {
			return ResponseEntity.notFound().build();
		}
		
		//Search owner's fields
		List<Field> fields = ownerService.getFields(id);
		return ResponseEntity.ok(fields);
	}
	
	@PostMapping("/field/{ownerId}")
	public ResponseEntity<Field> saveField(@PathVariable("ownerId") int ownerId, @RequestBody Field field) {
		Field newField = ownerService.saveField(ownerId, field);
		return ResponseEntity.ok(newField);
	}
}














