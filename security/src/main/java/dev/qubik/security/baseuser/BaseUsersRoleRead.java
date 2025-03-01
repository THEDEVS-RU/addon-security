package dev.qubik.security.baseuser;

import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Пользователи:просмотр", code = BaseUsersRoleRead.CODE)
public interface BaseUsersRoleRead extends BaseUserRoleRead {

    String CODE = "base-users-read";

    @ViewPolicy(viewIds = {"BaseUser.list"})
    void baseUserRoleRead();
}
