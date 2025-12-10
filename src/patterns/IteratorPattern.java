package patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator Pattern: StudentCollection implements Iterable<Student>.
 */
public class IteratorPattern implements Iterable<Student> {
    private final List<Student> students = new ArrayList<>();

    public void add(Student s) { students.add(s); }
    public int size() { return students.size(); }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
