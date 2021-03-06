package ru.job4j.gc;

/**
 * @author Ajiekcander
 */
public class User {
    private int age;
    private String name;

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Removed %d %s%n", age, name);
    }
}
