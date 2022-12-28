package jwfg.instance;

import geometry.Point3D;

public record JWFGInstanceRequest(String shape,
                                  Point3D position,
                                  Point3D rotation,
                                  Point3D viewportPosition,
                                  Point3D viewportRotation) {
    @Override
    public String toString() {
        return "JWFGInstanceRequest{" +
                "shape='" + shape + '\'' +
                ", position=" + position +
                ", rotation=" + rotation +
                ", viewportPosition=" + viewportPosition +
                ", viewportRotation=" + viewportRotation +
                '}';
    }
}
