package ru.thedevs.security.token;

import ru.thedevs.entity.Token;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Токен:создание", code = TokenRoleCreate.CODE)
public interface TokenRoleCreate extends TokenRoleEdit {

    String CODE = "token-create";

    @EntityPolicy(entityClass = Token.class, actions = {EntityPolicyAction.CREATE})
    void tokenRole();
}
