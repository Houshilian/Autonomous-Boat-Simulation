package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

//Move the Boat Up to Down, vertically.
public class RuleVertical extends ABRule {
    @Override
    public void Move(Boat boat, OceanGrid ocean) {
        Integer speed = boat.getSpeed();
        while(speed > 0){
            // determine whether the boat goes to North or South
            if (boat.getVerticalDirection().equals(DirectionEnum.SOUTH.getDirection())){
                if(boat.getX() + 1 < ocean.getOceanSize()) boat.Move(boat.getX()+1, boat.getY());
                else{
                    //if the boats is already at the end of ocean, we need to move East or move West
                    if(boat.getHorizontalDirection().equals(DirectionEnum.EAST.getDirection())){
                        if(boat.getY() + 1 < ocean.getOceanSize()) {
                            boat.Move(boat.getX(), boat.getY()+1);
                        } else {
                            boat.Move(boat.getX(), boat.getY()-1);
                            boat.setHorizontalDirection(DirectionEnum.WEST.getDirection());
                        }

                    }else{
                        if(boat.getY() - 1 >= 0)
                            boat.Move(boat.getX(), boat.getY()-1);
                        else{
                            boat.Move(boat.getX(), boat.getY()+1);
                            boat.setHorizontalDirection(DirectionEnum.EAST.getDirection());
                        }
                    }
                    // change the direction to North
                    boat.setVerticalDirection(DirectionEnum.NORTH.getDirection());
                }
            }else{
                //if the Vertical direction is North
                //if the boat can go to North(X >= 0)
                if(boat.getX() - 1 >= 0) boat.Move(boat.getX()-1, boat.getY());

                //else we go East or go West
                else {
                    //if the Horizontal direction is East
                    if (boat.getHorizontalDirection().equals(DirectionEnum.EAST.getDirection())) {
                        if (boat.getY() + 1 < ocean.getOceanSize()) boat.Move(boat.getX(), boat.getY()+1);
                        else {
                            boat.Move(boat.getX(), boat.getY()-1);
                            boat.setHorizontalDirection(DirectionEnum.WEST.getDirection());
                        }
                    } else {
                        if (boat.getY() - 1 >= 0) boat.Move(boat.getX(), boat.getY()-1);
                        else {
                            boat.Move(boat.getX(), boat.getY()+1);
                            boat.setHorizontalDirection(DirectionEnum.EAST.getDirection());
                        }
                    }
                    boat.setVerticalDirection(DirectionEnum.SOUTH.getDirection());
                }
            }
            speed--;
            ocean.setWater(boat.getX(), boat.getY());
        }

    }
}
