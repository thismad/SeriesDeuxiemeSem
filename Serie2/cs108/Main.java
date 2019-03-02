package cs108;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class Main extends Application {
    // L'image à afficher. A modifier au fur et à mesure de votre avancement.
    //private Image<ColorRGB> image = RedDisk.IMAGE;
   // private Image<ColorRGB> image = ChessBoard.IMAGE_CHESS;
   // private Image<ColorRGB> image = new Rotated<ColorRGB>(ChessBoard.IMAGE_CHESS,0.17f);
   // private Image<ColorRGB> image = new Mysterious<>(RedDisk.IMAGE);
    private Image<ColorRGB> image = new Composed(new Rotated<ColorRGB>(ChessBoard.IMAGE_CHESS,0.17f), RedDisk.IMAGE);
    // Portion finie de l'image infinie à dessiner.
    private final static float CENTER_X = 0, CENTER_Y = 0;
    private final static float WIDTH = 3;

    // Taille (en pixels) de l'image à générer.
    private final static int PIXEL_WIDTH = 400;
    private final static int PIXEL_HEIGHT = PIXEL_WIDTH;

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView imageView = new ImageView();
        imageView.setImage(drawImage(image, PIXEL_WIDTH, PIXEL_HEIGHT));
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        BorderPane root = new BorderPane(imageView, null, null, null, null);
        root.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));

        imageView.fitWidthProperty().bind(root.widthProperty());
        imageView.fitHeightProperty().bind(root.heightProperty());

        Scene scene = new Scene(root);

        primaryStage.setTitle("Image viewer");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(PIXEL_WIDTH);
        primaryStage.setMinHeight(PIXEL_HEIGHT);
        primaryStage.show();
    }

    private javafx.scene.image.Image drawImage(Image<ColorRGB> sImage, int width, int height) {
        WritableImage tImage = new WritableImage(width, height);
        PixelWriter pWriter = tImage.getPixelWriter();
        float inc = WIDTH / width;
        float xMin = CENTER_X - inc * (width / 2f);
        float yMax = CENTER_Y + inc * (width / 2f);
        for (int imageX = 0; imageX < width; ++imageX) {
            float x = xMin + inc * imageX;
            for (int imageY = 0; imageY < height; ++imageY) {
                float y = yMax - inc * imageY;
                pWriter.setColor(imageX, imageY, image.apply(x, y).toJavaFXColor());
            }
        }
        return tImage;
   }
}