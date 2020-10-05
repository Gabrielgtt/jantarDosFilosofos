package jantarDosFilosofos;

public class Dinner {
	private Table tb;
	private Philosopher phis[];
	
	public Dinner() {
		this.tb = new Table();
		this.phis = new Philosopher[5];
		for (int i = 0; i < phis.length; i++) {
			phis[i] = new Philosopher(i, tb);
		}
	}
	
	public void begin() {
		for (Philosopher p : phis) {
			p.start();
		}
	}
	
	public static void main(String[] args) {
		Dinner di = new Dinner();
		di.begin();
	}
}
