package co.ecu.unbosque.controller;

import java.util.Scanner;

public class AplMain {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt();
		System.out.println(suma(a, b));
		System.out.println(restar(a, b));
	}
	
	public static int suma(int a,int b) {
		return a+b;
	}
	
	public static int restar(int a,int b) {
		return a-b;
	}
}
