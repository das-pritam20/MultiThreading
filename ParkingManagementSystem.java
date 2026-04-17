/*
1.Parking Spot Problem
-----------------------
There is only one parking spot available, but two cars arrive around the same time.
If the parking spot is taken, the other car must wait until it becomes free.

Create a shared ParkingSpot class that keeps track of whether the spot is occupied or free.
Use wait() and notify() so that when the spot is occupied, the other thread waits.

Create two threads representing two cars.
Print messages like:

Car A parked…
Car B waiting outside…
Car A left the parking spot…
Car B parked…
Car B left the parking spot…


Ensure only one car can park at a time.*/

package com.nit.day2;

class CarParking{
	boolean isFree = true;
	public synchronized void park() {
		if(isFree == false) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		isFree = false;
		System.out.println(Thread.currentThread().getName()+" parked…");
		
	}
	public synchronized void leaveParking(){
		isFree = true;
		System.out.println(Thread.currentThread().getName()+" left the parking spot…");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();
	}
}

public class ParkingManagementSystem {
	public static void main(String[] args) {
		CarParking cp = new CarParking();
		
		Runnable r = () -> {
			cp.park();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cp.leaveParking();
		};
		
		Thread carA = new Thread(r,"Car A");
		
		Thread carB = new Thread(r,"Car B");
		
		carA.start();
		carB.start();
	}
}
