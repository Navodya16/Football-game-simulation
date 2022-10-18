public class Team {
    private String teamName;
    private Person[] playerArray;
    private Person doctor;
    private Person couch;
    private int goalsTotal;

    public Team (){}
    public Team (String teamName){
        this.teamName = teamName;
    }
    public Team (String teamName, Person[] playerArray, Person doctor, Person couch) {
        this(teamName );
        this.playerArray = playerArray;
        this.couch = couch;
        this.doctor = doctor;
    }

    public void incGoalsTotal(int goals){
        this.setGoalsTotal(this.getGoalsTotal() + goals);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Person[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Person[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getGoalsTotal() {
        return goalsTotal;
    }

    public void setGoalsTotal(int goalsTotal) {
        this.goalsTotal = goalsTotal;
    }

    public Person getCouch(){
        return couch;
    }

    public void setCouch(Person couch){
        this.couch = couch;
    }

    public Person getDoctor(){
        return doctor;
    }

    public void setDoctor(Person doctor){
        this.doctor = doctor;
    }
}
