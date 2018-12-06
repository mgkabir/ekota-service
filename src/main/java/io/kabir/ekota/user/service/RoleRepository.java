package io.kabir.ekota.user.service;

import io.kabir.ekota.user.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
