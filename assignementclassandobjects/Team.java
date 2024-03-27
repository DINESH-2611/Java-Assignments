package assignementclassandobjects;

import java.util.List;

public class Team {
    public String name;
    public String city;
    public String division;
    List<Player> playerList;
    public void playGame(){
        System.out.println("Team is playing");
    }
    public void hireCoach(){
        System.out.println("Team is hiring the coach");
    }
}

