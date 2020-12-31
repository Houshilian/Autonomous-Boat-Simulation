package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

public class Oil {
    private Integer x;
    private Integer y;

    /**
     * randomly generate the oil
     * @param ocean
     */
    public Oil(OceanGrid ocean){
        this.x = GenerateRandomNumber.RandomPosition(ocean.getOceanSize());
        this.y = GenerateRandomNumber.RandomPosition(ocean.getOceanSize());
        ocean.setOil(this.x, this.y);
    }

    /**
     *
     * Oil can only spans in one direction
     * @param ocean
     */
    public void Move(OceanGrid ocean){
        Integer direction = GenerateRandomNumber.RandomDirection();

        if(direction.equals(DirectionEnum.NORTH.getCode())) {
            if(this.x - 1 >= 0){
                ocean.setOil(this.x - 1, this.y);
                this.x -= 1;
            }
        }
        else if(direction.equals(DirectionEnum.SOUTH.getCode())) {
            if(this.x + 1 < ocean.getOceanSize()){
                ocean.setOil(this.x + 1, this.y);
                this.x += 1;
            }
        }
        else if(direction.equals(DirectionEnum.WEST.getCode())) {
            if(this.y - 1 >= 0){
                ocean.setOil(this.x, this.y-1);
                this.y -= 1;
            }
        }
        else if(direction.equals(DirectionEnum.EAST.getCode())) {
            if(this.y + 1 < ocean.getOceanSize()){
                ocean.setOil(this.x, this.y+1);
                this.y += 1;
            }
        }
    }

    public Integer getX() { 
    	return x; 
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
