package me.djdisaster.matrix;

import me.djdisaster.Vector;

public class FishMatrix implements Matrix {
    @Override
    public Vector[][] getMatrix() {
        return new Vector[][]{
                // Body - left side
                new Vector[]{ new Vector(0.0D, 0.0D, 0.0D), new Vector(1.0D, 0.5D, 0.0D), new Vector(1.0D, -0.5D, 0.0D) },
                new Vector[]{ new Vector(1.0D, 0.5D, 0.0D), new Vector(2.0D, 0.0D, 0.0D), new Vector(1.0D, -0.5D, 0.0D) },
                // Tail - left side
                new Vector[]{ new Vector(2.0D, 0.0D, 0.0D), new Vector(2.5D, 0.5D, 0.0D), new Vector(2.5D, -0.5D, 0.0D) },
                // Top fin
                new Vector[]{ new Vector(1.0D, 0.5D, 0.0D), new Vector(1.5D, 1.0D, 0.0D), new Vector(0.5D, 1.0D, 0.0D) },
                // Bottom fin
                new Vector[]{ new Vector(1.0D, -0.5D, 0.0D), new Vector(0.5D, -1.0D, 0.0D), new Vector(1.5D, -1.0D, 0.0D) },
                // Body - right side
                new Vector[]{ new Vector(0.0D, 0.0D, 0.0D), new Vector(1.0D, 0.0D, 0.5D), new Vector(1.0D, 0.0D, -0.5D) },
                new Vector[]{ new Vector(1.0D, 0.0D, 0.5D), new Vector(2.0D, 0.0D, 0.0D), new Vector(1.0D, 0.0D, -0.5D) },
                // Tail - right side
                new Vector[]{ new Vector(2.0D, 0.0D, 0.0D), new Vector(2.5D, 0.0D, 0.5D), new Vector(2.5D, 0.0D, -0.5D) },
                // Connecting top and bottom fins to body
                new Vector[]{ new Vector(1.0D, 0.5D, 0.0D), new Vector(1.0D, 0.0D, 0.5D), new Vector(1.5D, 1.0D, 0.0D) },
                new Vector[]{ new Vector(1.0D, -0.5D, 0.0D), new Vector(1.0D, 0.0D, -0.5D), new Vector(1.5D, -1.0D, 0.0D) },
                // Eyes (optional)
                new Vector[]{ new Vector(0.5D, 0.2D, 0.3D), new Vector(0.5D, 0.1D, 0.3D), new Vector(0.6D, 0.15D, 0.3D) },
                new Vector[]{ new Vector(0.5D, -0.2D, 0.3D), new Vector(0.5D, -0.1D, 0.3D), new Vector(0.6D, -0.15D, 0.3D) },
        };
    }
}
