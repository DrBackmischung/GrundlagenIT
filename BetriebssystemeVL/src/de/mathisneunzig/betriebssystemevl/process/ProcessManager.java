package de.mathisneunzig.betriebssystemevl.process;

import de.mathisneunzig.betriebssystemevl.process.scheduler.Scheduler;

@SuppressWarnings("unused")
public class ProcessManager {
	
	private Pcb[] 		 processes;
	private Pcb 		 runningProcess;
	private ProcessQueue readyQueue;
	private ProcessQueue inactiveQueue;
	private Scheduler 	 s;
	
	public ProcessManager ( int processCount ) {
		processes = new Pcb[processCount];
		// Erzeugung eines geeigneten Scheduler-Objekts
		// Erzeugung der benoetigten Prozesswarteschlangen
		// Erzeugung der Prozesskontrollbloecke
	} 
	private void initiate ( Context c ) {
		Pcb process = inactiveQueue.get();
		process.initPcb ( c );
		process.state = Pcb.READY;
		readyQueue.put( process );
	}
	
	private void terminate () {
		runningProcess.state = Pcb.INACTIVE;
		inactiveQueue.put ( runningProcess );
	}
	
	private void block ( ProcessQueue q ) {
		runningProcess.state = Pcb.BLOCKED;
		q.put ( runningProcess );
	}
	
	private void deblock ( ProcessQueue q ) {
		Pcb process = q.get();
		process.state = Pcb.READY;
		readyQueue.put ( process );
	} 
	
	private void resign () {
		runningProcess.state = Pcb.READY;
		readyQueue.put ( runningProcess );
	} 
	
	private void assign () {
		Pcb process = s.schedule (readyQueue);
		process.state = Pcb.RUNNING;
		runningProcess.storeRegister();
		runningProcess = process;
		runningProcess.loadRegister();
	}
	
}
