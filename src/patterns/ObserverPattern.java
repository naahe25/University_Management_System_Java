package patterns;

import java.util.ArrayList;
import java.util.List;

// Simple observer example: a course broadcasts announcements to students.
// The observer implementation is intentionally small so it's easy to follow.
public class ObserverPattern {

    public interface Observer {
        void update(String announcement);
    }

    public static class CourseSubject {
        private final List<Observer> observers = new ArrayList<>();

        public void registerObserver(Observer o) { observers.add(o); }
        public void removeObserver(Observer o) { observers.remove(o); }

        public void announce(String announcement) {
            System.out.println("Course: New announcement -> " + announcement);
            for (Observer o : new ArrayList<>(observers)) {
                o.update(announcement);
            }
        }
    }

    // A tiny observer that prints announcements addressed to a student.
    public static class StudentObserver implements Observer {
        private final Student student;
        public StudentObserver(Student student) { this.student = student; }
        @Override
        public void update(String announcement) {
            System.out.println("Observer: " + student.getName() + " received -> " + announcement);
        }
    }
}
