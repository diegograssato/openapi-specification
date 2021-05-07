package io.reflectoring;

import io.reflectoring.api.UserApiDelegate;
import io.reflectoring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserApiDelegateImpl implements UserApiDelegate {

    private static final Logger logger = LoggerFactory.getLogger(UserApiDelegateImpl.class);

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        User user = new User();


        user.setId(123L);
        user.setFirstName("Petros");
        user.setLastName("S");
        user.setUsername(username);
        user.setEmail("petors.stergioulas94@gmail.com");
        user.setPassword("secret");
        user.setPhone("+123 4567890");
        user.setUserStatus(0);

        UserEvent userEvent = new UserEvent(this, user);

        logger.info(userEvent.getPayload().getPassword());

        publisher.publishEvent(userEvent);

        logger.info(userEvent.getPayload().getPassword());

        return ResponseEntity.ok(user);
    }
}
