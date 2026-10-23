package player;

import java.util.Scanner;

public class T20WCMain {

	public static void main(String[] args) {

		PlayerService p=new PlayerService();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n===== T20WC PLAYER MANAGEMENT =====");
			System.out.println("1. Print All Players");
			System.out.println("2. Print Batsmen");
			System.out.println("3. Print Bowlers");
			System.out.println("4. Search Player By ID");
			System.out.println("5. Search Players By Team");
			System.out.println("6. Player With Highest Score");
			System.out.println("7. Player With Highest Wickets");
			System.out.println("8. Update Player Score");
			System.out.println("9. Update Player Wickets");
			System.out.println("10. Delete Player By ID");
			System.out.println("11. Print All-Rounder");
			System.out.println("12. Update Player Name");
			System.out.println("13. Print WicketKeeper");
			System.out.println("14. insert new Player");
			System.out.println("15. Sort Player by Score");
			System.out.println("16. count total player");
			System.out.println("17. player With Most Catches ");
			System.out.println("18. sort Players By Name");
			System.out.println("19. count Players By Category ");
			System.out.println("20. search Player By Name");
			System.out.println("21. get Top Five Players");
			System.out.println("22. Exit");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			try {
				switch (choice) {

				case 1:
					p.printPlayers(PlayerService.getAllPlayers());
					break;

				case 2:
					p.getBatsmen();
					break;

				case 3:
					p.getBowlers();
					break;

				case 4:
					System.out.print("Enter Player ID: ");
					int id1 = sc.nextInt();
					p.getPlayerById(id1);
					break;

				case 5:
					System.out.print("Enter Team Name: ");
					String team = sc.next();
					p.getPlayersByTeam(team);
					break;

				case 6:
					p.getHighestScore();
					break;

				case 7:
					p.getHighestWickets();
					break;

				case 8:
					System.out.print("Enter Player ID: ");
					int id2 = sc.nextInt();

					System.out.print("Enter New Score: ");
					int score = sc.nextInt();

					p.updateScore(id2, score);
					break;

				case 9:
					System.out.print("Enter Player ID: ");
					int id3 = sc.nextInt();

					System.out.print("Enter New Wickets: ");
					int wickets = sc.nextInt();

					p.updateWickets(id3, wickets);
					break;

				case 10:
					System.out.print("Enter Player ID to Delete: ");
					int id4 = sc.nextInt();

					p.deletePlayer(id4);
					break;

				case 11:
					p.getAllrounder();
					break;
					
				case 12:
					
					System.out.println("Enter id: ");
					int id=sc.nextInt();
					
					System.out.println("Enter New Name: ");
					String name=sc.next();
					
					p.updateName(id, name);
					break;
					
				case 13:
					
					p.getwicketKeeper();
					break;
					
				case 14:
					p.insertdata();
					break;
					
				case 15:
					p.sortPlayerbyscore();
					break;
			
					
				case 16:
					p.countTotalPlayers();
					break;
					
				case 17:
					p.getMostcatches();
					break;
					
				case 18:
					p.sortPlayersByName();
					break;
					
				case 19:
					p.countPlayersByCategory("Batsman");
					break;
					
				case 20:
					
					System.out.print("Enter name: ");
					String name1=sc.next();
					
					p.searchPlayerByName(name1);
					break;
					
				case 21:
					p.getTopFivePlayers();
					
				case 22:
					System.out.println("Thank you for using T20WC!");
					break;

				default:
					System.out.println("Invalid choice!");
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (choice != 11);

		sc.close();
	}
}
