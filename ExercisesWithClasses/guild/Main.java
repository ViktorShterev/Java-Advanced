package ExercisesWithClasses.guild;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        //Initialize the repository (ExercisesWithClasses.guild)
//
        Guild guild = new Guild("Weekend Raiders", 20);
//
////Initialize entity
//
        Player player = new Player("Mark", "Rogue");
//
////Print player
//
        System.out.println(player);
//
////Player Mark: Rogue
//
////Rank: Trial
//
////Description: n/a
//
////Add player
//
        guild.addPlayer(player);

        System.out.println(guild.count()); //1
//
        System.out.println(guild.removePlayer("George")); //false

        Player firstPlayer = new Player("Pep", "Warrior");

        Player secondPlayer = new Player("Lizzy", "Priest");

        Player thirdPlayer = new Player("Mike", "Rogue");

        Player fourthPlayer = new Player("Marlin", "Mage");
//
////Add description to player
//
        secondPlayer.setDescription("Best healer EU");
//
////Add players
//
        guild.addPlayer(firstPlayer);

        guild.addPlayer(secondPlayer);

        guild.addPlayer(thirdPlayer);

        guild.addPlayer(fourthPlayer);
//
////Promote player
//
        guild.promotePlayer("Lizzy");
//
////Remove Player
//
        System.out.println(guild.removePlayer("Pep")); //true

        Player[] kickedPlayers = guild.kickPlayersByClass("Rogue");

        for (Player kickedPlayer : kickedPlayers) {

            System.out.print(kickedPlayer.getName() + " ");

            System.out.println(guild.report()); //Players in the ExercisesWithClasses.guild: Weekend Raiders: //Player Lizzy: Priest //Rank: Member //Description: Best healer EU //Player Marlin: Mage //Rank: Trial //Description: n/a
        }

    }
}
