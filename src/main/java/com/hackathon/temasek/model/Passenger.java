/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.temasek.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Passenger {
	@NotNull(message = "Passenger name must not be blank")
	@Size(min = 2, max = 15, message = "Passenger name must be between 2 to 15 Characters")
    private String passengerName;
	@NotNull(message = "Age must not be blank")
    private Integer age;
	@NotNull(message = "Gender must not be blank")
    private String gender;

    public Passenger() {
    }

    public Passenger(String name, Integer age, String gender) {
        this.passengerName = name;
        this.age = age;
        this.gender = gender;
    }

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    
}
