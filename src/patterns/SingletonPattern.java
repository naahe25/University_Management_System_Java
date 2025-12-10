package patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton Pattern: RegistrySingleton is an application-wide single instance that keeps students.
 */
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
