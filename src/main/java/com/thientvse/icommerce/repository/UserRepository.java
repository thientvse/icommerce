package com.thientvse.icommerce.repository;

import com.thientvse.icommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(long userId);
}
