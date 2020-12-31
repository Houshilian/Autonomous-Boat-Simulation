package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

//move the boat like a snake
public class RuleSnake extends ABRule {
    @Override
    public void Move(Boat boat, OceanGrid ocean) {
        RuleHorizontal ruleHorizontal = new RuleHorizontal();
        RuleVertical ruleVertical = new RuleVertical();
        Integer random = GenerateRandomNumber.RandomHoriOrVerti();
        if(random == 0){
            ruleHorizontal.Move(boat, ocean);
        }
        else{
            ruleVertical.Move(boat, ocean);
        }

    }
}
