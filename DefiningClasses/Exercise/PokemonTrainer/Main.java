package DefiningClasses.Exercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        Map<String, List<Pokemon>> pokemons = new LinkedHashMap<>();

        String text = scanner.nextLine();
        while (!text.equals("Tournament")) {

            String[] tokens = text.split("\\s+");
            String nameTrainer = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(nameTrainer, 0, 0);
            trainers.putIfAbsent(nameTrainer, trainer);
            trainers.get(nameTrainer).setCollection(1);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            pokemons.putIfAbsent(nameTrainer, new ArrayList<>());
            pokemons.get(nameTrainer).add(pokemon);

            text = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {

            for (Map.Entry<String, List<Pokemon>> entry : pokemons.entrySet()) {
                String name = entry.getKey();
                List<Pokemon> collection = entry.getValue();

                boolean isHaving = false;

                for (Pokemon pokemon : collection) {
                    if (pokemon.getElement().equals(input)) {
                        trainers.get(name).setBadges(1);
                        isHaving = true;
                        break;
                    }
                }
                if (isHaving) {
                    for (Pokemon pokemon : collection) {
                        pokemon.setHealth(10);
                        if (pokemon.getHealth() <= 0) {
                            collection.remove(pokemon);
                            trainers.get(name).setCollection(-1);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
