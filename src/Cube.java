import java.util.Random;

public class Cube {
    private int value;

    public Cube() {
        int generatedThrow = new Random().nextInt(6) + 1;
        this.value = generatedThrow;
    }

    public int getValue() { return value; }
}


