package dev.qubik.security.rowlevel;

import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "Может видеть только телефоны, созданные данным аккаунтом(из импорта отчетов)", code = CreatedByMePhoneRole.CODE)
public interface CreatedByMePhoneRole {
  String CODE = "created-by-me-phone-role";

}