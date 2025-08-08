package ru.thedevs.security.token;

import ru.thedevs.entities.Token;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Токен:удаление", code = TokenRoleDelete.CODE)
public interface TokenRoleDelete extends TokenRoleRead {

    String CODE = "token-delete";

    @EntityPolicy(entityClass = Token.class, actions = {EntityPolicyAction.DELETE})
    void tokenRole();
}
