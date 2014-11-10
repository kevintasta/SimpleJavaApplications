import java.awt.Rectangle;
/**
* The abstract SouthHouse for the Game of Thrones simulation.
*
* @author Yuanhan Pan
* @version 1.0
**/
public abstract class SouthHouse extends House {

    /**
    * Constructs a SouthHouse with location at given x and
    * y coordinates within a given Rectangle.
    * @param  xPos    the horizonal coordinate for the
    *                 House image
    * @param  yPos    the vertical coordinate for the
    *                 House image
    * @param  bounds  the Rectangle that contains
    *                 the House
    **/
    public SouthHouse(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
    }

    /**
    * Gives a SouthHouse a southern bonus per move.
    * Overrides House move method.
    * {@inheritDoc}
    **/
    protected void move() {
        super.move();
        southernBonus();
    }

    /**
    * Increases a SouthHouse's movement rate as long as it
    * remains in the lower half of Westeros. SouthHouses make
    * more moves without losing extra health or gaining age.
    **/
    protected void southernBonus() {
        if (yPos > (bounds.height / 2)) {
            super.move();
            super.move();
            age = age - 2;
            health = health + 4;
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