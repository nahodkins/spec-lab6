package config;

import java.util.HashMap;

public class UsersConfig {

    private HashMap<String, Integer> usersPasswords;

    public HashMap<String, Integer> getUsersPasswords() {
        return usersPasswords;
    }

    public void setUsersPasswords(HashMap<String, Integer> usersPasswords) {
        this.usersPasswords = usersPasswords;
    }
}
