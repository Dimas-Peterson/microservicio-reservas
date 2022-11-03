package com.field.service.fieldService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.field.service.fieldEntity.Field;
import com.field.service.fieldRepository.iFieldRepository;

@Service
public class FieldService {

	@Autowired
	private iFieldRepository fieldRepository;
	
	public List<Field> getAll(){
		return fieldRepository.findAll();
	}
	
	public Field getFieldById(int id) {
		return fieldRepository.findById(id).orElse(null);
	}
	
	public Field save(Field field) {
		Field newField = fieldRepository.save(field);
		return newField;
	}
	
	public List<Field> byOwnerId(int ownerId){
		return fieldRepository.findByOwnerId(ownerId);
	}
}
