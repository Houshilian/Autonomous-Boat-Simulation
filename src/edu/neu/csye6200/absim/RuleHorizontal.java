package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

//Move the boat from left to right horizontally
public class RuleHorizontal extends ABRule {
    @Override
    public void Move(Boat boat, OceanGrid ocean) {
        Integer speed = boat.getSpeed();
        while(speed > 0){

            // determine whether the boat goes to East or West
            if(boat.getHorizontalDirection().equals(DirectionEnum.EAST.getDirection())){
                if(boat.getY() + 1 < ocean.getOceanSize()) boat.Move(boat.getX(), boat.getY()+1);
                else{
                    //if the boats is already at the end of ocean, we need to move south or move north
                    if(boat.getVerticalDirection().equals(DirectionEnum.SOUTH.getDirection())){
                        if(boat.getX() + 1 < ocean.getOceanSize()) {
                            boat.Move(boat.getX() + 1, boat.getY());
                        } else {
                            boat.Move(boat.getX() - 1, boat.getY());
                            boat.setVerticalDirection(DirectionEnum.NORTH.getDirection());
                        }

                    }else{
                        if(boat.getX() - 1 >= 0)
                            boat.Move(boat.getX() - 1, boat.getY());
                        else{
                            boat.Move(boat.getX() + 1, boat.getY());
                            boat.setVerticalDirection(DirectionEnum.SOUTH.getDirection());
                        }
                    }
                    // change the direction to west
                    boat.setHorizontalDirection(DirectionEnum.WEST.getDirection());
                }
            } else{
                //if the horizontal direction is West

                //if the boat can go to west(Y >= 0)
                if(boat.getY() - 1 >= 0) boat.Move(boat.getX(), boat.getY() - 1);

                //else we go down or go up
                else{
                    //if the vertical direction is South
                    if(boat.getVerticalDirection().equals(DirectionEnum.SOUTH.getDirection())){
                        if(boat.getX() + 1 < ocean.getOceanSize()) boat.Move(boat.getX() + 1, boat.getY());
                        else{
                            boat.Move(boat.getX() - 1, boat.getY());
                            boat.setVerticalDirection(DirectionEnum.NORTH.getDirection());
                        }
                    } else{
                        if(boat.getX() - 1 >= 0) boat.Move(boat.getX() - 1, boat.getY());
                        else{
                            boat.Move(boat.getX() + 1, boat.getY());
                            boat.setVerticalDirection(DirectionEnum.SOUTH.getDirection());
                        }
                    }

                    boat.setHorizontalDirection(DirectionEnum.EAST.getDirection());
                }
            }
            speed--;
            ocean.setWater(boat.getX(), boat.getY());
        }
    }
}
