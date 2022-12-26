package cpurender.graphics;

import geometry.Geometry;

import java.util.HashSet;
import java.util.Set;

public class Scene {
    private final Set<Geometry> elements;
    private Viewport viewport;

    public Scene() {
        this.elements = new HashSet<>();
    }

    public Set<Geometry> getElements() {
        return this.elements;
    }

    public Viewport getViewport() {
        return this.viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public void addElement(Geometry geometry) {
        this.elements.add(geometry);
    }

    public void removeElement(Geometry geometry) {
        this.elements.remove(geometry);
    }
}
