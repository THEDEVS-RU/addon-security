package dev.qubik.security.rowlevel;

import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "CreatedByMeToken", code = CreatedByMeTokenRole.CODE)
public interface CreatedByMeTokenRole {
  String CODE = "created-by-me-token";

}