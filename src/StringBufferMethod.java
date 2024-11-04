import java.util.HashSet;

public class StringBufferMethod {
    private StringBuffer sb;
    private int wordLenght;

    public StringBufferMethod(String text, int wordLenght) {
        this.sb = new StringBuffer(text);
        this.wordLenght = wordLenght;
    }


    public String getAllWords(){
        try {
            HashSet<String> foundWords = new HashSet<>();

            StringBuffer sentence = getNextSentence();
            if (sentence == null) {
                throw new NullPointerException("У заданому тексті речення відсутні.");
            }

            while (sb.length() > 0) {
                if (sentence.length() == 0) {
                    break;
                }
                if (sentence.charAt(sentence.length() - 1) == '?') {
                    HashSet<String> matchingWords = getWordsWithGivenLengthInSentence(sentence);
                    foundWords.addAll(matchingWords);
                }
                //sentenceCount++;
                deleteSentence(sentence);
                sentence = getNextSentence();
            }
            return "Знайдені слова довжиною " + wordLenght + " літер: " + foundWords;
        }
        catch (NullPointerException e) {
            return e.getMessage();
        }
        catch (Exception e) {
            return "Несподівана помикла: " + e.getMessage();
        }
    }

    public int findSentenceEnd(){
        for (int i=0; i<sb.length(); i++){
            char end = sb.charAt(i);
            if (end == '.' || end == '!' || end == '?'){
                return i;
            }
        }
        return -1;
    }

    public StringBuffer getNextSentence(){
        int pos = findSentenceEnd();
        if (pos == -1){
            return null;
        }
        StringBuffer sentence = new StringBuffer(sb.substring(0, pos+1));
        return sentence;
    }

    public void deleteSentence (StringBuffer sentence){
        sb.delete(0, sentence.length()).trimToSize();
    }

    public HashSet<String> getWordsWithGivenLengthInSentence(StringBuffer sentence){
        HashSet<String> matchingWords = new HashSet<>();
        String[] words = sentence.toString().split("\\s+");

        for (String word : words) {
            int nonLetterChars = 0;
            StringBuffer wordBuffer = new StringBuffer(word.replace("[^а-яА-Яa-zA-Z]", ""));
            for (int i=0; i<wordBuffer.length(); i++){
                char ch = wordBuffer.charAt(i);
                if (!Character.isLetter(ch)){
                    nonLetterChars += 1;
                }
            }
            if ((wordBuffer.length() - nonLetterChars) == wordLenght){
                matchingWords.add((wordBuffer.toString()).substring(0, wordLenght));
            }
        }
        return matchingWords;
    }
}
