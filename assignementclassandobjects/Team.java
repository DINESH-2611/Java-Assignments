package assignementclassandobjects;

public class Team {
    private String name;
    private String city;
    private String division;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
    public void playGame(){
        System.out.println("Team is playing");
    }
    public void hireCoach(){
        System.out.println("Team is hiring the coach");
    }
}

