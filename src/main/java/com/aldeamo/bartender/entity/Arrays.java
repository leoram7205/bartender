package com.aldeamo.bartender.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="arrays")
public class Arrays {
	
	@Id
	@GeneratedValue(generator="sequenciaIdArray") 
	@SequenceGenerator(name="sequenciaIdArray",sequenceName="seq_id_array", allocationSize=1)
    @Column(name = "id", columnDefinition = "NUMERIC")
	Integer id;
	@Column(name = "input_array", columnDefinition = "VARCHAR(20)")
	String input_array;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInput_array() {
		return input_array;
	}
	public void setInput_array(String input_array) {
		this.input_array = input_array;
	}
	
}
