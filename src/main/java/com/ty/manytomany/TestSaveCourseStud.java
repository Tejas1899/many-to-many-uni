package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCourseStud {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Course course1=new Course();
	course1.setName("HTML");
	course1.setDuration("1 months");
	Course course2 =new Course();
	course2.setName("Java");
	course2.setDuration("1year");
	Student student=new Student();
	student.setName("johnny");
	student.setAge(21);
	List<Course> list=new ArrayList<Course>();
	list.add(course2);
	list.add(course1);
	student.setCourses(list);
	entityTransaction.begin();
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityManager.persist(student);
	entityTransaction.commit();
}
}
