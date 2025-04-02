package ru.thedevs.security.rowlevel;

import ru.thedevs.entity.Unit;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "Can see only Unit created by my tenant", code = CreatedByMyTenantUnitRole.CODE)
public interface CreatedByMyTenantUnitRole {
    String CODE = "created-by-my-tenant-unit-role";

    @JpqlRowLevelPolicy(
         entityClass = Unit.class,
         where = "{E}.tenant IN (SELECT t.tenantId FROM mten_Tenant t WHERE t.createdBy = :current_user_username)")
    void unit();
}