package dataAccess.abstracts;

import entites.concretes.User;

public interface UserDaoService {
    void add(User user);
    void delete(User user);
    void update(User user,int index);
    void verify (User user);
    void login(User user);

}
