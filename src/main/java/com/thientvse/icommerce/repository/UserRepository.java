package com.thientvse.icommerce.repository;

import com.thientvse.icommerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
