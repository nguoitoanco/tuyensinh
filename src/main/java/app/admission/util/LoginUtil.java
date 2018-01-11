package app.admission.util;

import app.admission.model.constant.Constant;

import javax.servlet.http.HttpSession;

/**
 * @author p-tvo-khanhnv
 */
public class LoginUtil {

    public static boolean isLogin(HttpSession session) {
        return ((session != null) && (session.getAttribute(Constant.Session.USER_INFO) != null));
    }
}
