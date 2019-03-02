package cs108;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public final class Rotated <T> implements Image<T> {
    private final Image<T> image;
    private float angle;
   
    public Rotated(Image<T> image, float angle) {
        this.image=image;
        this.angle=angle;
    }
    @Override
    public T apply(float x, float y) {
        float newX=(float)(x*cos(angle)+y*sin(angle));
        float newY=(float)(-x*sin(angle)+y*cos(angle));
        return image.apply(newX, newY);
    }
}
