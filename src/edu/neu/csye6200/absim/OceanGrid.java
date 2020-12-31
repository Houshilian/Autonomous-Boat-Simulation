package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

public class OceanGrid {
	
	//0 ocean, 1 Oil
	private int[][] ocean;
	private static final Integer WATER = 0;  //0 is the water in the ocean
	private static final Integer OIL = 1;    //1 is the oil in the ocean
	private Integer amountOfOil;

	public OceanGrid(int size) {
		ocean = new int [size] [size];
		this.amountOfOil = 0;
	}
	public OceanGrid(){
	}
	
	public Integer getOceanSize() {
		return ocean.length;
	}

	public Integer getOceanType(Integer x, Integer y) {
		return ocean[x][y];
	}

	public void setWater(Integer x, Integer y) {
		if(ocean[x][y] == OIL) this.amountOfOil -= 1;
		ocean[x][y] = WATER;
	}

	public void setOil(Integer x, Integer y) {
		if(ocean[x][y] != OIL){
			ocean[x][y] = OIL;
			this.amountOfOil += 1;
		}
	}
	
	//represent the percentage of the total amount of the oil in the ocean
	public String getState() {  
		double state = ((double)amountOfOil / (double)(ocean.length * ocean.length)) * 100;
		return String.format("%.2f", state) + "%";   //keep two decimal places
	}

	public Integer getAmountOfOil() {
		return amountOfOil;
	}
	
	//as the window is resized, the size of ocean changes accordingly
	public void reConstructOcean(Integer n) {  
		int[][] temp = new int[n][n];

		for(int i = 0; i < ocean.length; i++){
			for(int j = 0; j < ocean.length; j++){
				temp[i][j] = ocean[i][j];
			}
		}
		ocean = temp;
	}

	public int[][] getOcean() {
		return this.ocean;
	}
}
