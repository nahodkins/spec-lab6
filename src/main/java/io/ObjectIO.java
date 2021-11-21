package io;

import pojo.Animal;
import pojo.Car;

import java.io.*;

public class ObjectIO {

    public static void writeObjects(String file, int integer, boolean bool, String str, Animal animal, Car car) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))){
            stream.writeInt(integer);
            stream.writeBoolean(bool);
            stream.writeObject(str);
            stream.writeObject(animal);
            stream.writeObject(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObjects(String file) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))){
            int integer = stream.readInt();
            boolean bool = stream.readBoolean();
            String string = (String) stream.readObject();
            Animal animal = (Animal) stream.readObject();
            Car car = (Car) stream.readObject();

            System.out.println("Integer: " + integer);
            System.out.println("Boolean: " + bool);
            System.out.println("String: " + string);
            System.out.println("pojo.Animal: " + animal);
            System.out.println("pojo.Car: " + car);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
