/*
Problem: Print Even and Odd Numbers Using Two Threads
-----------------------------------------------------

Problem Description:
Create a Java program that demonstrates multithreading by creating two threads:
EvenThread: Prints all even numbers from 1 to 20.
OddThread: Prints all odd numbers from 1 to 20.

Requirements:
You can create threads either by extending Thread or implementing Runnable.
Each thread should print its respective numbers in the run() method.
Start both threads in the main() method using the start() method.
Numbers can appear in any order depending on thread scheduling.
Sample Output (possible):
Even: 2
Odd: 1
Even: 4
Odd: 3
Odd: 5
Even: 6
...


Hints:
Use a for loop in each thread to print numbers.
Pass a label like "Even" or "Odd" when printing to distinguish outputs.
Threads may run concurrently, so output order may vary.*/

package com.nit.day1;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the range:");
		int range = scanner.nextInt();
		Thread evenThread = new Thread(()->{
			for(int i = 1; i<=range; i++) {
				if(i%2==0) {
					System.out.println("Even : " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread oddThread = new Thread(()->{
			for(int i = 1; i<=range; i++) {
				if(i%2!=0) {
					System.out.println("Odd : " + i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		oddThread.start();
		evenThread.start();
		
	}
}
