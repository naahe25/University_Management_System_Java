package patterns;

import java.util.ArrayList;
import java.util.List;

// Command pattern example: encapsulate add/remove operations so they can be
// executed and undone. The invoker keeps a tiny history for undo.
public class CommandPattern {

    public interface Command {
        void execute();
        void undo();
    }

    public static class StudentReceiver {
        private final List<Student> students = new ArrayList<>();
        public void add(Student s) { students.add(s); System.out.println("Receiver: added " + s); }
        public void remove(Student s) { students.remove(s); System.out.println("Receiver: removed " + s); }
        public List<Student> getStudents() { return students; }
    }

    public static class AddStudentCommand implements Command {
        private final StudentReceiver receiver;
        private final Student student;
        public AddStudentCommand(StudentReceiver r, Student s) { receiver = r; student = s; }
        @Override public void execute() { receiver.add(student); }
        @Override public void undo() { receiver.remove(student); }
    }

    public static class RemoveStudentCommand implements Command {
        private final StudentReceiver receiver;
        private final Student student;
        public RemoveStudentCommand(StudentReceiver r, Student s) { receiver = r; student = s; }
        @Override public void execute() { receiver.remove(student); }
        @Override public void undo() { receiver.add(student); }
    }

    public static class Invoker {
        private final List<Command> history = new ArrayList<>();
        public void run(Command c) { c.execute(); history.add(c); }
        public void undoLast() {
            if (!history.isEmpty()) {
                Command c = history.remove(history.size() - 1);
                c.undo();
            } else {
                System.out.println("Invoker: nothing to undo");
            }
        }
    }
}
