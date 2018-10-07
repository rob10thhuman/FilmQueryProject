package com.skilldistillery.filmquery.entities;

public class Actor {
	private int id; 
	private String firstName, lastName;
	
	
	public Actor(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
//		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		return "Actor [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 
	
	
}
