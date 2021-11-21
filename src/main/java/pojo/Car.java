package pojo;

import java.io.Serializable;

public class Car implements Serializable {

    private String name;
    private Double maxSpeed;

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public Car setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    @Override
    public String toString() {
        return "pojo.Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
