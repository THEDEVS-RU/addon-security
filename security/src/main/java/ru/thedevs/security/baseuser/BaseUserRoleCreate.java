package ru.thedevs.security.baseuser;

import ru.thedevs.entity.BaseUser;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Пользователь:создание", code = BaseUserRoleCreate.CODE)
public interface BaseUserRoleCreate extends BaseUserRoleEdit {

    String CODE = "base-user-create";

    @EntityPolicy(entityClass = BaseUser.class, actions = {EntityPolicyAction.CREATE})
    void baseUserRoleCreate();
}
