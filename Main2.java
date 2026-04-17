/*
Problem: Print a Message in Uppercase Using Thread
--------------------------------------------------
Problem Description:
Create a Java program that demonstrates multithreading by creating a
thread that prints a given string in uppercase letters.

Requirements:
Create a class that either extends Thread or implements Runnable.

The class should accept a string as input (through a constructor or setter).

Override the run() method to print the string in uppercase using
String.toUpperCase().
In the main() method, create an instance of your thread class with a
sample string and start the thread using start().

Sample Input:
Hello, Java Threads!

Sample Output:
HELLO, JAVA THREADS!


Hints:
Use the toUpperCase() method of the String class.
Remember to call start() on the thread object, not run().

You can pass the string via the constructor to make your thread reusable
for any message.*/

package com.nit.day1;

import java.util.Scanner;

class MyThread extends Thread{
	String message;

	public MyThread(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public void run() {
		System.out.println(message.toUpperCase());
	}
}

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the message:");
		String message = scanner.nextLine();
		Thread thread = new MyThread(message);
		thread.start();
	}
}
