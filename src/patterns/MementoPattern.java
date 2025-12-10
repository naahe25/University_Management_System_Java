package patterns;

/**
 * Memento Pattern: StudentProfile can save and restore its state using Mementos.
 */
public class MementoPattern {

    public static class StudentProfile {
        private String name;
        private String major;

        public StudentProfile(String name, String major) {
            this.name = name; this.major = major;
        }

        public void setName(String name) { this.name = name; }
        public void setMajor(String major) { this.major = major; }

        public Memento save() {
            return new Memento(name, major);
        }

        public void restore(Memento m) {
            this.name = m.name;
            this.major = m.major;
        }

        @Override
        public String toString() {
            return "StudentProfile{name='" + name + "', major='" + major + "'}";
        }

        public static class Memento {
            private final String name;
            private final String major;
            private Memento(String name, String major) {
                this.name = name;
                this.major = major;
            }
        }
    }
}
