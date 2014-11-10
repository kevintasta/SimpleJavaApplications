import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;
/**
 * The abstract House for the Game of Thrones Simulation.
 *
 * @author Yuanhan Pan
 * @version 1.0
 */
public abstract class House {

    protected String imageFilename;
    private ImageIcon image;
    protected int xPos = 0, yPos = 0, age = 0, health = 100;
    protected Rectangle bounds;
    private int imageWidth = 0, imageHeight = 0, reproductionCount = 2;

    /**
    * Constructs a House with location at given x and
    * y coordinates within a given Rectangle.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    protected House(int xPos, int yPos, Rectangle bounds) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bounds = bounds;
    }

    /**
     * Draws a House at its location.
     * @param  g  the Graphics for drawing
     *            the House
     */
    protected void draw(Graphics g) {
        image = new ImageIcon(imageFilename);
        image.paintIcon(null, g, xPos, yPos);
        imageWidth = image.getIconWidth();
        imageHeight = image.getIconHeight();
    }

    /**
    * Returns a copy of a specified House.
    * @return   a new House that is a copy of the specified House
    **/
    protected abstract House getCopy();

    /**
    * Moves a House a random distance in a random
    * direction within the bounds of its Rectangle. Increments
    * the House's age and decreases the House's health each time
    * the method is called.
    **/
    protected void move() {
        Random rand = new Random();
        xPos = xPos + (rand.nextInt(41) - 20);
        yPos = yPos + (rand.nextInt(41) - 20);
        age++;
        health = health - 2;
        if (xPos < 0) {
            xPos = 0;
        }
        if (yPos < 0) {
            yPos = 0;
        }
        if (xPos > (Westeros.WIDTH - imageWidth)) {
            xPos = (Westeros.WIDTH - imageWidth);
        }
        if (yPos > (Westeros.HEIGHT - imageHeight)) {
            yPos = (Westeros.HEIGHT - imageHeight);
        }
    }

    /**
    * Returns a Rectangle that represents the location
    * and dimensions of the image for a
    * specified House.
    * @return  a Rectangle at the House image location
    *          with dimensions equal to the House image
    *          dimensions
    **/
    private Rectangle getBounds() {
        return new Rectangle(xPos, yPos, imageWidth, imageHeight);
    }

    /**
    * Checks if a specified House is colliding with another House.
    * @param  otherHouse  a House used to check for collision
    * @return             if the two Houses collide
    **/
    protected boolean collidesWithHouse(House otherHouse) {
        if (otherHouse != null && otherHouse != this) {
            return (getBounds().intersects(otherHouse.getBounds()));
        }
        return false;
    }

    /**
    * Checks if a specified House can reproduce with another House.
    * @param  otherHouse  a House used to check for reproduction
    * @return             if the two Houses can reproduce
    **/
    protected abstract boolean canReproduceWithHouse(House otherHouse);

    /**
    * Creates an offspring House from a specified House and another
    * House.
    * @param  otherHouse  a House used to produce an offspring with
    *                     the specified House
    * @return             a copy of the specified House
    **/
    protected House reproduceWithHouse(House otherHouse) {
        Random rand = new Random();
        if (1 == rand.nextInt(51) && reproductionCount > 0 && age > 25) {
            reproductionCount--;
            return getCopy();
        }
        return null;
    }

    /**
    * Checks if a House's age is considered old.
    * @return  if the House's age is greater than a
    *          specified value
    **/
    protected abstract boolean isOld();

    /**
    * Checks if a specified House can harm another House.
    * @param  otherHouse  a House to be checked for harming
    *                     potential
    * @return             if the specified House can harm the
    *                     other House
    **/
    protected abstract boolean canHarmHouse(House otherHouse);

    /**
    * Reduces the health of another House.
    * @param  a House that will have its health reduced
    **/
    protected void harmHouse(House otherHouse) {
        otherHouse.health = otherHouse.health - 5;
    }


    /**
    * Reduces a House's health to 0.
    **/
    protected void die() {
        health = 0;
    }

    /**
    * Checks if a House is dead.
    * @return  if the House's health is less than
    *          or equal to 0
    **/
    protected boolean isDead() {
        return (health <= 0);
    }
}
