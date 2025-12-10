package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Pattern: OrganizationComponent composite structure for departments and employees.
 */
public class CompositePattern {

    public static abstract class OrganizationComponent {
        protected String name;
        public OrganizationComponent(String name) { this.name = name; }
        public abstract void showDetails();
        public void add(OrganizationComponent c) { throw new UnsupportedOperationException(); }
        public void remove(OrganizationComponent c) { throw new UnsupportedOperationException(); }
    }

    public static class Employee extends OrganizationComponent {
        private final Student student; // using Student to represent details
        public Employee(Student student) {
            super(student.getName());
            this.student = student;
        }
        @Override public void showDetails() {
            System.out.println("Employee: " + student);
        }
    }

    public static class Department extends OrganizationComponent {
        private final List<OrganizationComponent> children = new ArrayList<>();
        public Department(String name) { super(name); }
        @Override public void add(OrganizationComponent c) { children.add(c); }
        @Override public void remove(OrganizationComponent c) { children.remove(c); }
        @Override public void showDetails() {
            System.out.println("Department: " + name);
            for (OrganizationComponent c : children) {
                c.showDetails();
            }
        }
    }
}
