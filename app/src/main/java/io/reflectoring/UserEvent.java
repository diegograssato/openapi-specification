package io.reflectoring;

import io.reflectoring.model.User;
import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

    private static final long serialVersionUID = -2680668406815551230L;
    private User payload;

    public UserEvent(Object source, User payload) {
        super(source);
        this.payload = payload;
    }
    public User getPayload() {
        return this.payload;
    }

}
