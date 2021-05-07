package io.reflectoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class UserListener implements ApplicationListener<UserEvent> {

    @Autowired
    UiidRepository uiidRepository;
    @Override
    public void onApplicationEvent(UserEvent event) {
//        try {
//
//            TimeUnit.SECONDS.sleep(120);
            System.out.println(event);

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(event.getPayload().getId() + ": " + new Date());
    }

    @EventListener
    public void handleValidateUiidEvent(UserEvent event) {

//        try {
//            System.out.println("======================================");
//            Uuid uuid = uiidRepository.get();
//            System.out.println(uuid.uuid);
//            event.getPayload().setPassword(uuid.uuid);
//
//            TimeUnit.SECONDS.sleep(20);
//
//            System.out.println(event);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(event.getPayload().getId() + ": " + new Date());
        ExecutorService pool = Executors.newCachedThreadPool();
        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("======================================");
                Uuid uuid = uiidRepository.get();
                System.out.println(uuid.uuid);
                event.getPayload().setPassword(uuid.uuid);
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(event.getPayload().getId() + ": " + new Date());
        }, pool);


    }

}