package player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerService {

	public static List<Player> getAllPlayers() throws Exception {

		List<Player> list = new ArrayList<>();

		String sql = "SELECT * FROM Player";

		try (Connection con = PlayerConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				list.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getString("team_name"),
						rs.getString("category"), rs.getInt("score"), rs.getInt("catches"), rs.getInt("wickets")));
			}
		}

		return list;
	}

	public void printPlayers(List<Player> list) {

		if (list.isEmpty()) {
			System.out.println("No players found.");
			return;
		}

		for (Player p : list) {
			System.out.println(p);
		}
	}

	public void getBatsmen() throws Exception {

		List<Player> list = getAllPlayers();

		List<Player> result = new ArrayList<>();

		for (Player p : list) {
			if (p.getCategory().equalsIgnoreCase("Batsman")) {
				result.add(p);
			}
		}

		printPlayers(result);
	}

	public void getBowlers() throws Exception {

		List<Player> list = getAllPlayers();

		List<Player> result = new ArrayList<>();

		for (Player p : list) {
			if (p.getCategory().equalsIgnoreCase("Bowler")) {
				result.add(p);
			}
		}

		printPlayers(result);
	}

	public void getPlayerById(int id) throws Exception {

		String sql = "SELECT * FROM Player WHERE id=?";

		try (Connection con = PlayerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					Player p = new Player(rs.getInt("id"), rs.getString("name"), rs.getString("team_name"),
							rs.getString("category"), rs.getInt("score"), rs.getInt("catches"), rs.getInt("wickets"));

					System.out.println(p);
				} else {
					System.out.println("Player ID not found.");
				}
			}
		}
	}

	public void getPlayersByTeam(String team) throws Exception {

		String sql = "SELECT * FROM Player WHERE team_name=?";

		List<Player> list = new ArrayList<>();

		try (Connection con = PlayerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, team);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					list.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getString("team_name"),
							rs.getString("category"), rs.getInt("score"), rs.getInt("catches"), rs.getInt("wickets")));
				}
			}
		}

		printPlayers(list);
	}

	public void getHighestScore() throws Exception {

		List<Player> list = getAllPlayers();

		if (list.isEmpty()) {
			System.out.println("No players found.");
			return;
		}

		int max = list.get(0).getScore();

		for (Player p : list) {
			if (p.getScore() > max) {
				max = p.getScore();
			}
		}

		for (Player p : list) {
			if (p.getScore() == max) {
				System.out.println(p);
			}
		}
	}

	public void getHighestWickets() throws Exception {

		List<Player> list = getAllPlayers();

		if (list.isEmpty()) {
			System.out.println("No players found.");
			return;
		}

		int max = list.get(0).getWickets();

		for (Player p : list) {
			if (p.getWickets() > max) {
				max = p.getWickets();
			}
		}

		for (Player p : list) {
			if (p.getWickets() == max) {
				System.out.println(p);
			}
		}
	}

	public void updateScore(int id, int score) throws Exception {

		String sql = "UPDATE Player SET score=? WHERE id=?";

		try (Connection con = PlayerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, score);
			ps.setInt(2, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Player score updated.");
			} else {
				System.out.println("Player ID not found.");
			}
		}
	}

	public void updateWickets(int id, int wickets) throws Exception {

		String sql = "UPDATE Player SET wickets=? WHERE id=?";

		try (Connection con = PlayerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, wickets);
			ps.setInt(2, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Player wickets updated.");
			} else {
				System.out.println("Player ID not found.");
			}
		}
	}

	public void deletePlayer(int id) throws Exception {

		String sql = "DELETE FROM Player WHERE id=?";

		try (Connection con = PlayerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Player deleted successfully.");
			} else {
				System.out.println("Player ID not found.");
			}
		}
	}

	public void getAllrounder() throws Exception {

		List<Player> list = getAllPlayers();
		List<Player> result = new ArrayList<>();

		for (Player p : list) {
			if (p.getCategory().equalsIgnoreCase("All-Rounder")) {
				result.add(p);
			}
		}
		printPlayers(result);

	}

	public void updateName(int id, String name) throws Exception {

		String query = "update Player set name=? where id=?";

		try (Connection con = PlayerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, name);
			ps.setInt(2, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Player Name  updated Sucessul..");
			} else {
				System.out.println("Player Id not found..");
			}

		}
	}

	public void getwicketKeeper() throws Exception {

		List<Player> list = getAllPlayers();
		List<Player> result = new ArrayList<Player>();

		for (Player p : list) {
			if (p.getCategory().equalsIgnoreCase("Wicketkeeper")) {
				result.add(p);
			}
		}
		printPlayers(result);
	}

	public void insertdata() throws Exception {
		Scanner sc = new Scanner(System.in);
		String query = "insert into Player values(?,?,?,?,?,?,?)";

		System.out.println("Enter id: ");
		int id = sc.nextInt();

		System.out.println("Enter Name: ");
		String name = sc.next();

		System.out.println("Enter Team: ");
		String team = sc.next();

		System.out.println("Enter Category: ");
		String category = sc.next();

		System.out.println("Enter Score: ");
		int score = sc.nextInt();

		System.out.println("Enter Catches: ");
		int catches = sc.nextInt();

		System.out.println("Enter Wickets: ");
		int wickets = sc.nextInt();

		try (Connection con = PlayerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, team);
			ps.setString(4, category);
			ps.setInt(5, score);
			ps.setInt(6, catches);
			ps.setInt(7, wickets);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println(" Player Inserted..");
			} else {
				System.out.println("palyer not found..");
			}

		}
	}

	public void sortPlayerbyscore() throws Exception {

		List<Player> list = getAllPlayers();

		list.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));

		printPlayers(list);
	}

	public void countTotalPlayers() throws Exception {

		String query = "select count(*) from Player";

		try (Connection con = PlayerConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			if (rs.next()) {
				System.out.println("Total players:" + rs.getInt(1));
			}

		}
	}

	public void getMostcatches() throws Exception {

		List<Player> list = getAllPlayers();

		if (list.isEmpty()) {
			System.out.println("NO player Found..");
			return;
		}

		int max = list.get(0).getCatches();

		for (Player p : list) {
			if (p.getCatches() > max) {
				max = p.getCatches();
			}
		}

		for (Player p : list) {
			if (p.getCatches() == max) {
				System.out.println(p);
			}
		}
	}

	public void sortPlayersByName() throws Exception {

		List<Player> list = getAllPlayers();

		list.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

		printPlayers(list);
	}

	public void countPlayersByCategory(String Category) throws Exception {

		List<Player> list = getAllPlayers();
		int count = 0;

		for (Player p : list) {
			if (p.getCategory().equalsIgnoreCase(Category)) {
				count++;
			}
		}
		System.out.println(Category + " count: " + count);
	}

	public void searchPlayerByName(String name) throws Exception {

		List<Player> list = getAllPlayers();
		List<Player> result = new ArrayList<>();

		for (Player p : list) {
			if (p.getName().equalsIgnoreCase(name)) {
				result.add(p);
			}
		}

		printPlayers(result);
	}

	public void getTopFivePlayers() throws Exception {

		List<Player> list = getAllPlayers();

		list.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));

		int limit = Math.min(5, list.size());

		for (int i = 0; i < limit; i++) {
			System.out.println(list.get(i));
		}
	}

}
