package business.abstracts;

import entites.concretes.User;

public interface UserService {
    void login (User user);
    void register(User user);
}
