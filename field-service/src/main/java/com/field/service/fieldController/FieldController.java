package com.field.service.fieldController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.field.service.fieldEntity.Field;
import com.field.service.fieldService.FieldService;

@RestController
@RequestMapping("/field")
public class FieldController {

	@Autowired
	private FieldService fieldService;
	
	@GetMapping
	public ResponseEntity<List<Field>> listFields(){
		List<Field> fields = fieldService.getAll();
		if(fields.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(fields);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Field> getField(@PathVariable("id") int id){
		Field field = fieldService.getFieldById(id);
		if(field == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(field);
	}

	@PostMapping
	public ResponseEntity<Field> saveField(@RequestBody Field field){
		Field newField = fieldService.save(field);
		return ResponseEntity.ok(newField);
	}

	@GetMapping("/owner/{ownerId}")
	public ResponseEntity<List<Field>> listFieldsByOwnerId(@PathVariable("ownerId") int id){
		List<Field> field = fieldService.byOwnerId(id);
		if(field.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(field);
	}

}
