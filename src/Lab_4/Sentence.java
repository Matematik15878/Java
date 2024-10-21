package Lab_4;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Object> elements = new ArrayList<>();

    public Sentence(StringBuffer sentence) {
        String[] parts = sentence.toString().split(" ");
        for (String part : parts) {
            if (part.matches("\\p{Punct}")) {
                elements.add(new Punctuation(part.charAt(0)));
            } else {
                elements.add(new Word(new StringBuffer(part)));
            }
        }
    }

    public StringBuffer process_sentence() {
        StringBuffer result = new StringBuffer();
        for (Object element : elements) {
            if (element instanceof Word) {
                result.append(((Word) element).remove_first_letter_occurrences()).append(" ");
            } else if (element instanceof Punctuation) {
                result.append(((Punctuation) element).get_symbol()).append(" ");
            }
        }
        return new StringBuffer(result.toString().trim());
    }
}