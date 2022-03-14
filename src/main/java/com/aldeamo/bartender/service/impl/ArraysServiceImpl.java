package com.aldeamo.bartender.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aldeamo.bartender.commons.impl.GenericServiceImpl;
import com.aldeamo.bartender.dao.ArraysDAO;
import com.aldeamo.bartender.dto.ArraysDTO;
import com.aldeamo.bartender.entity.Arrays;
import com.aldeamo.bartender.service.ArraysService;
import com.aldeamo.bartender.utils.MHelpers;

@Service
public class ArraysServiceImpl extends GenericServiceImpl<Arrays, Integer> implements ArraysService{

	@Autowired
	ArraysDAO arraysDao;
	
	@Override
	public CrudRepository<Arrays, Integer> getDao() {
		return arraysDao;
	}

	@Override
	public ArraysDTO findByid(Integer id) {
		Optional<Arrays> arrays = this.arraysDao.findById(id);
		ArraysDTO arraysDto = MHelpers.modelMapper().map(arrays.get(), ArraysDTO.class);
		
		return arraysDto;
	}
}
