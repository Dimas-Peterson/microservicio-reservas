package com.field.service.fieldRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.field.service.fieldEntity.Field;

@Repository
public interface iFieldRepository extends JpaRepository<Field, Integer>{

	List<Field> findByOwnerId(int ownerId);
	
}
