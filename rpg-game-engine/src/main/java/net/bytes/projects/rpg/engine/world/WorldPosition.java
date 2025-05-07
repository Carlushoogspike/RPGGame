package net.bytes.projects.rpg.engine.world;

import javax.xml.stream.Location;
import java.util.Locale;

public class WorldPosition implements Cloneable{

    private double x;
    private double y;

    public WorldPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public synchronized WorldPosition rewrite(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }


    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public WorldPosition addCopy(double x, double y) {
        return new WorldPosition(this.x + x, this.y + y);
    }

    public void subtract(double x, double y){
        this.x -= x;
        this.y -= y;
    }

    public WorldPosition subtractCopy(double x, double y) {
        return new WorldPosition(this.x - x, this.y - y);
    }

    @Override
    public WorldPosition clone() {
        try {
            return (WorldPosition) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
