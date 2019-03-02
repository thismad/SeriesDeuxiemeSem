package cs108;

/**
 * Une image continue et infinie, représentée par une fonction associant une
 * couleur à chaque point du plan.
 */

public interface Image <T>  {
    public T apply(float x, float y);
}
