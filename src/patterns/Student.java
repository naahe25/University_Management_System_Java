package patterns;

// Simple POJO for demo purposes. Nothing fancy  just id, name and an email.
// I kept this minimal so the pattern examples focus on the patterns
// themselves without pulling in other project code.
public class Student {
    private final int id;
    private String name;
    private String email;

    public Student(int id, String name) {
        this(id, name, name.toLowerCase().replaceAll("\\s+","") + "@univ.edu");
    }

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
