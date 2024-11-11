package me.djdisaster.matrix;

import me.djdisaster.Vector;

public class CubeMatrix implements Matrix {

    Vector[][] matrix = new Vector[][]{
            new Vector[]{new Vector(0.0D, 0.0D, 0.0F), new Vector(0.0D, 1.0D, 0.0F), new Vector(1.0D, 1.0D, 0.0F) },
            new Vector[]{new Vector(0.0D, 0.0D, 0.0F), new Vector(1.0D, 1.0D, 0.0F), new Vector(1.0D, 0.0D, 0.0F) },
            new Vector[]{new Vector(1.0D, 0.0D, 0.0F), new Vector(1.0D, 1.0D, 0.0F), new Vector(1.0D, 1.0D, 1.0F) },
            new Vector[]{new Vector(1.0D, 0.0D, 0.0F), new Vector(1.0D, 1.0D, 1.0F), new Vector(1.0D, 0.0D, 1.0F) },
            new Vector[]{new Vector(1.0D, 0.0D, 1.0F), new Vector(1.0D, 1.0D, 1.0F), new Vector(0.0D, 1.0D, 1.0F) },
            new Vector[]{new Vector(1.0D, 0.0D, 1.0F), new Vector(0.0D, 1.0D, 1.0F), new Vector(0.0D, 0.0D, 1.0F) },
            new Vector[]{new Vector(0.0D, 0.0D, 1.0F), new Vector(0.0D, 1.0D, 1.0F), new Vector(0.0D, 1.0D, 0.0F) },
            new Vector[]{new Vector(0.0D, 0.0D, 1.0F), new Vector(0.0D, 1.0D, 0.0F), new Vector(0.0D, 0.0D, 0.0F) },
            new Vector[]{new Vector(0.0D, 1.0D, 0.0F), new Vector(0.0D, 1.0D, 1.0F), new Vector(1.0D, 1.0D, 1.0F) },
            new Vector[]{new Vector(1.0D, 0.0D, 1.0F), new Vector(0.0D, 0.0D, 0.0F), new Vector(1.0D, 0.0D, 0.0F) },
            new Vector[]{new Vector(1.0D, 0.0D, 1.0F), new Vector(0.0D, 0.0D, 1.0F), new Vector(0.0D, 0.0D, 0.0F) },
            new Vector[]{new Vector(0.0D, 1.0D, 0.0F), new Vector(1.0D, 1.0D, 1.0F), new Vector(1.0D, 1.0D, 0.0F) },
    };;

    public CubeMatrix() {}
    public CubeMatrix(double xOffset, double yOffset, double zOffset, double scale) {
        for (Vector[] v : matrix) {
            for (Vector v2 : v) {
                v2.multiply(scale);
                v2.addX(xOffset);
                v2.addY(yOffset);
                v2.addZ(zOffset);
            }
        }
    }


    @Override
    public Vector[][] getMatrix() {
        return matrix;
    }
}
