package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoatUI extends ABApp{
private Logger log = Logger.getLogger(BoatUI.class.getName());

	private JPanel northPanel;
	private JButton startBtn;
	private JButton stopBtn;
	private JButton pauseBtn;
	private JButton addBtn;
	private JButton deleteBtn;
	
	private JComboBox<String> comboBox;
	private BoatCanvas canvas;
	
	private Simulation mySim;
	private static final String rule1 = "Rule 1";
	private static final String rule2 = "Rule 2";
	private static final String rule3 = "Rule 3";


	public BoatUI() {
		log.info("MyBoatUI started");

	 	frame.setSize(660, 400);
		frame.setTitle("Assignment 5: Autonomous Boat Simulation");
		
		initSim(); // Initialize the simulation
		showUI(); // Cause the Swing Dispatch thread to display the JFrame
		// make the subscription
		mySim.addObserver(canvas); // Allow the panel to hear about simulation events
	}

	/*
	 * Initialize the simulation
	 */
	private void initSim() {
		mySim = new Simulation();
	}
	
	
	// Create a north panel with buttons
	public JPanel getNorthPanel() {
		northPanel = new JPanel(); // Create a  Boat canvas
		northPanel.setLayout(new FlowLayout()); // Flow controls
		
		startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("start pressed");
				mySim.startSim();
			}
		});
		
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("stop pressed");
				mySim.stopSim();
			}
		});
		
		pauseBtn = new JButton("Pause");
		pauseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("pause pressed");
				mySim.pauseSim();
			}
		});

		/* add boat **/
		addBtn = new JButton("add a Boat");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mySim.addBoat();
			}
		});

		/* delete boat **/
		deleteBtn = new JButton("delete a Boat");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mySim.deleteBoat();
			}
		});
		
		comboBox = new JComboBox();
		comboBox.addItem(rule1);
		comboBox.addItem(rule2);
		comboBox.addItem(rule3);

		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()){
					String selectedItem = e.getItem().toString();
					if(selectedItem.equals(rule1)) mySim.setRule(new RuleHorizontal());
					if(selectedItem.equals(rule2)) mySim.setRule(new RuleVertical());
					if(selectedItem.equals(rule3)) mySim.setRule(new RuleSnake());
				}
			}
		});

	    // Lay out the panel	
		northPanel.add(startBtn);
		northPanel.add(pauseBtn);
		northPanel.add(stopBtn);
		northPanel.add(addBtn);
		northPanel.add(deleteBtn);
		
		northPanel.add(new JLabel("Rule:"));
		northPanel.add(comboBox);
		
		return northPanel;
	}
	
	/**
	 * Create a center panel that has a drawable JPanel canvas
	 */
	@Override
	public JPanel getCenterPanel() {
		canvas = new BoatCanvas();     // Build the drawable panel
		return canvas;
	}
	
	
	public static void main(String[] args) {
	  new BoatUI();
      System.out.println("Everything is ready! ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


}
