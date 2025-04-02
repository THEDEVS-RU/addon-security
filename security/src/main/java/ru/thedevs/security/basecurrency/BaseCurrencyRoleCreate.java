package ru.thedevs.security.basecurrency;

import ru.thedevs.entity.Currency;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Валюта:создание", code = BaseCurrencyRoleCreate.CODE)
public interface BaseCurrencyRoleCreate extends BaseCurrencyRoleEdit {

    String CODE = "base-currency-create";

    @EntityPolicy(entityClass = Currency.class, actions = {EntityPolicyAction.CREATE})
    void baseCurrencyRoleCreate();
}
