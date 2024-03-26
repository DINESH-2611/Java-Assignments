package assignementclassandobjects;

public class Player {
    private String name;
    private String position;
    private String jercyNo;
    private Team team;

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJercyNo(String jercyNo) {
        this.jercyNo = jercyNo;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void playGame(){
        System.out.println("Player is playing");

    }
    public void train(){
        System.out.println("Player is training");
    }
}
