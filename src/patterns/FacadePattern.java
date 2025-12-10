package patterns;

// A small facade that shows how multiple subsystems can be hidden behind
// a single, easy-to-use method. This keeps the demo readable.
public class FacadePattern {

    public static class UniversityFacade {
        private final AdmissionSystem admission = new AdmissionSystem();
        private final FinanceSystem finance = new FinanceSystem();
        private final LibrarySystem library = new LibrarySystem();

        public void enrollStudent(Student s, double fee) {
            admission.register(s);
            finance.processPayment(s, fee);
            library.createAccount(s);
            System.out.println("Facade: Enrollment complete for " + s.getName());
        }
    }

    // Tiny subsystem stubs to keep the example focused.
    private static class AdmissionSystem {
        void register(Student s) { System.out.println("Admission: Registered " + s.getName()); }
    }
    private static class FinanceSystem {
        void processPayment(Student s, double amount) { System.out.println("Finance: Processed payment of $" + amount + " for " + s.getName()); }
    }
    private static class LibrarySystem {
        void createAccount(Student s) { System.out.println("Library: Account created for " + s.getEmail()); }
    }
}
