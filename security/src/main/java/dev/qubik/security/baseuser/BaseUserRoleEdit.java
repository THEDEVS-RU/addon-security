package dev.qubik.security.baseuser;

import dev.qubik.entity.BaseUser;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Пользователь:редактирование", code = BaseUserRoleEdit.CODE)
public interface BaseUserRoleEdit extends BaseUserRoleRead {

    String CODE = "base-user-edit";

    @EntityPolicy(entityClass = BaseUser.class, actions = {EntityPolicyAction.UPDATE})
    @EntityAttributePolicy(entityClass = BaseUser.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @ViewPolicy(viewIds = {"changePasswordView", "resetPasswordView"})
    void baseUserRoleEdit();
}
