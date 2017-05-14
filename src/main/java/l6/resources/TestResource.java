package l6.resources;

/**
 * Created by Cole S' Offe on 13.05.2017.
 */
public class TestResource {
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public TestResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResource() {
        this.name = "";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "TestResource{" +
                "name='" + name + '\'' +
                ", age='" + age + '\''+"}" ;
    }
}
