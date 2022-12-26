package cpurender.graphics.shading.shaders.custom;

import cpurender.graphics.shading.color.ColorShader;

import java.awt.*;
import java.util.Random;

public class NiceSkyShader extends ColorShader {
    private double color = (int) Math.round(new Random().nextDouble() * 255);
    private double direction = 0.01;

    @Override
    public void main() {
        if (color >= 255) {
            color = 255;
            direction = -0.01;
        } else if (direction <= 0) {
            color = 0;
            direction = 0.01;
        }

        this.getOutput().setColor(new Color((int) Math.floor(color), 255 - (int) Math.floor(color), 255 % ((int) Math.floor(color) + 1)));
        color += direction;
    }
}
