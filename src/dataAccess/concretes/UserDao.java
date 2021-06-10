package dataAccess.concretes;

import dataAccess.abstracts.UserDaoService;
import entites.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoService {
    List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
        System.out.println("kullanici eklendi");
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        System.out.println("kullanici silindi");
    }

    @Override
    public void update(User user, int index) {
        users.add(index,user);
        System.out.println("Kullanici güncellendi");
    }

    @Override
    public void verify(User user) {
        System.out.println("kullanici dogrulandi : " + user.getFirstName());
    }

    @Override
    public void login(User user) {
        System.out.println("basarili bir sekilde giris yapıldı");
    }
}
