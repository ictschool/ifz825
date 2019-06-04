package ch.wiss.m404.example;

import java.time.LocalDate;

public class Student {
	
	private String name;
	private String firstName;
	private LocalDate birthDate;
	
	public Student() {
		System.out.println("Objekt Student wurde angelegt");
	}
	
	public Student(String name) {
		System.out.println("Student mit Name wurde angelegt: " + name);
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
