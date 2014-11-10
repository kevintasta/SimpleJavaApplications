/**
 * Represents a Pokedex - basically a Pokemon encyclopedia that adds new entries
 * when you encounter a Pokemon for the first time.
 * It also provides methods for organizing its information in useful ways.
 *
 * @author Joe Rossi, Yuanhan Pan
 * @version 1.1
 */
public class Pokedex {

    private final MySortedSet<Pokemon> pokedex;

    /**
     * Constructs a Pokedex object by setting up the sorted set of Pokemon
     */
    public Pokedex() {
        pokedex = new MySortedSet<Pokemon>();
    }

    /**
    * Produces a string representation of this Pokedex
    * @return  a string reprsention of this Pokedex
    **/
    @Override
    public String toString() {
        return "Pokedex Entries: \n" + pokedex.toString();
    }

    /**
     * Adds a Pokemon to the sorted set
     *
     * @param p the Pokemon to be added
     * @return true if the pokemon was not already in the set, false otherwise
     */
    public boolean add(Pokemon p) {
        return pokedex.add(p);
    }

    /**
     * Returns the number of Pokemon in the Pokedex
     *
     * @return  the number of Pokemon in the Pokedex
     */
    public int countPokemon() {
        return pokedex.size();
    }

    /**
     * Clear the Pokedex and start over
     */
    public void clear() {
        pokedex.clear();
    }

    /**
     * Returns a set of alphabetized Pokemon, using a lambda expression
     *
     * @return  the alphabetized set
     */
    public MySortedSet<Pokemon> listAlphabetically() {
        return pokedex.sort(
            (a, b) -> a.getName().compareTo(b.getName())
            );
    }

    /**
     * Returns a set of Pokemon grouped by type, using a lambda expression
     *
     * @return  the grouped by primary type set
     */
    public MySortedSet<Pokemon> groupByPrimaryType() {
        return pokedex.sort(
            (a, b) -> a.getPrimaryType().compareTo(b.getPrimaryType())
            );
    }

    /**
     * Returns a set of all Pokemon of type t
     *
     * @param t the type we want listed
     * @return  the set of all Pokemon in the Pokedex of type t
     */
    public MySortedSet<Pokemon> listByType(PokemonType t) {
        return pokedex.filter(
            test -> test.getPrimaryType() == t || test.getSecondaryType()
            == t
            );
    }

    /**
     * Returns a set of Pokemon with numbers in the range [start, end]
     *
     * @param start the first number in the new set
     * @param end   the last number in the new set
     * @return  the set containing all Pokemon in the Pokedex from [start, end]
     */
    public MySortedSet<Pokemon> listRange(int start, int end) {
        return pokedex.filter(
            test -> (start <= test.getNumber() && test.getNumber() <= end)
            );
    }
}
