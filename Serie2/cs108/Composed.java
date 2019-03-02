package cs108;

public class Composed  implements Image<ColorRGB> {
    private Image<ColorRGB> image;
    private Image<ColorRGB> image2;
    private HorizontalGradientMask mask = new HorizontalGradientMask();
    
    public Composed(Image<ColorRGB> image, Image<ColorRGB> image2) {
        this.image=image;
        this.image2=image2;
    }
    
    public ColorRGB apply(float x, float y) {
        return image.apply(x, y).mixWith(image2.apply(x, y), mask.apply(x, y));
    }
}
