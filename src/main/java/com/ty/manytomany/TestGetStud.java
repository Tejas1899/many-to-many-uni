package com.ty.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class TestGetStud {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	Student student = entityManager.find(Student.class, 3);
	if (student != null) {
		System.out.println("The name is :" + student.getName());
		System.out.println("The Age is :" + student.getAge());

		List<Course> list = student.getCourses();
		for (Course course : list) {
			System.out.println(course.getName());
			System.out.println(course.getDuration());
			System.out.println("--------------------");
		}
	} else {
		System.out.println("Student does not exist");

	}
}
}
