package com.security.dao;

import com.security.config.RolePermissionDto;
import com.security.config.UserDto;
import com.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    UserDto findByName(String name);
    UserDto findByNameAndPws(String name,String pws);
    RolePermissionDto selectPermissionByUserName(String name);
}
