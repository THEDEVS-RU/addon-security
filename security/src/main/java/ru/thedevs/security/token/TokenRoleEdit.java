package ru.thedevs.security.token;

import ru.thedevs.entities.Token;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Токен:редактирование", code = TokenRoleEdit.CODE)
public interface TokenRoleEdit extends TokenRoleRead {

    String CODE = "token-edit";

    @EntityPolicy(entityClass = Token.class, actions = {EntityPolicyAction.UPDATE})
    @EntityAttributePolicy(entityClass = Token.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)

    void tokenRole();
}