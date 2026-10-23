package player;


public class Player {

	private int id;
    private String name;
    private String team_name;
    private String category;
    private int score;
    private int catches;
    private int wickets;

    public Player(int id, String name, String team_name,
                  String category, int score,
                  int catches, int wickets) {

        this.id = id;
        this.name = name;
        this.team_name = team_name;
        this.category = category;
        this.score = score;
        this.catches = catches;
        this.wickets = wickets;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getCategory() {
        return category;
    }

    public int getScore() {
        return score;
    }

    public int getCatches() {
        return catches;
    }

    public int getWickets() {
        return wickets;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    @Override
    public String toString() {
        return "ID: " + id
            + ", Name: " + name
            + ", Team: " + team_name
            + ", Category: " + category
            + ", Score: " + score
            + ", Catches: " + catches
            + ", Wickets: " + wickets;
    }
}
