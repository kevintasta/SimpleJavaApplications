import java.awt.Rectangle;
import java.util.Random;
/**
* The Lannister House for the Game of Thrones simulation.
* "Hear me roar!"
* @author Yuanhan Pan
* @version 1.0
**/
public class Lannister extends SouthHouse {

    /**
    * Constructs a Lannister with location at given x and
    * y coordinates within a given Rectangle. Sets the
    * Lannister House image to the lion.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public Lannister(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        setImageFilename("lion.jpeg");
    }

    /**
    * Returns a copy of a Lannister.
    * @return   a new Lannister that is a copy of the specified Lannister
    **/
    public House getCopy() {
        return new Lannister(xPos, yPos, bounds);
    }

    /**
    * Checks if a specified Lannister can reproduce with another House.
    * @param  otherHouse  a House used to check for reproduction
    * @return             if the Lannister can reproduce
    **/
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Lannister
            || otherHouse instanceof Baratheon);
    }

    /**
    * Checks if a Lannister's age is considered old.
    * @return  if the Lannister's age is greater than 50
    **/
    public boolean isOld() {
        return (age > 50);
    }

    /**
    * Checks if a specified Lannister can harm another House.
    * @param  otherHouse  a House to be checked for harming
    *                     potential
    * @return             if the specified Lannister can harm the
    *                     other House
    **/
    public boolean canHarmHouse(House otherHouse) {
        boolean a = false;
        Random rand = new Random();
        int i = rand.nextInt(5);
        boolean chanceStark = !(i == 0 || i == 1);
        boolean chanceTully = !(i == 0);
        if (otherHouse instanceof Stark && chanceStark) {
            a = true;
        }
        if (otherHouse instanceof Tully && chanceTully) {
            a = true;
        }
        return a;
    }

}