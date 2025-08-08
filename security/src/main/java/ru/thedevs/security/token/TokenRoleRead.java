package ru.thedevs.security.token;

import ru.thedevs.entities.Token;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Токен:чтение", code = TokenRoleRead.CODE)
public interface TokenRoleRead extends TokensRoleRead {

    String CODE = "token-read";

    @ViewPolicy(viewIds = {"Token.detail"})
    void tokenRole();
}