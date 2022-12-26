package cpurender.graphics.shading.shaders.base;

import cpurender.graphics.shading.color.ColorShader;

import java.awt.*;

public class BaseSkyShader extends ColorShader {
    @Override
    public void main() {
        this.getOutput().setColor(new Color(255, 255, 255));
    }
}
