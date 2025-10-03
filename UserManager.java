public class UserManager {
    public void addUser(String name, String email) {
        if (!validateUser(name, email)) {
            return;
        }
        System.out.println("User added: " + name + " - " + email);
    }

    public void updateUser(String name, String email) {
        if (!validateUser(name, email)) {
            return;
        }
        System.out.println("User updated: " + name + " - " + email);
    }

    private boolean validateUser(String name, String email) {
        if (name == null || name.isEmpty()) {
            System.out.println("Invalid name");
            return false;
        }
        if (email == null || email.isEmpty()) {
            System.out.println("Invalid email");
            return false;
        }
        return true;
    }
}