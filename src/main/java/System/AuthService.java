package edu.university.system;
 
import edu.university.exceptions.AuthenticationException;
import edu.university.users.User;
 
import java.util.List;
 
public class AuthService {
    public User authenticate(String login, String password, List<User> users)
            throws AuthenticationException {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.checkPassword(password)) {
                return user;
            }
        }
        throw new AuthenticationException("Invalid login or password");
    }
 
    public void logout(User user) {
        System.out.println(user.getLogin() + " logged out");
    }
 
    public boolean changePassword(User user, String oldPassword, String newPassword) {
        return user.changePassword(oldPassword, newPassword);
    }
}
