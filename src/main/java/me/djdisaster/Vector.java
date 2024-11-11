package me.djdisaster;

public class Vector {

    private double x, y, z;
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double newValue) {
        this.x = newValue;
    }

    public void setY(double newValue) {
        this.y = newValue;
    }

    public void setZ(double newValue) {
        this.z = newValue;
    }

    public void multiply(double amount) {
        this.x *= amount;
        this.y *= amount;
        this.z *= amount;
    }

    public void add(double amount) {
        this.x += amount;
        this.y += amount;
        this.z += amount;
    }

    public void addX(double amount) {
        x += amount;
    }

    public void addY(double amount) {
        y += amount;
    }

    public void addZ(double amount) {
        z += amount;
    }

    public Vector copy() {
        return new Vector(x,y,z);
    }

    public void divide(double amount) {
        this.x /= amount;
        this.y /= amount;
        this.z /= amount;
    }



}
