package Lab_4;

public class Letter {
    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char get_character() {
        return character;
    }

    public Letter to_lower_case() {
        char lowerChar = character;
        if (character >= 'A' && character <= 'Z') {
            lowerChar = (char) (character + ('a' - 'A'));
        }
        return new Letter(lowerChar);
    }
}