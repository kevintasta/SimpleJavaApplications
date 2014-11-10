/**
 * Represents a Pokemon object. Each has a number, a name, and two elemental
 * types, chosen from the PokemonType enumeration.
 *
 * @author  Joe Rossi, Yuanhan Pan
 * @version 1.1
 */
public class Pokemon implements Comparable<Pokemon> {

    private final int number;
    private final String name;
    private final PokemonType primary, secondary;

    /**
     * Constructs a Pokemon object
     *
     * @param num   this Pokemon's unique number
     * @param name  this Pokemon's name
     * @param p this Pokemon's primary type
     * @param s this Pokemon's secondary type
     */
    public Pokemon(int num, String name, PokemonType p, PokemonType s) {
        number = num;
        this.name = name;
        primary = p;
        secondary = s;
    }

    /**
    * Compares this Pokemon in ascending order by number.
    * @param  o  a Pokemon to be compared with this one
    * @return    a positive integer if this Pokemon's number is greater
    *            a negative integer if this Pokemon's number is less
    *            0 if the pokemon
    **/
    @Override
    public int compareTo(Pokemon o) {
        return number - o.getNumber();
    }

    /**
    * Determines if this Pokemon is equal to another Object.
    * @param  o  the Object to be compared to
    * @return    whether this Pokemon is equal to the other Object
    **/
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon other = (Pokemon) o;
        return (
            number == other.getNumber()
            && name.equals(other.getName())
            && primary == other.getPrimaryType()
            && secondary == other.getSecondaryType()
            );
    }

    /**
    * Creates a unqiue hashcode for an instance of Pokemon.
    * @return  a unique hashcode
    **/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + number;
        result = 31 * result + name.hashCode();
        result = 31 * result + primary.hashCode();
        result = 31 * result + secondary.hashCode();
        return result;
    }

    /**
    * Creates a String representaion of a Pokemon with a Pokemon's
    * name, numer, primary type, and secondary type.
    * @return  a String representation of the Pokemon
    **/
    @Override
    public String toString() {
        String col1 = "Primary Type: " + primary;
        String col2 = "Secondary Type: " + secondary;
        String format = "%8s %-15s %-25s %-20s";
        String s = "#" + String.format(format, number + ": ", name, col1, col2);
        return s;
    }

    /**
     * @return  the name of this Pokemon
     */
    public String getName() {
        return name;
    }

    /**
     * @return  the unique number of this Pokemon
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return  the primary type of this Pokemon
     */
    public PokemonType getPrimaryType() {
        return primary;
    }

    /**
     * @return  the secondary type of this Pokemon
     */
    public PokemonType getSecondaryType() {
        return secondary;
    }
}
