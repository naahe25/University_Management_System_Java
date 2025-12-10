package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Main runner to demonstrate all 10 patterns in action.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern Demo ===");
        Student s1 = FactoryPattern.createStudent(1, "Alice Anderson", FactoryPattern.StudentLevel.UNDERGRAD);
        Student s2 = FactoryPattern.createStudent(2, "Bob Brown", FactoryPattern.StudentLevel.GRAD);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("\n=== Singleton Pattern Demo ===");
        SingletonPattern.RegistrySingleton reg = SingletonPattern.RegistrySingleton.getInstance();
        reg.clear();
        reg.addStudent(s1);
        reg.addStudent(s2);
        System.out.println("Registry contains: " + reg.getStudents());

        System.out.println("\n=== Facade Pattern Demo ===");
        FacadePattern.UniversityFacade facade = new FacadePattern.UniversityFacade();
        facade.enrollStudent(new Student(3, "Carol Chen"), 1500.00);

        System.out.println("\n=== Memento Pattern Demo ===");
        MementoPattern.StudentProfile profile = new MementoPattern.StudentProfile("David Doe", "Physics");
        System.out.println("Before: " + profile);
        MementoPattern.StudentProfile.Memento m1 = profile.save();
        profile.setMajor("Computer Science");
        profile.setName("David D.");
        System.out.println("Modified: " + profile);
        profile.restore(m1);
        System.out.println("Restored: " + profile);

        System.out.println("\n=== Observer Pattern Demo ===");
        ObserverPattern.CourseSubject course = new ObserverPattern.CourseSubject();
        ObserverPattern.StudentObserver obs1 = new ObserverPattern.StudentObserver(s1);
        ObserverPattern.StudentObserver obs2 = new ObserverPattern.StudentObserver(s2);
        course.registerObserver(obs1);
        course.registerObserver(obs2);
        course.announce("Midterm on Friday");

        System.out.println("\n=== Iterator Pattern Demo ===");
        IteratorPattern coll = new IteratorPattern();
        coll.add(s1);
        coll.add(s2);
        coll.add(new Student(4, "Eve Evans"));
        for (Student s : coll) {
            System.out.println("Iterated: " + s);
        }

        System.out.println("\n=== Strategy Pattern Demo ===");
        List<Student> list = new ArrayList<>();
        list.add(new Student(10,"Zack"));
        list.add(new Student(5,"Olivia"));
        list.add(new Student(7,"Mona"));
        StrategyPattern.StudentSorter sorter = new StrategyPattern.StudentSorter(new StrategyPattern.SortByName());
        sorter.sort(list);
        System.out.println("Sorted by name: " + list);
        sorter.setStrategy(new StrategyPattern.SortById());
        sorter.sort(list);
        System.out.println("Sorted by id: " + list);

        System.out.println("\n=== Command Pattern Demo ===");
        CommandPattern.StudentReceiver receiver = new CommandPattern.StudentReceiver();
        CommandPattern.Invoker invoker = new CommandPattern.Invoker();
        Student cmdStudent = new Student(20, "Frank");
        CommandPattern.AddStudentCommand addCmd = new CommandPattern.AddStudentCommand(receiver, cmdStudent);
        invoker.run(addCmd);
        System.out.println("Receiver now: " + receiver.getStudents());
        invoker.undoLast();
        System.out.println("Receiver after undo: " + receiver.getStudents());

        System.out.println("\n=== Composite Pattern Demo ===");
        CompositePattern.Department science = new CompositePattern.Department("Science Department");
        CompositePattern.Employee e1 = new CompositePattern.Employee(new Student(30, "Grace"));
        CompositePattern.Employee e2 = new CompositePattern.Employee(new Student(31, "Hank"));
        science.add(e1);
        science.add(e2);
        science.showDetails();

        System.out.println("\n=== Decorator Pattern Demo ===");
        DecoratorPattern.Notifier basic = new DecoratorPattern.BasicNotifier(new Student(40, "Ivy"));
        DecoratorPattern.Notifier decorated = new DecoratorPattern.SMSDecorator(new DecoratorPattern.EmailDecorator(basic));
        decorated.send("Your assignment is due tomorrow.");

        System.out.println("\n=== All demos completed ===");
    }
}
