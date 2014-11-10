import java.awt.Rectangle;
/**
* The abstract NorthHouse for the Game of Thrones simulation.
*
* @author Yuanhan Pan
* @version 1.0
**/
public abstract class NorthHouse extends House {

    /**
    * Constructs a NorthHouse with location at given x and
    * y coordinates within a given Rectangle.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public NorthHouse(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
    }

    /**
    * Gives a NorthHouse a northern bonus per move.
    * Overrides House move method.
    * {@inheritDoc}
    **/
    protected void move() {
        super.move();
        northernBonus();
    }

    /**
    * Increases a NorthHouse's health as long as it
    * remains in the upper half of Westeros.
    **/
    protected void northernBonus() {
        if (yPos < (bounds.height / 2)) {
            health = health + 1;
        }
    }

    /**
    * Sets the ImageFilename of House to a String.
    * @param  name  new imageFilename to be set
    **/
    protected void setImageFilename(String name) {
        imageFilename = name;
    }
}