package cs108;

public final class ChessBoard implements Image<ColorRGB>{
    public static final Image<ColorRGB> IMAGE_CHESS = new ChessBoard();
    private ColorRGB color1;
    private ColorRGB color2;
    private double width;

    public ChessBoard() {
        this(1, ColorRGB.BLACK, ColorRGB.WHITE);
    }

    public ChessBoard(double w, ColorRGB c1, ColorRGB c2) {
        if (w<0) throw new IllegalArgumentException();
        this.width=w;
        this.color1=c1;
        this.color2=c2;
    }
   

    @Override
    public ColorRGB apply(float x, float y) {
        double newWidth = x* width;
        double newX=newWidth*Math.cos(0.17)+y*Math.sin(0.17);
        double newY=-newWidth*Math.sin(0.17)+y*Math.cos(0.17);
        double r = Math.floor(newWidth)+Math.floor(y);
        if(r %2 ==0) {
            return color1;
        }
        else return color2;
    }


}
