package de.mathisneunzig.betriebssystemevl.process;

public class Pcb {

	public static final int INACTIVE = 1;
	public static final int READY 	 = 2;
	public static final int RUNNING  = 3;
	public static final int BLOCKED  = 4;
	public int state;
	
	public int pid;
	
	public Pcb(int id) {
		this.pid = id;
	}
	
	public Pcb next;

	public void initPcb(Context c) {
		
	}

	public void storeRegister() {
		
	}

	public void loadRegister() {
		
	}

}
