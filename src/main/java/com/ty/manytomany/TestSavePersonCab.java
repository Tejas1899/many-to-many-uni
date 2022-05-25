package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person1=entityManager.find(Person.class, 1);
		Person person2=entityManager.find(Person.class, 2);
		Cab cab=new Cab();
		cab.setDriver_name("Kumara");
		cab.setCost(20.00);
		List<Person> list=new ArrayList<Person>();
		list.add(person2);
		list.add(person1);
		cab.setPersons(list);
		
		entityTransaction.begin();
		entityManager.persist(cab);
		
		entityTransaction.commit();
		
	}
}
