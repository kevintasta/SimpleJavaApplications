import java.awt.Rectangle;
import java.util.Random;
/**
* The Stark House for the Game of Thrones simulation.
* "Winter is Coming"
* @author Yuanhan Pan
* @version 1.0
**/
public class Stark extends NorthHouse {

    /**
    * Constructs a Stark with location at given x and
    * y coordinates within a given Rectangle. Sets the
    * Stark House image to the direwolf.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public Stark(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        setImageFilename("direwolf.jpeg");
    }

    /**
    * Returns a copy of a Stark.
    * @return   a new Stark that is a copy of the specified Stark
    **/
    public House getCopy() {
        return new Stark(xPos, yPos, bounds);
    }

    /**
    * Checks if a specified Stark can reproduce with another House.
    * @param  otherHouse  a House used to check for reproduction
    * @return             if the Stark can reproduce
    **/
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Tully);
    }

    /**
    * Checks if a Stark's age is considered old.
    * @return  if the Stark's age is greater than 70
    **/
    public boolean isOld() {
        return (age > 70);
    }

    /**
    * Checks if a specified Stark can harm another House.
    * @param  otherHouse  a House to be checked for harming
    *                     potential
    * @return             if the specified Stark can harm the
    *                     other House
    **/
    public boolean canHarmHouse(House otherHouse) {
        Random rand = new Random();
        int i = rand.nextInt(5);
        boolean chance = (i == 0 || i == 1);
        return (chance && otherHouse instanceof Lannister);
    }

}