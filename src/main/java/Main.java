import config.UsersConfigReader;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.Map;

public class Main {

    private static final String WELCOME_MSG_TEMPLATE = "Welcome, %s%n";
    private static final String LOGIN_FAILED_MSG = "Incorrect login or password!";

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> users = UsersConfigReader.readConfig().getUsersPasswords();
        Console console = System.console();
        String login = console.readLine("Login: ");
        String password = String.valueOf(console.readPassword("Password: "));
        Integer hashPassword = users.get(login);
        if (HashCoder.hashString(password).equals(hashPassword)) {
            System.out.printf(WELCOME_MSG_TEMPLATE, login);
        } else {
            System.err.println(LOGIN_FAILED_MSG);
        }
    }
}
