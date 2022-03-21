package com.thientvse.icommerce.repository;

import java.util.Optional;

import com.thientvse.icommerce.model.ERole;
import com.thientvse.icommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
