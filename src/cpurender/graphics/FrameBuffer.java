package cpurender.graphics;

import java.awt.*;

public class FrameBuffer {
    private final Graphics swingBuffer;
    private int width;
    private int height;

    public FrameBuffer(Graphics swingBuffer) {
        this.swingBuffer = swingBuffer;
    }

    public Graphics getSwingBuffer() {
        return this.swingBuffer;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void clear(Color clearColor) {
        Color drawColor = this.swingBuffer.getColor();
        this.swingBuffer.setColor(clearColor);
        this.swingBuffer.fillRect(0, 0, this.width, this.height);
        this.swingBuffer.setColor(drawColor);
    }

    public void clear() {
        this.clear(new Color(255, 255, 255));
    }

    public void fill() {
        this.swingBuffer.fillRect(0, 0, this.width, this.height);
    }
}
