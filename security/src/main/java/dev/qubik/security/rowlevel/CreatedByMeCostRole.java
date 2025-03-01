package dev.qubik.security.rowlevel;

import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "Может видеть только отчеты, загруженные данным аккаунтом", code = CreatedByMeCostRole.CODE)
public interface CreatedByMeCostRole {
  String CODE = "created-by-me-cost-role";

//    @JpqlRowLevelPolicy(
//         entityClass = CostStatistics.class,
//         where = "{E}.createdBy = :current_user_username")
//    void cost();
}