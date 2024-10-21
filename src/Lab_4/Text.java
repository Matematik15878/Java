package Lab_4;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences = new ArrayList<>();

    public Text(StringBuffer input) {
        String[] sentence_parts = input.toString().split("(?<=[.!?])\\s+");
        for (String sentence_part : sentence_parts) {
            sentences.add(new Sentence(new StringBuffer(sentence_part)));
        }
    }

    public StringBuffer process_text() {
        StringBuffer result = new StringBuffer();
        for (Sentence sentence : sentences) {
            result.append(sentence.process_sentence()).append(" ");
        }
        return new StringBuffer(result.toString().trim());
    }
}