package by.itstep.model;

public class Dog {
    int a;
    String title;

    public Dog(Cat cat) {
        this.a = cat.getAge();
        this.title = cat.getName();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "a=" + a +
                ", title='" + title + '\'' +
                '}';
    }
}
