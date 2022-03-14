package com.aldeamo.bartender.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.bartender.dto.ArraysDTO;
import com.aldeamo.bartender.service.ArraysService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/arrays")
public class ArraysRest {
	
	@Autowired
	private ArraysService arraysSrv;

	@GetMapping(value="/get/{id}")
	@ApiOperation(value = "arrays", nickname = "Consultar arrays por Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Resultado Exisotso", response = ResponseEntity.class)})
	public ResponseEntity<ArraysDTO> get(@PathVariable Integer id){
		
		return new ResponseEntity<ArraysDTO>(this.arraysSrv.findByid(id), HttpStatus.OK);
		
	}
}
