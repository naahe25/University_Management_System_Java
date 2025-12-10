package patterns;

import java.util.Comparator;
import java.util.List;

// Strategy demo: swapping sorting algorithms at runtime. Kept short
// so it's obvious how to add more strategies if needed.
public class StrategyPattern {

    public interface SortingStrategy {
        void sort(List<Student> students);
    }

    public static class SortByName implements SortingStrategy {
        @Override
        public void sort(List<Student> students) {
            students.sort(Comparator.comparing(Student::getName));
        }
    }

    public static class SortById implements SortingStrategy {
        @Override
        public void sort(List<Student> students) {
            students.sort(Comparator.comparingInt(Student::getId));
        }
    }

    public static class StudentSorter {
        private SortingStrategy strategy;
        public StudentSorter(SortingStrategy strategy) { this.strategy = strategy; }
        public void setStrategy(SortingStrategy s) { strategy = s; }
        public void sort(List<Student> students) { strategy.sort(students); }
    }
}
