package ru.thedevs.security.rowlevel;

import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "Может видеть только пользователей, созданных данным аккаунтом", code = CreatedByMeUserRole.CODE)
public interface CreatedByMeUserRole {
    String CODE = "created-by-me-user-role";

}