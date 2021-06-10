package core.concretes;

import core.abstracts.GoogleService;
import googleService.GoogleManager;

public class GoogleAdapter implements GoogleService {

    @Override
    public void login(String email, String password) {
        GoogleManager googleManager = new GoogleManager();
        googleManager.login(email,password);
    }

    @Override
    public void register(String email, String password) {
        GoogleManager googleManager = new GoogleManager();
        googleManager.register(email,password);
    }
}
