package patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// RegistrySingleton: a single place to hold students in the demo.
// It's intentionally simple  thread-safe lazy init and a few helper methods.
public class SingletonPattern {

    public static class RegistrySingleton {
        private static RegistrySingleton instance;
        private final List<Student> students = new ArrayList<>();

        private RegistrySingleton() {}

        public static synchronized RegistrySingleton getInstance() {
            if (instance == null) {
                instance = new RegistrySingleton();
            }
            return instance;
        }

        public void addStudent(Student s) { students.add(s); }
        public List<Student> getStudents() { return Collections.unmodifiableList(students); }
        public void clear() { students.clear(); }
    }
}
