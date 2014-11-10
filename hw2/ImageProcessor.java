public class ImageProcessor {
    private Pic image;

    public static void main(String[] args) {
        Pic input = new Pic(args[0]);
        ImageProcessor processor = new ImageProcessor(input);
        processor.greyscale().show();
        processor.invert().show();
        processor.noRed().show();
        processor.blackAndWhite().show();
        processor.maximize().show();
        //Will execute overlay method if there is a second picture
        if (args.length > 1) {
            Pic overlayImage = new Pic(args[1]);
            processor.overlay(overlayImage).show();
        }
    }
    //This constructor takes in a Pic object to be processed
    public ImageProcessor(Pic a) {
        image = a;
    }

    //This method sets the image to greyscale by setting all pixels
    //to an average of the RGB values
    public Pic greyscale() {
        Pic output = image.deepCopy();
        Pixel[][] outputPixels = output.getPixels();
        for (int row = 0; row < output.getHeight(); row++) {
            for (int col = 0; col < output.getWidth(); col++) {
                Pixel current = outputPixels[row][col];
                //Gets average of red, green, and blue values
                int average = (current.getRed() + current.getGreen()
                    + current.getBlue()) / 3;
                current.setRed(average);
                current.setGreen(average);
                current.setBlue(average);
            }
        }
        return output;
    }

    //Inverts pic by setting the pixels to the difference between it and 255
    public Pic invert() {
        Pic output = image.deepCopy();
        Pixel[][] outputPixels = output.getPixels();
        for (int row = 0; row < output.getHeight(); row++) {
            for (int col = 0; col < output.getWidth(); col++) {
                Pixel current = outputPixels[row][col];
                current.setRed(255 - current.getRed());
                current.setGreen(255 - current.getGreen());
                current.setBlue(255 - current.getBlue());
            }
        }
        return output;
    }

    //Sets red value of all pixels to 0
    public Pic noRed() {
        Pic output = image.deepCopy();
        Pixel[][] outputPixels = output.getPixels();
        for (int row = 0; row < output.getHeight(); row++) {
            for (int col = 0; col < output.getWidth(); col++) {
                Pixel current = outputPixels[row][col];
                current.setRed(0);
            }
        }
        return output;
    }

    //Sets Pic to black and white by setting pixels to either 255 or 0
    public Pic blackAndWhite() {
        Pic output = image.deepCopy();
        Pixel[][] outputPixels = output.getPixels();
        for (int row = 0; row < output.getHeight(); row++) {
            for (int col = 0; col < output.getWidth(); col++) {
                Pixel current = outputPixels[row][col];
                int average = (current.getRed() + current.getGreen()
                    + current.getBlue()) / 3;
                if (average > 127) {
                    current.setRed(255);
                    current.setGreen(255);
                    current.setBlue(255);
                } else {
                    current.setRed(0);
                    current.setGreen(0);
                    current.setBlue(0);
                }
            }
        }
        return output;
    }

    //Maximizes pixel value in image
    public Pic maximize() {
        Pic output = image.deepCopy();
        Pixel[][] outputPixels = output.getPixels();
        for (int row = 0; row < output.getHeight(); row++) {
            for (int col = 0; col < output.getWidth(); col++) {
                Pixel current = outputPixels[row][col];
                //Finds the max value between the three values of
                //red, green, and blue
                int max = Math.max(current.getRed(), Math.max(
                    current.getGreen(), current.getBlue()));
                //Sets color value to 0 if value is not max value
                if (current.getRed() != max) {
                    current.setRed(0);
                }
                if (current.getGreen() != max) {
                    current.setGreen(0);
                }
                if (current.getBlue() != max) {
                    current.setBlue(0);
                }
            }
        }
        return output;
    }

    //This method overlays the original picture with a given picture
    public Pic overlay(Pic other) {
        Pic output = image.deepCopy();
        Pixel[][] outputPixels = output.getPixels();
        Pixel[][] overlayPixels = other.getPixels();
        for (int row = 0; row < output.getHeight(); row++) {
            for (int col = 0; col < output.getWidth(); col++) {
                Pixel current = outputPixels[row][col];
                //Sets color to average values only if there is enough
                //area in the original image
                if (row < other.getHeight()
                    && col < other.getWidth()) {
                    Pixel overlayCurrent = overlayPixels[row][col];
                    int redAverage = (current.getRed()
                        + overlayCurrent.getRed()) / 2;
                    int greenAverage = (current.getGreen()
                        + overlayCurrent.getGreen()) / 2;
                    int blueAverage = (current.getBlue()
                        + overlayCurrent.getBlue()) / 2;
                    current.setRed(redAverage);
                    current.setGreen(greenAverage);
                    current.setBlue(blueAverage);
                }
            }
        }
        return output;
    }
}