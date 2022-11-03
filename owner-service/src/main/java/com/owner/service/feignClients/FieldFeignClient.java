package com.owner.service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.owner.service.models.Field;

//Indicate that it is a feign client to access the post methods
@FeignClient(name = "field-service", url = "http://localhost:8002")
@RequestMapping("/field")
public interface FieldFeignClient {

	@PostMapping
	public Field save(@RequestBody Field field);
	
}
