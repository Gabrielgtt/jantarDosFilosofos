package jantarDosFilosofos;

import java.util.concurrent.Semaphore;

public class Table {
	private boolean forks[];
	
	public Table() {
		this.forks = new boolean[5];
		for (int i = 0; i < forks.length; i++) {
			forks[i] = false;
		}
	}
	
	public synchronized void getFork(int id) {
		int left = id;
		int right = (id + 1) % forks.length;
		
		while (forks[left] || forks[right]) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		forks[left] = true;
		forks[right] = true;
	}
	
	public synchronized void dropFork(int id) {
		int left = id;
		int right = (id + 1) % forks.length;

		forks[left] = false;
		forks[right] = false;
		
		notifyAll();
	}
}

