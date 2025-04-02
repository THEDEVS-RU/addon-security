package ru.thedevs.security.service;

import ru.thedevs.entity.BaseUser;
import ru.thedevs.entity.Phone;
import io.jmix.core.FetchPlan;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.security.role.assignment.RoleAssignmentRoleType;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityUtilsBean implements ISecurityUtilsBean {
  @Autowired
  private UnconstrainedDataManager dataManager;

  /**
   * Простой поиск телефона, если не существует, тогда вернет новый, без сохранения
   *
   * @param phoneLong Телефон лонг
   * @param fetchName фетчплан
   * @return сущность телефона
   */
  public Phone getPhone(Long phoneLong, String fetchName) {
    if (phoneLong == null){
      return null;
    }
    Phone phone = searchPhoneExist(phoneLong, fetchName);
    if (phone == null) {
      phone = dataManager.create(Phone.class);
      phone.setNumber(phoneLong);
    }
    return phone;
  }

  public RoleAssignmentEntity createRoleAssignment(BaseUser baseUser, String roleCode) {
    RoleAssignmentEntity roleAssignmentEntity = dataManager.create(RoleAssignmentEntity.class);
    roleAssignmentEntity.setRoleCode(roleCode);
    roleAssignmentEntity.setUsername(baseUser.getUsername());
    roleAssignmentEntity.setRoleType(RoleAssignmentRoleType.RESOURCE);
    return roleAssignmentEntity;
  }

  private Phone searchPhoneExist(Long phoneLong, String fetchName) {
    return dataManager.load(Phone.class).query("e.number = :curNumber")
         .parameter("curNumber", phoneLong)
         .fetchPlan(fetchName)
         .optional().orElse(null);
  }

  public List<RoleAssignmentEntity> getRoles(String user) {
    return dataManager.load(RoleAssignmentEntity.class)
         .query("e.username = :username")
         .parameter("username", user)
         .joinTransaction(false)
         .fetchPlan(FetchPlan.BASE)
         .list();
  }
}