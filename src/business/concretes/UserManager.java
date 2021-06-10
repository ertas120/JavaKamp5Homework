package business.concretes;

import business.abstracts.UserService;
import core.abstracts.GoogleService;
import core.abstracts.LoggerService;
import dataAccess.abstracts.UserDaoService;
import entites.concretes.User;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserManager implements UserService {
    private String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|" +
            "mil|biz|info|mobi)(.[A-Z]{2})?$";

    private ArrayList<User> users = new ArrayList<>();
    private UserDaoService userDaoService;
    private LoggerService loggerService;
    private GoogleService googleService ;

    public UserManager(UserDaoService userDaoService, LoggerService loggerService, GoogleService googleService) {
        this.userDaoService = userDaoService;
        this.loggerService = loggerService;
        this.googleService = googleService;
    }

    public boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN,
                Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).find();
    }


    @Override
    public void login(User user) {
        for (User i : users) {
            if ((user.getPassword().equals(i.getPassword())) && (user.getPassword().equals(i.getPassword()))) {
                userDaoService.login(user);
                return;
            }
        }
        System.out.println("Kullanici bulunamadi");
    }

    @Override
    public void register(User user) {
        if (!isEmailValid(user.geteMail())) {
            System.out.println("e posta geçersiz");
            return;
        }
        if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2 && user.getPassword().length() >= 6) {
            loggerService.emailLog(user);
            if (linkTiklanmisMi(user)) {
                userDaoService.add(user);
            } else {
                System.out.println("Lütfen dogrulama limkine tiklayiniz");
            }
        } else {
            System.out.println("sifre veya isim yanlıs :/");
        }
    }

    public void withGoogleLogin(String email, String password) {
        googleService.login(email,password);
    }
    public void withGoogleRegister(String email, String password) {
        googleService.register(email,password);
    }

    public boolean linkTiklanmisMi(User user) {
        return true;
    }
}
