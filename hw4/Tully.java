import java.awt.Rectangle;
import java.util.Random;
/**
* The Tully House for the Game of Thrones simulation.
* "Family, Duty, Honor"
* @author Yuanhan Pan
* @version 1.0
**/
public class Tully extends NorthHouse {

    /**
    * Constructs a Tully with location at given x and
    * y coordinates within a given Rectangle. Sets the
    * Tully House image to the trout.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public Tully(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        setImageFilename("trout.jpeg");
    }

    /**
    * Returns a copy of a Tully.
    * @return   a new Tully that is a copy of the specified Tully
    **/
    public House getCopy() {
        return new Tully(xPos, yPos, bounds);
    }

    /**
    * Checks if a specified Tully can reproduce with another House.
    * @param  otherHouse  a House used to check for reproduction
    * @return             if the Tully can reproduce
    **/
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Stark);
    }

    /**
    * Checks if a Tully's age is considered old.
    * @return  if the Tully's age is greater than 80
    **/
    public boolean isOld() {
        return (age > 80);
    }

    /**
    * Checks if a specified Tully can harm another House.
    * @param  otherHouse  a House to be checked for harming
    *                     potential
    * @return             if the specified Tully can harm the
    *                     other House
    **/
    public boolean canHarmHouse(House otherHouse) {
        Random rand = new Random();
        int i = rand.nextInt(5);
        boolean chance = (i == 0);
        return (chance && otherHouse instanceof Lannister);
    }

}