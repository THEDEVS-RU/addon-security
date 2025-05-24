package ru.thedevs.security.token;

import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;
import ru.thedevs.entity.Token;

@ResourceRole(name = "Токены:чтение", code = TokensRoleRead.CODE)
public interface TokensRoleRead {

    String CODE = "tokens-read";

    @EntityPolicy(entityClass = Token.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = Token.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)

    @ViewPolicy(viewIds = {"Token.list"})
    void tokenRole();
}