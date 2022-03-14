package com.aldeamo.bartender.commons;

import java.io.Serializable;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {

	T save(T entity) throws SQLDataException, SQLException;
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();
}
