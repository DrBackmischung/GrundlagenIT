package de.mathisneunzig.betriebssystemevl.process;

public class ProcessQueue {
	
	public Pcb head;
	
	public ProcessQueue() {
		head = null;
	}
	
	public void put(Pcb n) {
		if(head == null) {
			head = n;
		} else {
			Pcb p = head;
			while(p.next != null) {
				p = p.next;
			}
			p.next = n;
		}
	}
	
	public Pcb get() {
		Pcb p = head;
		if(p != null) {
			head = p.next;
			p.next = null;
		}
		return p;
	}

}
