package cpurender.graphics.shading.shaders.custom;

import cpurender.graphics.shading.color.ColorShader;

import java.awt.*;
import java.util.Random;

public class FunkyColorShader extends ColorShader {
    @Override
    public void main() {
        Random rand = new Random();
        int r = (int) Math.round(rand.nextDouble() * 255);
        int g = (int) Math.round(rand.nextDouble() * 255);
        int b = (int) Math.round(rand.nextDouble() * 255);

        this.getOutput().setColor(new Color(r, g, b));
    }
}
