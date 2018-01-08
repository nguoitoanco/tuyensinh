package co.jp.admission.model.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class User implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(User.class);
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String userId;
    private String name;
    private String password;
    private String confirmPassword;
    private boolean changePassword;

    public User() {
    }


    public User(String userId, String name, String password, String confirmPassword, boolean changePassword) {
        this();
        LOG.debug("Call to (userId, name, password, confirmPassword,changePassword) " + "contructor");
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.changePassword = changePassword;
        this.confirmPassword = confirmPassword;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }
}
