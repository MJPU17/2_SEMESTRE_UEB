package co.edu.unbosque.model;

import java.util.LinkedList;
import java.util.Objects;

public class Person {
	
	private String dni;
	private String name;
	private int age;
	private String gender;
	private double weight;
	private double height;
	
	public Person() {
		dni="";
		name="";
		age=0;
		gender="";
		weight=0.0;
		height=0.0;
	}
	
	public Person(String name,int age,String gender,double weigth,double heigth,LinkedList<Person> people) {
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.weight=weigth;
		this.height=heigth;
		this.dni=generateDNI(people);
	}
	
	@Override
	public String toString() {
		return "DNI: "+dni+"\n"+"Name: "+name+"\n"+"Age: "+age+"\n"+"Gender: "+gender+"\n"+"Weigth: "+weight+"Kg\n"+"Heigth: "+height+"cm";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	public boolean equals(String dni) {
		return this.dni.equals(dni);
	}

	public String generateDNI(LinkedList<Person> people) {
		boolean next=true;
		long aux;
		String dni;
		do {
			next=true;
			aux=(long)(Math.random()*99999999+0);
			dni=""+aux+name.charAt(0);
			for(int i=0;i<people.size();i++) {
				if(people.get(i).equals(dni)) {
					next=false;
					break;
				}
			}
		}while(!next);
		return dni;
	}
	
	public static Person findPerson(LinkedList<Person> people,int dni) {
		for(int i=0;i<people.size();i++) {
			if(people.get(i).hashCode()==dni) {
				return people.get(i);
			}
		}
		return null;
	}
	
	

	public String getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
