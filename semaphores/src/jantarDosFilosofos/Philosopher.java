package jantarDosFilosofos;

public class Philosopher extends Thread {
	private int id;
	private Table tb;
	
	public Philosopher(int id, Table tb) {
		super("" + id);
		this.id = id;
		this.tb = tb;
	}
	
	private void think() {
		System.out.println("Philosopher " + this.id + " is thinking");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void eat() {
		this.tb.eat(this.id);
	}
	
	public void run() {
		while (true) {
			this.think();
			this.eat();
		}
	}
}
