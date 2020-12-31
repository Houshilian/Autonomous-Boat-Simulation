package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

public enum DirectionEnum {
    NORTH('N', 1),
    SOUTH('S', 2),
    WEST('W', 3),
    EAST('E', 4),
    ;

    private Character direction;
    private Integer code;

    DirectionEnum(Character direction, Integer code){
        this.direction = direction;
        this.code = code;
    }

    public Character getDirection() {
        return direction;
    }

    public Integer getCode() {
        return code;
    }
}
