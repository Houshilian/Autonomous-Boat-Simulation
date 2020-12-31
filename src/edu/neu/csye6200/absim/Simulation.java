package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Simulation extends Observable implements Runnable  {

	private Thread thread = null; // the thread that runs my simulation
	private boolean paused = false;
	private boolean done = false; // set true to end the simulation loop
	private boolean running = false; // set true if the simulation is running
	private long simDelay = 1000L; // time adjustment to slow down the simulation loop

	// initialize the ocean, boats, oil and the rule of cleaning
	private OceanGrid ocean;
	private List<Boat> boats;
	private Oil oil;
	private ABRule rule;

	public Simulation() {
		// initialize the ocean, boat, oil and the rule of cleaning
		ocean = new OceanGrid(8);
		boats = new ArrayList<>();
		oil = new Oil(ocean);
		rule = new RuleHorizontal();
	}

	/**
	 * Start the simulation thread - create a Thread if needed
	 */
	public void startSim() {
		System.out.println("Starting the simulation");
		if (thread != null) return; // A thread is already running
		
		thread = new Thread(this); // Create a worker thread
		running = true;
		paused = false;
		done = false;     // reset the done flag.
		thread.start();
	}
	
	/**
	 * Pause the Simulation thread execution
	 */
	public void pauseSim() {
		paused = !paused;
		System.out.println("Pause the simulation: " + paused);
	}
	
	/**
	 * Are we currently in a paused state
	 * @return true if paused
	 */
	public boolean isPaused() {
		return paused;
	}
	
	public boolean isPausable() {
		if (!running) return false;
		if (done) return false;
		return true;
	}
	
	/**
	 * Is this simulation currently running?
	 * @return true if the simulation is active
	 */
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * Force an early stop of the simulation by setting done = true
	 */
	public void stopSim() {	
		System.out.println("Stop the simulation");
		if (thread == null) return; // defensive coding in case the thread is null
		done = true;
	}

	/**
	 * The main run method for this simulation.
	 */
	public void run() {
		runSimLoop();
		thread = null; // flag that the simulation thread is finished
	}
	
	/**
	 * A simulation loop that continuously runs
	 */
    private void runSimLoop() {
    	running = true;

    	while(!done) {
    		if (!paused){
				//let the boat start cleaning and oil start spanning
    			
				//boats move
				for(Boat boat : boats) 
					rule.Move(boat, ocean);

				updateSim(ocean, boats, oil);

				//oil moves
				oil.Move(ocean);
				updateSim(ocean, boats, oil);
			}
    		sleep(simDelay); // A half second sleep is the default
    	}
    	running = false;
    }
    
    /**
     * Allow for external control of the periodic simulation thread delay
     * @param simDelay the time in millis to delay on each cycle (i.e. 500L = 0.5 seconds0
     */
	public void setSimDelay(long simDelay) {
		this.simDelay = simDelay;
	}

	/**
	 * Make the current thread sleep a little
	 * @param millis the time to sleep before the thread may re-awaken
	 */
    private void sleep(long millis) {
    	try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Perform an update on your simulation
     */
    private void updateSim(OceanGrid ocean, List<Boat> boats, Oil oil) {

    	//print out the oil, boat position and the ocean state
		if(ocean != null && boats != null && oil != null) {
			System.out.println("The oil is gradually spreading to position: " + oil.getX() + "," + oil.getY());
			for(int i = 0; i < boats.size(); i++){
				Boat boat = boats.get(i);
				int number = i+1;
				System.out.println("The boat " + number + " is at the position " + boat.getX() + "," + boat.getY());
			}
			System.out.println("The ocean has " + ocean.getState() + " oil. ");
		}

    	setChanged();
    	notifyObservers(this); // Send a copy of the simulation
    }

	/**
	 * add boat
	 */
	public void addBoat(){
    	boats.add(new Boat(0,0));
    	updateSim(ocean, boats, oil);
	}

	/**
	 * delete boat
	 */
	public void deleteBoat(){
		boats.remove(boats.size()-1);
		updateSim(ocean, boats, oil);
	}

	public OceanGrid getOcean() {
		return ocean;
	}

	public void setOcean(OceanGrid ocean) {
		this.ocean = ocean;
	}

	public List<Boat> getBoats() {
    	return this.boats;
	}


	public Oil getOil() {
		return oil;
	}

	public void setOil(Oil oil) {
		this.oil = oil;
	}

	public ABRule getRule() {
		return rule;
	}

	public void setRule(ABRule rule) {
		this.rule = rule;
		updateSim(this.ocean, this.boats, this.oil);
	}

}
