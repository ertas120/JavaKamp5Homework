package core.concretes;

import core.abstracts.LoggerService;
import entites.concretes.User;

public class Logger implements LoggerService {
    @Override
    public void emailLog(User user) {
        System.out.println("Doğrulama e postası gönderildi lütfen epostanızı kontrol ediniz");
    }
}
