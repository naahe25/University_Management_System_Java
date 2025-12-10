package patterns;

// Decorator example: basic notifier that can be wrapped to add channels
// like email or SMS. Kept minimal so it's easy to reuse in real code.
public class DecoratorPattern {

    public interface Notifier {
        void send(String message);
    }

    public static class BasicNotifier implements Notifier {
        private final Student recipient;
        public BasicNotifier(Student s) { recipient = s; }
        @Override
        public void send(String message) {
            System.out.println("BasicNotifier -> To " + recipient.getEmail() + ": " + message);
        }
    }

    public static abstract class NotifierDecorator implements Notifier {
        protected final Notifier wrappee;
        public NotifierDecorator(Notifier wrappee) { this.wrappee = wrappee; }
        @Override public void send(String message) { wrappee.send(message); }
    }

    public static class EmailDecorator extends NotifierDecorator {
        public EmailDecorator(Notifier n) { super(n); }
        @Override public void send(String message) {
            super.send(message);
            System.out.println("EmailDecorator -> Also sent as EMAIL: " + message);
        }
    }

    public static class SMSDecorator extends NotifierDecorator {
        public SMSDecorator(Notifier n) { super(n); }
        @Override public void send(String message) {
            super.send(message);
            System.out.println("SMSDecorator -> Also sent as SMS: " + message);
        }
    }
}
