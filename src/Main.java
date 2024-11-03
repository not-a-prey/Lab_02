import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int c3 = 2213 % 3;
        int c17 = 2213 % 17;

        System.out.println("Тип текстових зміних за варіантом 2213 mod 3: " + c3 + " - StringBuffer");
        System.out.println("Дія з текстом за варіантом 2213 mod 17: " + c17 + " - В усіх питальних реченнях\n" +
                "заданого тексту знайти та надрукувати без повторень слова заданої довжини.\n");

        //Довжина слів, які будуть знайдені у питальних реченнях
        int wordLengthy = 3;
        //Текст, з яким ми працюємо. Знаходяться саме слова за довжиною, щось на кшталт "a+t" - не є словом і буде виключатись.
        String inputText = """
                But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain
                was born? and I will give you a complete account of the system, and expound the actual teachings of the
                great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids
                pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure
                rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or
                pursues or desires to obtain pain of itself, because it is pain, but because occasionally
                circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial
                example, which o+f us ever undertakes laborious physical exercise, except to obtain some advantage
                from it? But who has any right to. find fault with a man who chooses to enjoy a pleasure that has
                no annoying consequences, or! one who avoids a pain that produces -no resultant pleasure?""";


        StringBufferMethod myBuffer = new StringBufferMethod(inputText, wordLengthy);
        HashSet<String> sixLetterWords = myBuffer.getAllWords();

        System.out.println("Знайдені слова довжиною " + wordLengthy + " літер: " + sixLetterWords);
    }
}