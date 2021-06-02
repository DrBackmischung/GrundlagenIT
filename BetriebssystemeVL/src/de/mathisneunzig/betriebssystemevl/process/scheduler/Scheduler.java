package de.mathisneunzig.betriebssystemevl.process.scheduler;

import de.mathisneunzig.betriebssystemevl.process.Pcb;
import de.mathisneunzig.betriebssystemevl.process.ProcessQueue;

public abstract class Scheduler {

	public abstract Pcb schedule(ProcessQueue q);

}
