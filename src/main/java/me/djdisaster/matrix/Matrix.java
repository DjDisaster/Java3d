package me.djdisaster.matrix;

import me.djdisaster.Vector;

public interface Matrix {

    Vector[][] getMatrix();

    static double[][] defaultMatrix() {
        return new double[][]{
                new double[]{0D,0D,0D,0D},
                new double[]{0D,0D,0D,0D},
                new double[]{0D,0D,0D,0D},
                new double[]{0D,0D,0D,0D}
        };
    }

    static Vector multiplyMatrix(Vector v1, double[][] matrix) {
        Vector returnVector = new Vector(0,0,0);
        double x = v1.getX();
        double y = v1.getY();
        double z = v1.getZ();
        returnVector.setX(((x * matrix[0][0]) + (y * matrix[1][0]) + (z * matrix[2][0]) + (matrix[3][0])));
        returnVector.setY(((x * matrix[0][1]) + (y * matrix[1][1]) + (z * matrix[2][1]) + (matrix[3][1])));
        returnVector.setZ(((x * matrix[0][2]) + (y * matrix[1][2]) + (z * matrix[2][2]) + (matrix[3][2])));
        double w = ((x * matrix[0][3]) + (y * matrix[1][3]) + (z * matrix[2][3]) + (matrix[3][3]));

        if (w != 0) {
            returnVector.setX(returnVector.getX() / w);
            returnVector.setY(returnVector.getY() / w);
            returnVector.setZ(returnVector.getZ() / w);
        }

        return returnVector;
    }

}
