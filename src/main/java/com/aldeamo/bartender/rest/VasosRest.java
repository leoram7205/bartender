package com.aldeamo.bartender.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.bartender.dto.ReqBartenderDTO;
import com.aldeamo.bartender.service.VasosService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/vasos")
public class VasosRest {
	@Autowired
	private  VasosService vasosSrv;
	
	@PostMapping(value = "/ordena")
	@ApiOperation(value = "String", nickname = "Ordena vasos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Resultado Exisotso", response = ResponseEntity.class)})
	public ResponseEntity<String> save(@RequestBody ReqBartenderDTO reqBartenderDto) {
		String respuesta;
		
		respuesta = this.vasosSrv.ordenarVasos(reqBartenderDto);
		return new ResponseEntity<String>(respuesta, HttpStatus.ACCEPTED);
	}
}
