package jantarDosFilosofos;

import java.util.concurrent.Semaphore;

public class Table {
	private Semaphore forks[];
	
	public Table() {
		this.forks = new Semaphore[5];
		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Semaphore(1);
		}
	}

	public void eat(int id) {
		int left = id;
		int right = (id + 1) % forks.length;
		
		if (right < left) {
			int aux = right;
			right = left;
			left = aux;
		}
		
		try {
			forks[left].acquire();
			forks[right].acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Philosopher " + id + " started to eat");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Philosopher " + id + " is done eating");
		
		forks[left].release();
		forks[right].release();
	}
}

