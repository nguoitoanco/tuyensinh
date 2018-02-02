package app.admission.service;


import app.admission.exception.CommonException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment)
            throws CommonException;
}
