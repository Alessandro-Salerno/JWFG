package cpurender.graphics.shading.shaders.base;

import cpurender.graphics.shading.color.ColorShader;

import java.awt.*;

public class BaseColorShader extends ColorShader {
    @Override
    public void main() {
        this.getOutput().setColor(new Color(0, 0, 0));
    }
}
