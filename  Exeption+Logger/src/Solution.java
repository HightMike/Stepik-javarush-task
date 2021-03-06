import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.*;

/**
 * Created by kvu on 16.08.2017.
 */
public class Solution {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Solution.class.getName());

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable correspondence[] = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("рпакетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance", 99)),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };

        System.out.println();
        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });
    }


    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public interface Sendable {
        String getFrom();
        String getTo();
    }



    /*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            return to.equals(that.to);
        }

    }

    /*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            return message != null ? message.equals(that.message) : that.message == null;
        }

    }

    /*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            return content.equals(that.content);
        }

    }

    /*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            return content.equals(aPackage.content);
        }
    }

    /*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
    public interface MailService {
        Sendable processMail(Sendable mail);

    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {
        MailService[] massive; // определяем выше
        RealMailService t; //= new RealMailService();

        public UntrustworthyMailWorker(MailService[] massive) {
            this.massive = massive;
            this.t = new RealMailService();
        }

        public Sendable processMail(Sendable mail) {
            mail = t.processMail(mail);
            for (int i=0; i<massive.length; i++) {
                mail = massive[i].processMail(mail);
            }

            return t.processMail(mail);
        }

        public RealMailService getRealMailService() {
            //RealMailService t = new RealMailService();
            return t;
        }
    }

    public static class Spy implements MailService {

        Logger spylog; // = Logger.getLogger("MailMessage");

        public Spy (Logger spylog) {
            this.spylog = spylog;
        }

        public Sendable processMail(Sendable mail) {
            String message;
            String from;
            String to;

            if (mail instanceof MailMessage) { // если  mail представлен в виде почтового писсьма, а не посылки, то
                MailMessage mailMessage = (MailMessage) mail; // приводим mail к MailMessage (приводится так как вверху проверка на принадлежность этих объектов к одному классу) и одновременно поясняем за mailMessage
                to=mailMessage.getTo();
                from = mailMessage.getFrom();
                if (from.equals(AUSTIN_POWERS) | to.equals(AUSTIN_POWERS)) {
                    message=mailMessage.getMessage();
                    spylog.log(Level.WARNING,
                            "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{from,to, message});
                }
                else {
                    spylog.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{from,to});
                }

            }
            return mail;
        }

    }

    public static class Thief implements MailService {
        Package t;
        int p;
        int sum=0;

        public Thief(int p) {
            this.p =p;
        }

        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                MailPackage pack = (MailPackage) mail;
                Package l = pack.getContent();
                if (l.getPrice()>=p) {
                    sum=sum+l.getPrice();
                    Package zen = new Package("stones instead of "+ l.getContent(), 0);
                    return new MailPackage(pack.getFrom(), pack.getTo(), zen);
                }
            }
            return mail;
        }                //c = y.getContent();

        public int getStolenValue() {

            return sum;
        }

    }

    public static class Inspector implements MailService {
        public Inspector() {
        }


        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                MailPackage pok = (MailPackage) mail;
                Package p = pok.getContent();
                String k = p.getContent();
                if (k.contains(WEAPONS) | k.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                else if (k.contains("stones")) {  //contains - проверка на наличие этих символов
                    throw new StolenPackageException();
                }
            }

            return mail;
        }

    }

    public static class IllegalPackageException extends RuntimeException{
        public IllegalPackageException() {
        }


    }

    public static class StolenPackageException extends RuntimeException{
        public StolenPackageException() {

        }


    }


}