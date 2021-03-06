package it.cosenonjaviste.testableandroidapps.v4;

import javax.inject.Inject;
import javax.inject.Singleton;

import it.cosenonjaviste.testableandroidapps.model.Post;

@Singleton
public class EmailSender {

    @Inject public EmailSender() {
    }

    public void sendEmail(Post p) {
        System.out.println("email " + p.getTitle() + " sent!");
    }
}
