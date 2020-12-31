package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class BoatCanvas extends JPanel implements Observer {
	private Simulation mySimulation;

	public BoatCanvas()  {
	}

	// Swing calls when a redraw is needed
	public void paint(Graphics g) {
		drawCanvas(g);
	}

	// Draw the contents of the panel
	private void drawCanvas(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);

		drawOceanGrid(g2d);
	}

	private void drawOceanGrid(Graphics2D g2d) {
		if(mySimulation == null) return;
		OceanGrid ocean = mySimulation.getOcean();
		List<Boat> boats = mySimulation.getBoats();
		Dimension size = getSize();

		int n = ocean.getOceanSize();
		int lineSize = size.height / n;

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if(ocean.getOceanType(j, i) == 0) g2d.setColor(Color.CYAN);         //set the color of the water in the ocean to cyan
				else if(ocean.getOceanType(j, i) == 1) g2d.setColor(Color.YELLOW);  //set the color of the oil in the ocean to yellow

				boolean boatExist = false;
				for(Boat boat : boats){
					if(j == boat.getX() && i == boat.getY()){
						boatExist = true;
						break;
					}
				}
				if(boatExist) g2d.setColor(Color.RED);  //set the color of the boat in the ocean to red

				g2d.fillRect(j * lineSize + size.width/4, i * lineSize, lineSize-1, lineSize-1);
			}
		}
	}

	public void update(Observable o, Object arg) {

		if (arg instanceof Simulation) {
			mySimulation = (Simulation) arg;
		}
		repaint(); // Tell the GUI thread that it should schedule a paint() call
	}



}
