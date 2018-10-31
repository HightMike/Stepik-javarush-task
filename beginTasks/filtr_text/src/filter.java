import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.security.Key;

public class filter {
    // тесты
    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords), //создание экземпляра
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        filter testObject = new filter();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
        String rty = "Это весело";
        System.out.println(testObject.checkLabels(textAnalyzers4, rty));
    }
    interface TextAnalyzer { // в интерфейсах все методы абстрактны
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }


    static abstract class KeywordAnalyzer implements TextAnalyzer { // если abstract, то значит нельзя создавать его экземпляры, т.е. нельзя KeywordAnalyzer test = KeywordAnalyzer(asdada);

        protected abstract String[] getKeywords(); // абстрактные методы, которые мы обещает реализовать в классах наследниках

        protected abstract Label getLabel(); // абстрактные методы, которые мы обещает реализовать в классах наследниках (обязательно)

        public Label processText(String text) {
            for (int i=0; i<=getKeywords().length-1; i++) {
                if (text.lastIndexOf(getKeywords()[i])!=-1) {
                    return getLabel();
                }
            }
            return Label.OK;
        }


    }

    static class SpamAnalyzer extends KeywordAnalyzer { // Производный класс обязан переопределить и реализовать все абстрактные методы, которые имеются в базовом абстрактном классе
    private String[] keywords;
    Label test3 = Label.SPAM;
    public SpamAnalyzer (String[] keywords) { // создание конструктора из массива строк

        this.keywords = keywords; // rty ссылается на ранее созданный массив строк / сохранение массива строк
    }
    public String[] getKeywords() {
        return keywords;
    }
    public Label getLabel() {
        return test3;
    }

    }

    static class NegativeTextAnalyzer extends KeywordAnalyzer {
        String[] keywords = {":(", "=(", ":|"};
        Label test2 = Label.NEGATIVE_TEXT;
        public NegativeTextAnalyzer() {
        }
            // конструктор по умолчанию.
        public String[] getKeywords() {
            return keywords;
        }
        public Label getLabel() { // public так как должен быть такой же или выше чем в родительском классе
            return test2;
        }

    }

    static class TooLongTextAnalyzer implements TextAnalyzer{
        private int maxLength;
        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            if (text.length()>maxLength) {
                return Label.TOO_LONG;
            }
            return Label.OK;
        }
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) { // текст из интерфейса ...

        for ( TextAnalyzer n : analyzers) {
            Label label = n.processText(text); //Вызываем у объекта класса NegativeTextAnalyzer и т.д.  метод processText, а сам текст задаем выше.
            if(label!=Label.OK) {
                return label; // возвращает негативный ответ
            }
        }
        return Label.OK;
    }

}
