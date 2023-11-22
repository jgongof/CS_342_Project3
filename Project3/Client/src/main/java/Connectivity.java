import java.io.Serializable;

public class Connectivity implements Serializable{
    private static final long serialVersionUID = 1L;

    int categoryWordLength;
    int attempts = 6;

    boolean gotCorrectLetter;
    boolean gotCorrectWord;

    char userLetter;

    int desserts_attempts = 3;
    int fairytales_attempts = 3;
    int cities_attempts = 3;
}
