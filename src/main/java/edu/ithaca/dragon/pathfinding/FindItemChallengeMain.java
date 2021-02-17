package edu.ithaca.dragon.pathfinding;

import java.util.Scanner;

import edu.ithaca.dragon.pathfinding.challenge.FindItemChallenge;
import edu.ithaca.dragon.pathfinding.pathfinder.RandomPathFinder;

public class FindItemChallengeMain {
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        FindItemChallenge challenge = new FindItemChallenge(new RandomPathFinder());
        while(!challenge.challengeCompleted()){
            challenge.challengeStep();
            System.out.println(challenge.getSteps());
            System.out.println(challenge.createDisplayString());
            System.out.print("Enter to continue:");
            keyboard.nextLine();
        }
        keyboard.close();
    }
}
