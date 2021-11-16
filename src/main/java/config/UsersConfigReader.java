package config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UsersConfigReader {

    public static UsersConfig readConfig() throws FileNotFoundException {
        Yaml yaml = new Yaml(new Constructor(UsersConfig.class));
        return yaml.load(UsersConfigReader.class.getResourceAsStream("/users.yaml"));
    }
}
