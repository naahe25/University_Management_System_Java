package patterns;

/**
 * Simple Factory Pattern: StudentFactory creates Student instances by type.
 */
public class FactoryPattern {

    public enum StudentLevel { UNDERGRAD, GRAD }

    public static Student createStudent(int id, String name, StudentLevel level) {
        switch (level) {
            case UNDERGRAD:
                return new UndergraduateStudent(id, name);
            case GRAD:
                return new GraduateStudent(id, name);
            default:
                throw new IllegalArgumentException("Unknown level " + level);
        }
    }

    // Concrete student types
    private static class UndergraduateStudent extends Student {
        public UndergraduateStudent(int id, String name) { super(id, name); }
        @Override public String toString() { return "Undergrad" + super.toString(); }
    }

    private static class GraduateStudent extends Student {
        public GraduateStudent(int id, String name) { super(id, name); }
        @Override public String toString() { return "Grad" + super.toString(); }
    }
}
