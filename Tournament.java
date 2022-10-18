public class Tournament {
    public static void main(String[] args) {

        Tournament theTournament = new Tournament(); //create new tournament
        Team[] theTeams = theTournament.createTeams(); //create the teams
        Game[] theGames = theTournament.createGames(theTeams); //create the teams according to the coin toss

        //first and second half
        for (Game currGame : theGames){ //loop through every game and play it, print the status
            currGame.playGame(45);
            System.out.println(currGame.statusOfMatches());
            System.out.println("\nBreak : 15 mins\n");
        }

        //extra time
        if(theTeams[0].getGoalsTotal()==theTeams[1].getGoalsTotal()){
            System.out.println("this is a draw in first half and second half. therefore extra 15 min play for both teams\n");
            for (Game currGame : theGames){
                currGame.playGame(15);
                System.out.println(currGame.statusOfMatches());
                System.out.println("\nBreak : 15 mins\n");
            }
        }

        //penalty shots
        if(theTeams[0].getGoalsTotal()==theTeams[1].getGoalsTotal()){
            System.out.println("all matches drawed. therefore 5 penalty shots will be given for both teams\n");
            theGames[0].penaltyShots();
            System.out.println(theGames[0].statusOfPenaltyShots());
        }

        //System.out.println(theTeams[0].getGoalsTotal());
        //System.out.println(theTeams[1].getGoalsTotal());

        theTournament.showBestTeam(theTeams);
    }

    public Team[] createTeams (){
        //team1
        Person player1 = new Person("A1");
        Person player2 = new Person("A2");
        Person player3 = new Person("A3");
        Person player4 = new Person("A4");
        Person player5 = new Person("A5");
        Person player6 = new Person("A6");
        Person player7 = new Person("A7");
        Person player8 = new Person("A8");
        Person player9 = new Person("A9");
        Person player10 = new Person("A10");
        Person player11 = new Person("AGoalKeeper");

        Person[] thePlayers1 = {player1, player2, player3, player4, player5, player6, player7, player8, player9, player10, player11};
        Person doctor1 = new Person("ADoctor");
        Person couch1 = new Person("ACouch");
        Team team1 = new Team("TeamA", thePlayers1, doctor1, couch1);

        //team2
        Person player12 = new Person("B1");
        Person player13 = new Person("B2");
        Person player14 = new Person("B3");
        Person player15 = new Person("B4");
        Person player16 = new Person("B5");
        Person player17 = new Person("B6");
        Person player18 = new Person("B7");
        Person player19= new Person("B8");
        Person player20 = new Person("B9");
        Person player21= new Person("B10");
        Person player22= new Person("BGoalKeeper");

        Person[] thePlayers2 = {player12, player13, player14, player15, player16, player17, player18, player19, player20, player21, player22};
        Person doctor2 = new Person("BDoctor");
        Person couch2 = new Person("BCouch");
        Team team2 = new Team("TeamB", thePlayers2, doctor2, couch2);

        Team [] theTeams = {team1, team2};
        return theTeams;
    }

    public Game[] createGames (Team[] theTeams){
        Game theGame;
        Game theGame2;
        if(Math.random()>0.5){ //simulate the coin tossing
            theGame = new Game(theTeams[0], theTeams[1]);
            theGame2 = new Game(theTeams[1], theTeams[0]);
        }
        else{
            theGame = new Game(theTeams[1], theTeams[0]);
            theGame2 = new Game(theTeams[0], theTeams[1]);
        }
        Game[] theGames = {theGame, theGame2};
        return theGames;
    }

    public void showBestTeam(Team[] theTeams){
        System.out.println("\nTeam Points and final scoreboard");
        System.out.println("final total goals of the 2 teams : \n");
        System.out.println(theTeams[0].getTeamName() + ":" + theTeams[0].getGoalsTotal());
        System.out.println(theTeams[1].getTeamName() + ":" + theTeams[1].getGoalsTotal());
        if(theTeams[0].getGoalsTotal()>theTeams[1].getGoalsTotal())
            System.out.println("\nThe winner of the tournament is " + theTeams[0].getTeamName());
        else if(theTeams[1].getGoalsTotal()>theTeams[0].getGoalsTotal())
            System.out.println("\nThe winner of the tournament is " + theTeams[1].getTeamName());
        else
            System.out.println("\noverall match is a draw");

    }

}
