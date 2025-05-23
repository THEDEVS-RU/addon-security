package ru.thedevs.security.listener;

import io.jmix.core.event.EntityLoadingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.thedevs.entity.Token;
import ru.thedevs.entity.telegram.TelegramBot;
import ru.thedevs.security.service.IEncryptionService;

@Component("BotEventListener")
public class BotEventListener {
    @Autowired
    private IEncryptionService encryptionService;

    @EventListener
    public void onTokenLoading(EntityLoadingEvent<TelegramBot> event) {
        Token token = event.getEntity().getToken();
        String sensitive = encryptionService.decrypt(token.getToken());
        token.setToken(sensitive);
    }
}