package ExercisesWithClasses.guild;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }
    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            this.roster.put(player.getName(), player);
        }
    }
    public int count() {
        return this.roster.size();
    }
    public boolean removePlayer(String name) {
        return this.roster.remove(name) != null;
    }
    public void promotePlayer(String name) {
        Player player = this.roster.get(name);
        player.setRank("Member");
    }
    public void demotePlayer(String name) {
        Player player = this.roster.get(name);
        player.setRank("Trial");
    }
    public Player[] kickPlayersByClass(String clazz) {
        List<String> names = new ArrayList<>();

        for (Map.Entry<String, Player> entry : roster.entrySet()) {
            Player player = entry.getValue();
            if (player.getClazz().equals(clazz)) {
                names.add(entry.getKey());
            }
        }
        Player[] removedPlayers = new Player[names.size()];

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            Player player = this.roster.remove(name);
            removedPlayers[i] = player;
        }
        return removedPlayers;
    }
    public String report() {
        StringBuilder out = new StringBuilder(
                String.format("Players in the ExercisesWithClasses.guild: %s%n", name));

        for (Player p : roster.values()) {
            out.append(p)
                    .append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
