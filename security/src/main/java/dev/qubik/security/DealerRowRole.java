package dev.qubik.security;

import dev.qubik.entity.Unit;
import dev.qubik.security.rowlevel.CreatedByMeTokenRole;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "Ограничения для диллера", code = DealerRowRole.CODE)
public interface DealerRowRole extends CreatedByMeTokenRole {
    String CODE = "dealer-role";

    @JpqlRowLevelPolicy(
         entityClass = Unit.class,
         where = "{E}.createdBy = :current_user_username or ({E}.tenant is not null and {E}.tenant IN (SELECT t.tenantId FROM mten_Tenant t WHERE t.createdBy = :current_user_username))")
    void unit();

}