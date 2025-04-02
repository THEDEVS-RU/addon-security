package ru.thedevs.security.baseuser;

import ru.thedevs.entity.BaseUser;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Пользователь:чтение", code = BaseUserRoleRead.CODE)
public interface BaseUserRoleRead {

    String CODE = "base-user-read";

    @EntityPolicy(entityClass = BaseUser.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = BaseUser.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)

    @EntityPolicy(entityClass = BaseUser.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = BaseUser.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @ViewPolicy(viewIds = {"BaseUser.detail", "changePasswordView"})
    void baseUserRoleRead();
}
