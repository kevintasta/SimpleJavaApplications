import java.awt.Rectangle;
import java.util.Random;
/**
* The Atreides House for the Game of Thrones simulation.
* "The Spice, it is everything"
* @author Yuanhan Pan
* @version 1.0
**/
public class Atreides extends House {

    private int spiceCount = 10;
    /**
    * Constructs an Atreides with location at given x and
    * y coordinates within a given Rectangle. Sets the
    * Atreides House image to the sandworm.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public Atreides(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        imageFilename = "sandworm.jpg";
    }

    /**
    * Increases spiceCount by 5 as long as an Atreides is in the
    * lower half of Westeros. Calls spiceBonus and spiceAddiction
    * every move.
    * Overrides House move method.
    * {@inheritDoc}
    **/
    public void move() {
        super.move();
        if (yPos > (bounds.height / 2)) {
            spiceCount = spiceCount + 5;
            if (spiceCount > 50) {
                spiceCount = 50;
            }
        }
        spiceBonus();
        spiceAddiction();
    }

    /**
    * Returns a copy of an Atreides.
    * @return   a new Atreides that is a copy of the specified Atreides
    **/
    public House getCopy() {
        return new Atreides(xPos, yPos, bounds);
    }

    /**
    * Checks if a specified Atreides can reproduce with another House.
    * @param  otherHouse  a House used to check for reproduction
    * @return             if the Atreides can reproduce
    **/
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Atreides);
    }

    /**
    * Spice is ageless.
    * Checks if an Atreides' age is considered old.
    * @return  false always
    **/
    public boolean isOld() {
        return false;
    }

    /**
    * The greed for Spice is above family.
    * Checks if a specified Atreides can harm another House or
    * an Atreides if the the other Atreides has a spiceCount over
    * 60.
    * @param  otherHouse  a House to be checked for harming
    *                     potential
    * @return             if the specified Atreides can harm the
    *                     other House
    **/
    public boolean canHarmHouse(House otherHouse) {
        return (!(otherHouse instanceof Atreides)
            || ((Atreides) otherHouse).spiceCount > 30);
    }

    /**
    * Spice is life.
    * Replenishes a Atreides' health at the expense of
    * an Atreides' spiceCount.
    **/
    public void spiceBonus() {
        health = health + spiceCount;
        if (health > 100) {
            spiceCount = health % 100;
            health = 100;
        } else {
            spiceCount = 0;
        }
    }

    /**
    * Spice is destructive.
    * Reduces an Atreides' health by a random
    * value up to three times the Atreides'
    * current spiceCount if spiceCount is high enough.
    **/
    public void spiceAddiction() {
        if (spiceCount > 40) {
            Random rand = new Random();
            health = health - rand.nextInt(spiceCount * 3);
        }
    }

}