package cpurender;

import cpurender.graphics.FrameBuffer;
import cpurender.graphics.Renderer;

import javax.swing.*;

public abstract class Application extends JFrame {
    private final cpurender.graphics.Renderer renderer;

    public Application() {
        super();
        this.renderer = new Renderer();
    }

    public cpurender.graphics.Renderer getRenderer() {
        return this.renderer;
    }

    public final void run() {
        this.setResizable(false);
        this.setVisible(true);

        this.createBufferStrategy(2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        FrameBuffer fb = new FrameBuffer(this.getBufferStrategy().getDrawGraphics());
        fb.setWidth(this.getWidth());
        fb.setHeight(this.getHeight());

        this.renderer.setBuffer(fb);

        this.loop();
    }

    public void loop() {
        while (true) {
            this.renderer.render();
            this.onUpdate();
            this.getBufferStrategy().show();
        }
    }

    public abstract void onUpdate();
}
