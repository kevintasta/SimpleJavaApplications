import java.awt.Rectangle;
/**
* The Targaryan House for the Game of Thrones simulation.
* "Fire and blood"
* @author Yuanhan Pan
* @version 1.0
**/
public class Targaryan extends House {

    /**
    * Constructs a Targaryan with location at given x and
    * y coordinates within a given Rectangle. Sets the
    * Targaryan House image to the dragon.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public Targaryan(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        imageFilename = "dragon.jpeg";
    }

    /**
    * Returns a copy of a Targaryan.
    * @return   a new Stark that is a copy of the specified Targaryan
    **/
    public House getCopy() {
        return new Targaryan(xPos, yPos, bounds);
    }

    /**
    * Checks if a specified Targaryan can reproduce with another House.
    * @param  otherHouse  a House used to check for reproduction
    * @return             if the Targaryan can reproduce
    **/
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Targaryan);
    }

    /**
    * Checks if a Targaryan's age is considered old.
    * @return  false always
    **/
    public boolean isOld() {
        return false;
    }

    public boolean canHarmHouse(House otherHouse) {
        return (!(otherHouse instanceof Baratheon
            || otherHouse instanceof Targaryan));
    }

}