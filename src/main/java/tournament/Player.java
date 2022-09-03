package tournament;

public class Player implements Comparable<Player> {
    public int id;
    public String name;
    public int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int compareTo(Player o) {
        if (this.strength < o.strength) {
            return 2;
        } else if (this.strength > o.strength) {
            return 1;
        } else {
            return 0;
        }
    }
}
