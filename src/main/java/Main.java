import io.ObjectIO;
import pojo.Animal;
import pojo.Car;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal()
                .setName("Кот Barsik")
                .setAge(3);
        Car car = new Car()
                .setName("BMW")
                .setMaxSpeed(300.0);

        ObjectIO.writeObjects("file.txt", 5, false, "abcабв", animal, car);
        ObjectIO.readObjects("file.txt");
    }
}
