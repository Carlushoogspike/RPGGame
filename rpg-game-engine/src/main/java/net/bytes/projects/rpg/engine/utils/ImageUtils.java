package net.bytes.projects.rpg.engine.utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ImageUtils {

    public static BufferedImage rotateImageDegrees(BufferedImage image, double degrees) {
        double radians = Math.toRadians(degrees);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));

        int newWeight = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
        int newHeight = (int) Math.round(image.getHeight() * sin + image.getWidth() * cos);

        BufferedImage newImage = new BufferedImage(newWeight, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D paintImage = newImage.createGraphics();

        int x = (newWeight - image.getWidth()) / 2;
        int y = (newHeight - image.getHeight()) / 2;

        AffineTransform transform = new AffineTransform();
        transform.setToRotation(radians, x + ((double) image.getWidth() / 2), y + ((double) image.getHeight() / 2));
        transform.translate(x, y);

        paintImage.setTransform(transform);
        paintImage.drawImage(image, 0, 0, null);
        paintImage.dispose();
        return newImage;
    }

    public static BufferedImage flipImageHorizontal(BufferedImage image, ImageRotate rotate) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = flippedImage.createGraphics();

        AffineTransform transform;

        if (rotate == ImageRotate.FLIP_HORIZONTAL_LEFT) {
            transform = AffineTransform.getScaleInstance(-1, 1);
            transform.translate(-width, 0);

            g2d.setTransform(transform);
            g2d.drawImage(image, 0, 0, null);
        } else if (rotate == ImageRotate.FLIP_HORIZONTAL_RIGHT) {
            transform = AffineTransform.getScaleInstance(1, 1);
            transform.translate(0, 0);

            g2d.setTransform(transform);
            g2d.drawImage(image, 0, 0, null);
        }

        g2d.dispose();
        return flippedImage;
    }



    public static BufferedImage rotateImage(BufferedImage image, ImageRotate rotate) {
        return rotateImageDegrees(image, rotate.getDegrees());
    }

    public enum ImageRotate {

        FLIP_HORIZONTAL_LEFT(-90.0d),
        FLIP_HORIZONTAL_RIGHT(90.0d),
        FLIP_VERTICAL_UP(-180.0d),
        FLIP_VERTICAL_DOWN(180.0d);

        private final double degrees;

        ImageRotate(double degrees) {
            this.degrees = degrees;
        }

        public double getDegrees() {
            return degrees;
        }

    }

}
