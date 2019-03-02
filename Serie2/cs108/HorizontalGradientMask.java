package cs108;

public class HorizontalGradientMask implements Image<Float>{
    
    public Float apply(float x, float y) {
       if(x<-1) return 1f;
       else if (x>1) return 0f;
       else return 1f-(x+1f)/2f;
    }
}


