package com.csv.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String adrress;
	private int age;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int id, String name, String adrress, int age) {
		super();
		this.id = id;
		this.name = name;
		this.adrress = adrress;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
