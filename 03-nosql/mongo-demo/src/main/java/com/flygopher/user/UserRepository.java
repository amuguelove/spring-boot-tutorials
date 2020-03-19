package com.flygopher.user;

import com.flygopher.common.BaseMongoRepository;
import com.flygopher.user.domain.User;

public interface UserRepository extends BaseMongoRepository<User, String> {

}
