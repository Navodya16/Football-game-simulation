import java.util.ArrayList;

public class Game {
    private Team team1;
    private Team team2; //a game has 2 teams
    private Ball[] balls;

    public Game(){}
    public Game(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Ball[] getBalls(){
        return balls;
    }

    public void setBalls(Ball[] balls){
        this.balls = balls;
    }

    public void playGame(int x){
        ArrayList <Ball> eventListBall = new ArrayList();
        Ball currBall;
        for (int i=0; i < x; i++){ //x is the time period of the game
            if (Math.random() > 0.95) { //goal has taken
                currBall = new Ball();
                currBall.setTheTeam(Math.random() > 0.5 ? team1:team2); //generate a random team
                currBall.setThePlayer(currBall.getTheTeam().getPlayerArray()[(int)(Math.random()*((currBall.getTheTeam().getPlayerArray().length)-1))]); //generate a random index
                currBall.setTheTime(i);
                currBall.setTheStatus(1); //1- goal has taken
                eventListBall.add(currBall);
            }
            else if (Math.random() > 0.85){ //goal is stopped
                currBall = new Ball();
                currBall.setTheTeam(Math.random() > 0.5 ? team1:team2);
                currBall.setThePlayer(currBall.getTheTeam().getPlayerArray()[10]);
                currBall.setTheTime(i);
                currBall.setTheStatus(2); //2-goal is stopped
                eventListBall.add(currBall);
            }
            else if (Math.random() > 0.75){ //ball is out of the field
                currBall = new Ball();
                currBall.setTheTeam(Math.random() > 0.5 ? team1:team2);
                currBall.setThePlayer(currBall.getTheTeam().getPlayerArray()[(int)(Math.random()*((currBall.getTheTeam().getPlayerArray().length)-1))]);
                currBall.setTheTime(i);
                currBall.setTheStatus(3); //3-ball out of the field
                eventListBall.add(currBall);
            }
            else { //ball passed successfully
                currBall = new Ball();
                currBall.setTheTeam(Math.random() > 0.5 ? team1:team2);
                currBall.setThePlayer(currBall.getTheTeam().getPlayerArray()[(int)(Math.random()*((currBall.getTheTeam().getPlayerArray().length)-1))]);
                currBall.setTheTime(i);
                currBall.setTheStatus(4); //4-ball passed successfully
                eventListBall.add(currBall);
            }
            this.balls = new Ball[eventListBall.size()];
            eventListBall.toArray(balls);
        }
    }

    public void penaltyShots(){ //penalty shots for each team if draw
        ArrayList <Ball> eventListBallPenalty = new ArrayList();
        Ball currBallPenalty;
        for(int i=0;i<5;i++){ //penalty shots for team 1
            if (Math.random() > 0.95) {
                currBallPenalty = new Ball();
                currBallPenalty.setTheTeam(team1);
                currBallPenalty.setThePlayer(currBallPenalty.getTheTeam().getPlayerArray()[(int)(Math.random()*currBallPenalty.getTheTeam().getPlayerArray().length)]);
                currBallPenalty.setTheTime(i);
                currBallPenalty.setTheStatus(1);
                eventListBallPenalty.add(currBallPenalty);
            }
            this.balls = new Ball[eventListBallPenalty.size()];
            eventListBallPenalty.toArray(balls);
        }
        for(int i=0;i<5;i++){ //penalty shots for team 2
            if (Math.random() > 0.95) {
                currBallPenalty = new Ball();
                currBallPenalty.setTheTeam(team2);
                currBallPenalty.setThePlayer(currBallPenalty.getTheTeam().getPlayerArray()[(int)(Math.random()*currBallPenalty.getTheTeam().getPlayerArray().length)]);
                currBallPenalty.setTheTime(i);
                currBallPenalty.setTheStatus(1);
                eventListBallPenalty.add(currBallPenalty);
            }
            this.balls = new Ball[eventListBallPenalty.size()];
            eventListBallPenalty.toArray(balls);
        }
    }

    public String statusOfMatches(){ //status of the matches(without penalty shots)
        int team1Goals = 0;
        int team2Goals = 0;
        StringBuilder returnString = new StringBuilder();

        returnString.append(this.team1.getTeamName() + " vs " + this.team2.getTeamName() + "\n");

        for (Ball currBall : this.getBalls()){
            returnString.append("Ball is on ");
            returnString.append(currBall.getTheTime());
            returnString.append(" min by ");
            returnString.append(currBall.getThePlayer().getPersonName());
            returnString.append(" of ");
            returnString.append(currBall.getTheTeam().getTeamName());
            returnString.append(" and status = ");
            int n= currBall.getTheStatus();
            if(n==1)
                returnString.append("a goal");
            else if (n==2)
                returnString.append("goal stopped");
            else if(n==3)
                returnString.append("ball out of the field");
            else if (n==4)
                returnString.append("ball passed successfully");
            returnString.append("\n");
        }

        for (Ball currBall : this.getBalls()){
            if (currBall.getTheStatus() == 1){
                if(currBall.getTheTeam()==team1)
                {
                    team1Goals++;
                    team1.incGoalsTotal(1);
                }
                else
                {
                    team2Goals++;
                    team2.incGoalsTotal(1);
                }
            }
        }
        if (team1Goals == team2Goals){
            returnString.append("It's a draw!");
        }
        else if (team1Goals > team2Goals){
            returnString.append(team1.getTeamName() + " win!");
        }
        else {
            returnString.append(team2.getTeamName() + " win!");
        }

        return returnString.toString();
    }

    public String statusOfPenaltyShots(){ //status of the penalty shots
        int team1Goals = 0;
        int team2Goals = 0;
        StringBuilder returnString = new StringBuilder();

        for (Ball currBall : this.getBalls()){
            int n= currBall.getTheStatus();
            if(n==1){
                returnString.append("a goal was taken successfully of ");
                returnString.append(currBall.getTheTeam().getTeamName());
            }
            else{
                returnString.append("\ngoal was stopped of ");
                returnString.append(currBall.getTheTeam().getTeamName());
            }
            returnString.append("\n");
        }

        for (Ball currBall : this.getBalls()){
            if (currBall.getTheStatus() == 1){
                if(currBall.getTheTeam()==team1)
                {
                    team1Goals++;
                    team1.incGoalsTotal(1);
                }
                else
                {
                    team2Goals++;
                    team2.incGoalsTotal(1);
                }
            }
        }
        if (team1Goals == team2Goals){
            returnString.append("It's a draw in penalty shots too!");
        }
        else if (team1Goals > team2Goals){
            returnString.append(team1.getTeamName() + " win!");
        }
        else {
            returnString.append(team2.getTeamName() + " win!");
        }

        return returnString.toString();
    }

}