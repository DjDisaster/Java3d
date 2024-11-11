package me.djdisaster;

import me.djdisaster.matrix.Matrix;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private Matrix[] matrices;
    private double updateNumber = 0;
    public DrawPanel(Matrix[] matrices) {
        this.matrices = matrices;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateNumber += 0.02;

        double nearPlane = 0.1;
        double farPlane = 1000.0;
        double fov = 90;
        double aspectRatio = 1;//1920D / 1000D;
        double fovRad = 1.0 / Math.tan(fov * (0.5 / 180 * Math.PI));

        double[][] projectionMatrix = Matrix.defaultMatrix();
        projectionMatrix[0][0] = aspectRatio * fovRad;
        projectionMatrix[1][1] = fovRad;
        projectionMatrix[2][2] = farPlane / (farPlane - nearPlane);
        projectionMatrix[3][2] = (-farPlane * nearPlane) / (farPlane - nearPlane);
        projectionMatrix[2][3] = 1.0;
        projectionMatrix[3][3] = 0.0;

        double theta = updateNumber;

        double[][] rotation1 = Matrix.defaultMatrix();
        rotation1[0][0] = Math.cos(theta);
        rotation1[0][1] = -1 * Math.sin(theta);
        rotation1[1][0] = Math.sin(theta);
        rotation1[1][1] = Math.cos(theta);
        rotation1[2][2] = 1;
        rotation1[3][3] = 1;

        double[][] rotation2 = Matrix.defaultMatrix();
        rotation2[0][0] = 1;
        rotation2[1][1] = Math.cos(theta);
        rotation2[1][2] = -1*Math.sin(theta);
        rotation2[2][1] = Math.sin(theta);
        rotation2[2][2] = Math.cos(theta);
        rotation2[3][3] = 1;

        Vector cameraPosition = new Vector(0, 0, 0);

        for (Matrix v : matrices) {
            Vector[][] matrix = v.getMatrix();

            for (Vector[] v2 : matrix) {
                Vector[] tri = new Vector[]{v2[0].copy(), v2[1].copy(), v2[2].copy()};

                for (int i = 0; i < tri.length; i++) {
                    tri[i] = Matrix.multiplyMatrix(tri[i], rotation1);
                    tri[i] = Matrix.multiplyMatrix(tri[i], rotation2);
                    Vector v3 = tri[i];
                    v3.setZ(v3.getZ() + 3);

                }

                Vector line1 = new Vector((tri[1].getX() - tri[0].getX()), (tri[1].getY() - tri[0].getY()), (tri[1].getZ() - tri[0].getZ()));
                Vector line2 = new Vector((tri[2].getX() - tri[0].getX()), (tri[2].getY() - tri[0].getY()), (tri[2].getZ() - tri[0].getZ()));

                double normalX = ((line1.getY()) * (line2.getZ())) - ((line1.getZ()) * (line2.getY()));
                double normalZ = ((line1.getX()) * (line2.getY())) - ((line1.getY()) * (line2.getX()));
                double normalY = ((line1.getZ()) * (line2.getX())) - ((line1.getX()) * (line2.getZ()));

                double l = Math.sqrt(Math.pow(normalX, 2) + Math.pow(normalY, 2) + Math.pow(normalZ, 2));

                normalX = normalX / l;
                normalY = normalY / l;
                normalZ = normalZ / l;

                var dot = ((normalX * (tri[1].getX() - (cameraPosition.getX())) + (normalY * (tri[1].getY() - (cameraPosition.getY()))) + (normalZ * (tri[1].getZ() - (cameraPosition.getZ())))));

                if (dot > 0 && Main.culling) {
                    continue;
                }

                Vector[] points = new Vector[3];
                for (int i = 0; i < tri.length; i++) {
                    Vector v3 = tri[i];
                    points[i] = Matrix.multiplyMatrix(v3, projectionMatrix);
                    points[i].multiply(1000);
                    points[i].add(600);
                    points[i].addX(400);
                    points[i].addX(0);
                }

                drawTriangle(g, points[0], points[1], points[2]);
            }
        }
    }

    public static void drawTriangle(Graphics g, Vector v1, Vector v2, Vector v3) {
        Polygon triangle = new Polygon();
        triangle.addPoint((int)Math.floor(v2.getX()), (int)Math.floor(v2.getY()));
        triangle.addPoint((int)Math.floor(v3.getX()), (int)Math.floor(v3.getY()));
        triangle.addPoint((int)Math.floor(v1.getX()), (int)Math.floor(v1.getY()));

        Color c= new Color(
                (int)Math.floor(Math.random() * 255),
                (int)Math.floor(Math.random() * 255),
                (int)Math.floor(Math.random() * 255)
        );
        //c = Color.white;
        g.setColor(c);
        g.fillPolygon(triangle);
        if (Main.showWireframe) {
            g.setColor(Color.RED);
            g.drawPolygon(triangle);
        }
    }

}
