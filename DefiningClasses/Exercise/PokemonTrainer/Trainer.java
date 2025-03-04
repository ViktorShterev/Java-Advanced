package DefiningClasses.Exercise.PokemonTrainer;

public class Trainer {
    private String name;
    private int badges;
    private int collection;

    public Trainer(String name, int badges, int collection) {
        this.name = name;
        this.badges = badges;
        this.collection = collection;
    }

    public void setCollection(int collection) {
        this.collection += collection;
    }

    public void setBadges(int badges) {
        this.badges += badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.collection);
    }
}
