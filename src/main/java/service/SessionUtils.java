package service;

import db.DataBase;
import db.SessionStore;
import model.Cookie;
import model.http.HttpSession;

import java.util.UUID;

public class SessionUtils {

    public static HttpSession getSessionInfo(Cookie cookie) {

        if (checkCookieEmpty(cookie) || !checkContainSession(cookie)) {
            final HttpSession httpSession = new HttpSession();
            SessionStore.addSession(httpSession);

            return httpSession;
        }

        return SessionStore.findSession(cookie.getValue());
    }

    private static boolean checkContainSession(Cookie cookie) {
        final HttpSession session = SessionStore.findSession(cookie.getValue());

        return session != null;
    }

    private static boolean checkCookieEmpty(Cookie cookie) {
        if (cookie.isEmpty()) {
            return true;
        }
        return false;
    }
}
