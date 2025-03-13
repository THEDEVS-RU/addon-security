package dev.qubik.security;

import dev.qubik.entity.BaseUser;
import dev.qubik.entity.UnitsHistory;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import io.jmix.securityflowui.model.ResourceRoleModel;
import io.jmix.securityflowui.model.RowLevelRoleModel;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Администратор", code = AdminRole.CODE, scope = "UI")
public interface AdminRole extends FullUserRole {
    String CODE = "admin";

    @EntityPolicy(
         entityClass = BaseUser.class,
         actions = {EntityPolicyAction.ALL})
    @EntityPolicy(
         entityClass = UnitsHistory.class,
         actions = {EntityPolicyAction.READ})
    @EntityPolicy(
         entityClass = RoleAssignmentEntity.class,
         actions = {EntityPolicyAction.ALL})
    @EntityPolicy(
         entityClass = RowLevelRoleModel.class,
         actions = {EntityPolicyAction.ALL})
    @EntityPolicy(
         entityClass = ResourceRoleModel.class,
         actions = {EntityPolicyAction.ALL})
    void adminEntityAccess();

    @EntityAttributePolicy(
         entityClass = BaseUser.class, attributes = {"id", "username", "email", "password", "active", "units", "timeZoneId"},
         action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(
         entityClass = UnitsHistory.class, attributes = {"*"},
         action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(
         entityClass = ResourceRoleModel.class, attributes = "*",
         action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(
         entityClass = RowLevelRoleModel.class, attributes = "*",
         action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(
         entityClass = RoleAssignmentEntity.class, attributes = "*",
         action = EntityAttributePolicyAction.MODIFY)
    void adminEntityAttributeAccess();

    @MenuPolicy(menuIds = {"User.browse", "UnitsHistory.browse"})
        // "templateBrowse", "sendingMailbrowse",
    void adminMenuItemsAccess();

    @ViewPolicy(viewIds = {"UnitsHistory.browse",
         "User.browse", "ChangePasswordDialog", "User.edit", "sec_ResourceRoleModel.lookup", "sec_RowLevelRoleModel.lookup", "sec_RoleAssignmentScreen"})
    void adminScreenPolicyAccess(); // "emltmp_EmailTemplate.browse", "email_SendingMessage.browse", "emltmp_TemplateGroup.browse", "emltmp_TemplateBlock.browse", "ResendMessage", "emltmp_ReportEmailTemplate.edit", "emltmp_JsonEmailTemplate.edit", "emltmp_EmailTemplateSendScreen",
}
