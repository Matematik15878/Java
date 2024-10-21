package Lab_4;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Letter> letters = new ArrayList<>();

    public Word(StringBuffer word) {
        for (int i = 0; i < word.length(); i++) {
            letters.add(new Letter(word.charAt(i)));
        }
    }

    public StringBuffer remove_first_letter_occurrences() {
        if (letters.isEmpty()) {
            return new StringBuffer();
        }

        char first_char = letters.getFirst().to_lower_case().get_character();
        StringBuffer result = new StringBuffer();

        for (Letter letter : letters) {
            if (letter.to_lower_case().get_character() != first_char) {
                result.append(letter.get_character());
            }
        }

        return result;
    }
}
