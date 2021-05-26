package de.mathisneunzig.betriebssystemevl.process;

public class Scheduler {

	public Pcb schedule(ProcessQueue q) {
		return q.get();
	}

}
