package patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// A small iterable collection so the demo can show the iterator pattern.
// Nothing fancy here  just delegates to an ArrayList iterator.
public class IteratorPattern implements Iterable<Student> {
    private final List<Student> students = new ArrayList<>();

    public void add(Student s) { students.add(s); }
    public int size() { return students.size(); }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
