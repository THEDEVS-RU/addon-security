package ru.thedevs.security;

import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securitydata.entity.RoleAssignmentEntity;

@ResourceRole(name = "Роли:чтение", code = RoleAssignmentRoleRead.CODE)
public interface RoleAssignmentRoleRead {

    String CODE = "role-assignment-base-access-read";

    @EntityPolicy(entityClass = RoleAssignmentEntity.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = RoleAssignmentEntity.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)

    void baseRoleAssignmentReadAccess();
}
