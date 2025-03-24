package dev.qubik.security;

import dev.qubik.entity.Unit;
import dev.qubik.security.rowlevel.CreatedByMeTokenRole;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.*;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@RowLevelRole(name = "Ограничения для диллера", code = DealerRowRole.CODE)
public interface DealerRowRole extends CreatedByMeTokenRole {
    String CODE = "dealer-role";

    @JpqlRowLevelPolicy(
         entityClass = Unit.class,
         where = "{E}.createdBy = :current_user_username or ({E}.tenant is not null and {E}.tenant IN (SELECT t.tenantId FROM mten_Tenant t WHERE t.createdBy = :current_user_username))")
    void unit();
    @EntityPolicy(entityName = "*", actions = {EntityPolicyAction.ALL})
    void dealerEntityAccess();

    @EntityAttributePolicy(entityName = "*", attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    void dealerEntityAttributeAccess();

    @MenuPolicy(menuIds = {"tenant-browse"})
    void dealerMenuItemsAccess();

    @ViewPolicy(viewIds = {"mten_Tenant.browse", "mten_Tenant.edit", "TenantSetting.edit"})
    void dealerScreenPolicyAccess();

    @SpecificPolicy(resources = "*")
    void dealerAccess();

}