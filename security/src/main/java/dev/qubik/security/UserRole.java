package dev.qubik.security;

import dev.qubik.entity.BaseUser;
import dev.qubik.entity.Unit;
import dev.qubik.entity.UnitCommand;
import dev.qubik.entity.UnitCommandResult;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;
import io.jmix.flowui.entity.filter.FilterCondition;
import io.jmix.flowui.entity.filter.GroupFilterCondition;
import io.jmix.flowuidata.entity.FilterConfiguration;


@ResourceRole(name = "Пользователь без возможности добавлять объекты", code = UserRole.CODE, scope = "UI")
public interface UserRole extends UiMinimalRole {
    String CODE = "user";

    @EntityPolicy(
         entityClass = BaseUser.class,
         actions = {EntityPolicyAction.READ})
    @EntityPolicy(
         entityClass = Unit.class,
         actions = {EntityPolicyAction.READ})
    @EntityPolicy(
         entityClass = FilterConfiguration.class,
         actions = {EntityPolicyAction.ALL})
    @EntityPolicy(
         entityClass = FilterCondition.class,
         actions = {EntityPolicyAction.ALL})
    @EntityPolicy(
         entityClass = GroupFilterCondition.class,
         actions = {EntityPolicyAction.ALL})
    @EntityPolicy(
         entityClass = UnitCommand.class,
         actions = {EntityPolicyAction.ALL})
    @EntityPolicy(
         entityClass = UnitCommandResult.class,
         actions = {EntityPolicyAction.READ})
    void userEntityAccess();

    @EntityAttributePolicy(
         entityClass = BaseUser.class, attributes = {"id", "username", "email", "password", "active", "units", "timeZoneId"},
         action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(
         entityClass = Unit.class, attributes = "*",
         action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(
         entityClass = FilterConfiguration.class, attributes = "*",
         action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(
         entityClass = FilterCondition.class, attributes = "*",
         action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(
         entityClass = GroupFilterCondition.class, attributes = "*",
         action = EntityAttributePolicyAction.MODIFY)
    void userEntityAttributeAccess();

    @MenuPolicy(menuIds = {"Unit.browse"})
    void userMenuItemsAccess();

    @ViewPolicy(viewIds = {"MainScreen", "Unit.browse", "Unit.edit", "LoginScreen", "selectValueDialog", "ui_AddConditionScreen", "ui_GroupFilterCondition.edit", "UnitPosition.browse", "UnitCommand.browse", "UnitCommandResult.browse"})
    void userScreenPoliceAccess();

    @SpecificPolicy(resources = {"ui.filter.modifyConfiguration"})
    void userSpecificAccess();
}
