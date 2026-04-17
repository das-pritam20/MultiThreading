/*
Problem: Print “Ping” and “Pong” Alternately Using Two Threads
--------------------------------------------------------------
Problem Description:
Create a Java program that demonstrates multithreading by creating two
threads that print “Ping” and “Pong” alternately using Thread.sleep() for timing.

Requirements:
Create two classes (or one class reused with parameters) that either extend
Thread or implement Runnable.
One thread should print “Ping”, the other “Pong”.

Use Thread.sleep() to pause between prints (e.g., 500 milliseconds) so
the output alternates clearly.
Repeat the messages multiple times (e.g., 5–10 times).
Start both threads in the main() method using start().

Sample Output (possible):
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong

Hints:
Use Thread.sleep(500); to create a visible delay.
Because threads run concurrently, the order may vary slightly unless synchronized.
For exact alternation, consider using synchronized method with wait() and
notify().*/

package com.nit.day1;

import java.util.Scanner;

class MyThread2 extends Thread{
	int range;

	public MyThread2(String name,int range) {
		super(name);
		this.range = range;
	}
	@Override
	public void run() {
		for (int i = 1; i <= range; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the range:");
		int range = scanner.nextInt();
//		Thread ping = new Thread(() -> {			// using lambda expression to provide implementation to run().
//			for (int i = 1; i <= range; i++) {
//				System.out.println("Ping");
//				try {
//					Thread.sleep(150);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//		Thread pong = new Thread() {			// using anonymous inner class to provide implementation to run().
//			@Override
//			public void run() {
//				for (int i = 1; i <= range; i++) {
//					System.out.println("Pong");
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};

		Thread ping = new MyThread2("Ping",range);
		Thread pong = new MyThread2("Pong",range);
		
		ping.start();
		pong.start();

	}
}
