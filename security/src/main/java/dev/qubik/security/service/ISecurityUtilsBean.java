package dev.qubik.security.service;

import dev.qubik.entity.BaseUser;
import dev.qubik.entity.Phone;
import io.jmix.securitydata.entity.RoleAssignmentEntity;

import java.util.List;

public interface ISecurityUtilsBean {

  List<RoleAssignmentEntity> getRoles(String user);

  RoleAssignmentEntity createRoleAssignment(BaseUser baseUser, String roleCode);

  public Phone getPhone(Long phoneLong, String fetchName);
}
