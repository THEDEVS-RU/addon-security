package dev.qubik.security.baseuser;

import dev.qubik.entity.BaseUser;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Пользователь:удаление", code = BaseUserRoleDelete.CODE)
public interface BaseUserRoleDelete extends BaseUserRoleRead {

    String CODE = "base-user-delete";

    @EntityPolicy(entityClass = BaseUser.class, actions = {EntityPolicyAction.DELETE})
    void baseUserRoleDelete();
}
