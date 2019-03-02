package cs108;

public final class RedDisk implements Image<ColorRGB> {
    public static final Image<ColorRGB> IMAGE = new RedDisk();

    @Override
    public ColorRGB apply(float x, float y) {
        double r = Math.sqrt(x * x + y * y);
        return r <= 1.0 ? ColorRGB.RED : ColorRGB.WHITE;
    }
}