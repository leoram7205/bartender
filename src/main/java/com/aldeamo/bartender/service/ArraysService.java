package com.aldeamo.bartender.service;

import com.aldeamo.bartender.commons.GenericService;
import com.aldeamo.bartender.dto.ArraysDTO;
import com.aldeamo.bartender.entity.Arrays;

public interface ArraysService extends GenericService<Arrays, Integer>{
	ArraysDTO findByid(Integer id);
}
