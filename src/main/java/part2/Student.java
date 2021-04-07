package part2;

public class Student {

    private int id;
    private String name;
    private int age;
    private String state;

    public Student(int id, String name, int age, String state) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.state = state;
    }

    public Student(String name, int age, String state) {
        this.name = name;
        this.age = age;
        this.state = state;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                '}';
    }
}
