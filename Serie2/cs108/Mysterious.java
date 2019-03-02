package cs108;

public final class Mysterious<T> implements Image<T> {
    private final Image<T> image;
    
    public Mysterious(Image<T> image) {
        this.image=image;
    }
    
    @Override
    public T apply(float x, float y) {
        return image.apply(x*2, y);
    }
}

