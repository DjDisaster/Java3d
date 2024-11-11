package me.djdisaster.matrix;

import me.djdisaster.Vector;

public class HexPrismMatrix implements Matrix {

    Vector[][] matrix = new Vector[20][3];

    public HexPrismMatrix() {
        this(0.0D, 0.0D, 0.0D, 1.0D);
    }

    public HexPrismMatrix(double xOffset, double yOffset, double zOffset, double scale) {
        double radius = 0.5 * scale;
        double height = scale;

        // Initialize the vertices
        Vector[] V_b = new Vector[6]; // Bottom vertices
        Vector[] V_t = new Vector[6]; // Top vertices
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            double x = radius * Math.cos(angle) + xOffset;
            double y = radius * Math.sin(angle) + yOffset;
            V_b[i] = new Vector(x, y, zOffset);
            V_t[i] = new Vector(x, y, zOffset + height);
        }

        // Initialize the triangles
        int idx = 0;

        // Side faces
        for (int i = 0; i < 6; i++) {
            int next = (i + 1) % 6;

            // First triangle of the side face (consistent winding)
            matrix[idx++] = new Vector[]{
                    V_b[i],
                    V_t[i],
                    V_t[next]
            };

            // Second triangle of the side face (consistent winding)
            matrix[idx++] = new Vector[]{
                    V_b[i],
                    V_t[next],
                    V_b[next]
            };
        }

        // Bottom face (consistent winding order)
        for (int i = 1; i < 5; i++) {
            matrix[idx++] = new Vector[]{
                    V_b[0],
                    V_b[i],
                    V_b[i + 1]
            };
        }

        // Top face (consistent winding order)
        for (int i = 1; i < 5; i++) {
            matrix[idx++] = new Vector[]{
                    V_t[0],
                    V_t[i + 1],
                    V_t[i]
            };
        }
    }

    @Override
    public Vector[][] getMatrix() {
        return matrix;
    }
}

