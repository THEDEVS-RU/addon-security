package ru.thedevs.security.basecurrency;

import ru.thedevs.entity.Currency;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Валюта:удаление", code = BaseCurrencyRoleDelete.CODE)
public interface BaseCurrencyRoleDelete extends BaseCurrencyRoleRead {

    String CODE = "base-currency-delete";

    @EntityPolicy(entityClass = Currency.class, actions = {EntityPolicyAction.DELETE})
    void baseCurrencyRoleDelete();
}
