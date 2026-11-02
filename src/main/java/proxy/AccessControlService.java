package proxy;

import java.util.HashMap;

public class AccessControlService {
    private static AccessControlService instance;
    private HashMap<String, User> users;

    public AccessControlService() {
        this.users = new HashMap<>();
    }

    public boolean isAllowed(String username, String documentName) {
        //check if user is in the list of users, if not return false
        User user = users.get(username);
        return user != null;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

}
