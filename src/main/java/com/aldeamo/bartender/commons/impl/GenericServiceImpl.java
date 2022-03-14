package com.aldeamo.bartender.commons.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aldeamo.bartender.commons.GenericService;


@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

	@Override
	public T save(T entity) throws DataIntegrityViolationException {
		T entidad;
		try {
			entidad = getDao().save(entity);
		}catch(Exception ex) {
			throw new DataIntegrityViolationException("Error Integridad", ex.getCause());
		}
		
		return entidad;
	}

	@Override
	public void delete(ID id) {
		getDao().deleteById(id);
	}

	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if (obj.isPresent()){
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> resultList = new ArrayList<>();
		getDao().findAll().forEach(obj -> resultList.add(obj));
		return resultList;
	}
	
	public abstract CrudRepository<T, ID> getDao();

}
