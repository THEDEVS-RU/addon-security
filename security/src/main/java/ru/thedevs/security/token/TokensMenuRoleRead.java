package ru.thedevs.security.token;

import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;
import ru.thedevs.entity.Token;

@ResourceRole(name = "Токены в меню:чтение", code = TokensMenuRoleRead.CODE)
public interface TokensMenuRoleRead {

    String CODE = "tokens-menu-read";

    @MenuPolicy(menuIds = "Token.list")
    void tokenRole();
}