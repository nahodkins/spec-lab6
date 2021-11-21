package pojo;

import java.io.Serializable;

public class Animal implements Serializable {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Animal setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "pojo.Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
