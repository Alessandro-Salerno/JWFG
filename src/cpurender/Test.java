package cpurender;

import cpurender.graphics.Scene;
import cpurender.graphics.Viewport;
import geometry.Geometry;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // Tools
        Random rand = new Random();

        // cpurender.graphics.Viewport setup
        Viewport viewport = new Viewport();

        // cpurender.graphics.Scene initialization
        Scene scene = new Scene();
        scene.setViewport(viewport);
//        scene.setSkyColor(new Color(255, 255, 0));

        // cpurender.Application initialization
        Application application = new Application() {
            @Override
            public void onUpdate() {
                for (Geometry f : this.getRenderer().getScene().getElements()) {
                    if (f.getX() >= this.getWidth()
                        || f.getY() >= this.getHeight()) {
                        f.setPosition(rand.nextDouble() * (this.getWidth() - 50),
                                        rand.nextDouble() * (this.getHeight() - 50));
                        continue;
                    }

                    f.move(0.02, 0.02, 0);
                }
            }
        };

        // cpurender.Application setup
        application.getRenderer().setScene(scene);
        application.setTitle("Esercizio 13 - CPU Rendering");
        application.setSize(800, 600);

        // cpurender.graphics.Scene setup
        int numitems = (int) Math.floor(rand.nextDouble() * 100);
        for (int i = 0; i < numitems; i++) {
            scene.addElement(new geometry.shapes.Square(rand.nextDouble() * (application.getWidth() - 50),
                    rand.nextDouble() * (application.getHeight() - 50),
                    30));
//            scene.addElement(new Circle(rand.nextDouble() * (application.getWidth() - 50),
//                    rand.nextDouble() * (application.getHeight() - 50),
//                    15));
        }

        // Setup shading
//        application.getRenderer().setVertexShader(new WavyVertexShader());
//        application.getRenderer().setFragmentShader(new FunkyFragmentShader());
//        application.getRenderer().setSkyShader(new NiceSkyShader());

        // cpurender.Application launch
        application.run();
    }
}
