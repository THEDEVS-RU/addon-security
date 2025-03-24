package dev.qubik.security;

import dev.qubik.entity.Unit;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Пользователь с возможностью добавлять объекты и смотреть расходы", code = FullUserRole.CODE, scope = "UI")
public interface FullUserRole extends UserRole {
    String CODE = "full-user";

    @EntityPolicy(
         entityClass = Unit.class,
         actions = {EntityPolicyAction.ALL})
    void userEntityAccess();

    @MenuPolicy(menuIds = {"UnitsHistory.browse"})
    void fullUserMenuItemsAccess();

    @EntityAttributePolicy(
         entityClass = Unit.class, attributes = "*",
         action = EntityAttributePolicyAction.MODIFY)
    void userEntityAttributeAccess();

    @ViewPolicy(viewIds = {"UnitsHistory.browse"})
    void fullUserScreenPoliceAccess();
}
