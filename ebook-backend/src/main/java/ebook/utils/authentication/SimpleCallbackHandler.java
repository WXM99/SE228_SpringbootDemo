package ebook.utils.authentication;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

public class SimpleCallbackHandler implements CallbackHandler {
    public SimpleCallbackHandler(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public void handle(Callback[] callbacks) {
        for (Callback callback : callbacks) {
            if (callback instanceof NameCallback) {
                ((NameCallback) callback).setName(username);
            } else if (callback instanceof PasswordCallback) {
                ((PasswordCallback) callback).setPassword(password);
            }
        }
    }

    private String username;
    private char[] password;

}
