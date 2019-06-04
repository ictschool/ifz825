package ch.wiss.m404.example;

import java.time.LocalDate;

public class Starter {

	public static void main(String[] args) {
		
		Student student = new Student();
		Student student2 = new Student("Buchs");
		
		System.out.println(student.getName());		
		
		student.setName("Muster");
		student.setBirthDate(LocalDate.of(1983, 10, 29));
		
		System.out.println(student.getName());
		System.out.println(student.getBirthDate());
		
		System.out.println(student2.getName());
		
	}

}
