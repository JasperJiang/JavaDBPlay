package com.jasper.repository;

import com.jasper.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jjiang153 on 2017/5/4.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long>{

    UserEntity findFirstByUsernameAndPassword(String username,byte[] password);

}
