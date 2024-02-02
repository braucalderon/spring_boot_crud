package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	(StudentDAO studentDAO) injects the studentDAO
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return  runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
//		create multiple students
		System.out.println("Creating 3 students objects");
		Student tempStudent1 = new Student("Paul", "Adam", "adam@gmail.com");
		Student tempStudent2 = new Student("Paula", "Luis", "paula@gmail.com");
		Student tempStudent3 = new Student("Tom", "Chan", "tomchan@gmail.com");


//		save the student objects
		System.out.println("Saving the students........");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
//		create the element object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Paul", "Rodriguez", "rodriguez@gmail.com");

//		save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

//		display if of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}
}
