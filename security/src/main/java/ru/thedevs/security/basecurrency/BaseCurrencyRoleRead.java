package ru.thedevs.security.basecurrency;

import ru.thedevs.entity.Currency;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Валюта:чтение", code = BaseCurrencyRoleRead.CODE)
public interface BaseCurrencyRoleRead {

    String CODE = "base-currency-read";

    @EntityPolicy(entityClass = Currency.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = Currency.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)

    @EntityPolicy(entityClass = Currency.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = Currency.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)

    @ViewPolicy(viewIds = {"Currency.detail", "Currency.list"})
    void baseCurrencyRoleRead();
}
