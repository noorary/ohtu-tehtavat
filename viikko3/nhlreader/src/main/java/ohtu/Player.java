
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private int goals;
    private int assists;
    private int penalties;
    private String team;
    private String nationality;
    private String birthdate;


    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + spaces(20, name.length()) + team + " " + goals + spaces(2, String.valueOf(goals).length()) + " + " + assists + spaces(2, String.valueOf(assists).length()) + " = " + (goals+assists);
    }

    private String spaces(int a, int b) {
        char[] spaces = new char[a - b];
        for (int i =0; i< spaces.length; i++) {
            spaces[i] = ' ';
        }
        return new String(spaces);
    }

    @Override
    public int compareTo(Player player) {
        if ((this.goals + this.assists) > (player.goals + player.assists)) {
            return -1;
        }
        if ((this.goals + this.assists) < (player.goals + player.assists)) {
            return 1;
        }

        return (this.goals + this.assists) - (player.goals + player.assists);
    }
      
}
