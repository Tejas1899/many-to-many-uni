package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveManyUnique {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Course course1=entityManager.find(Course.class, 2);
	Course course2=entityManager.find(Course.class,3);
	
	Student student=new Student();
	student.setName("niki");
	student.setAge(24);
	List< Course> list=new ArrayList<Course>();
	list.add(course2);
	list.add(course1);
	student.setCourses(list);
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
}
}
