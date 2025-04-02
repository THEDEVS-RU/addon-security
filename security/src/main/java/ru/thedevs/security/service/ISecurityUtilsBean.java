package ru.thedevs.security.service;

import ru.thedevs.entity.BaseUser;
import ru.thedevs.entity.Phone;
import io.jmix.securitydata.entity.RoleAssignmentEntity;

import java.util.List;

public interface ISecurityUtilsBean {

  List<RoleAssignmentEntity> getRoles(String user);

  RoleAssignmentEntity createRoleAssignment(BaseUser baseUser, String roleCode);

  public Phone getPhone(Long phoneLong, String fetchName);
}
