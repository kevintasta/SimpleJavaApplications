import java.awt.Rectangle;
/**
* The Baratheon House for the Game of Thrones simulation.
* "Ours is the fury"
* @author Yuanhan Pan
* @version 1.0
**/
public class Baratheon extends SouthHouse {

    /**
    * Constructs a Baratheon with location at given x and
    * y coordinates within a given Rectangle. Sets the
    * Baratheon House image to the stag.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public Baratheon(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        setImageFilename("stag.jpeg");
    }

    /**
    * Returns a copy of a Baratheon.
    * @return   a new Baratheon that is a copy of the specified Baratheon
    **/
    public House getCopy() {
        return new Baratheon(xPos, yPos, bounds);
    }

    /**
    * Checks if a specified Baratheon can reproduce with another House.
    * @param  otherHouse  a House used to check for reproduction
    * @return             if the Baratheon can reproduce
    **/
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Lannister);
    }

    /**
    * Checks if a Baratheon's age is considered old.
    * @return  if the Baratheon's age is greater than 60
    **/
    public boolean isOld() {
        return (age > 60);
    }

    /**
    * Checks if a specified Baratheon can harm another House.
    * @param  otherHouse  a House to be checked for harming
    *                     potential
    * @return             if the specified Baratheon can harm the
    *                     other House
    **/
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Targaryan);
    }

}