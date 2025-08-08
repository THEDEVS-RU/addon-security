package ru.thedevs.security.basecurrency;

import ru.thedevs.entities.Currency;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Валюта:редактирование", code = BaseCurrencyRoleEdit.CODE)
public interface BaseCurrencyRoleEdit extends BaseCurrencyRoleRead {

    String CODE = "base-currency-edit";

    @EntityPolicy(entityClass = Currency.class, actions = {EntityPolicyAction.UPDATE})
    @EntityAttributePolicy(entityClass = Currency.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)

    void baseCurrencyRoleEdit();
}
