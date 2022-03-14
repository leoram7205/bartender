package com.aldeamo.bartender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeamo.bartender.clientws.ClienteArraysRest;
import com.aldeamo.bartender.dto.ArraysDTO;
import com.aldeamo.bartender.dto.ReqBartenderDTO;
import com.aldeamo.bartender.service.VasosService;

@Service
public class VasosServiceImpl implements VasosService{

	@Autowired
	ClienteArraysRest clienteArrays;
	
	String[] arrResp;
	String[] arrB;
	String[] arrA;
	Integer indResp;
	
	@Override
	public String ordenarVasos(ReqBartenderDTO request) {
		ArraysDTO arraysDTO = new ArraysDTO();
		Integer[] arrPrimos = {2,3,5,7,11,13,17};
		String[] arrPila;
		
		arrResp = new String[8];
		indResp = 0;
		arraysDTO = clienteArrays.getArrays(request.getPila());
		
		arrPila = arraysDTO.getInput_array().split(",");
		
		for(int i=0;i < request.getIteraciones();i++) {
			arrPila = validaVasos(arrPila, arrPrimos[i]);
		}
		
		addUltimos(arrPila);
		
		return convArrToStr(arrResp);
	}
	
	public String[] validaVasos(String[] arrPila, Integer primo) {
		String[] respTmp;
		Double resEvalua=0.0;
		Integer indA=0;
		Integer indB=0;
		StringBuffer strB = new StringBuffer();
		StringBuffer strA = new StringBuffer();
		
		
		for(String numVaso : arrPila) {
			resEvalua = (double) (Integer.valueOf(numVaso) % primo);
			if(resEvalua == 0) {
				strB.append(numVaso + ",");
				indB++;
			}else {
				strA.append(numVaso +",");
				indA++;
			}
		}
		
		respTmp = strB.toString().split(",");
		for(String num : respTmp) {
			if (!num.isEmpty() || !num.isBlank()) {
				arrResp[indResp] = num;
				indResp++;
			}
			
		}
		arrA = strA.toString().split(",");
		
		return arrA;
	}
	
	public String convArrToStr(String[] arrStr) {
	
		String resp = "";
		
		for(String let : arrStr) {
			resp = (resp.isEmpty() ? let : (let == null)? resp + "":resp + "," + let);
		}
		
		return resp;
	}

	public void addUltimos(String[] ultimos) {
		
		for(int i=0;i<ultimos.length;i++) {
			arrResp[indResp] = ultimos[i];
			indResp++;
		}
	
	}
}
