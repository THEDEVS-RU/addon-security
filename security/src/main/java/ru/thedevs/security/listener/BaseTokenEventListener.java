package ru.thedevs.security.listener;

import ru.thedevs.entity.Token;
import ru.thedevs.security.service.IEncryptionService;
import io.jmix.core.event.EntityLoadingEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BaseTokenEventListener {
  @Autowired
  private IEncryptionService encryptionService;

  @EventListener
  public void onTokenLoading(EntityLoadingEvent<Token> event) {
    Token token = event.getEntity();
    String sensitive = encryptionService.decrypt(token.getToken());
    token.setToken(sensitive);
  }

  @EventListener
  public void onTokenSaving(EntitySavingEvent<Token> event) {
    Token token = event.getEntity();
    String encrypted = encryptionService.encrypt(token.getToken());
    token.setToken(encrypted);
  }
}