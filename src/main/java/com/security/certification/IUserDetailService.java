package com.security.certification;

import com.security.config.RolePermissionDto;
import com.security.config.UserDto;
import com.security.dao.UserDao;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserDetailService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDto userDto = userDao.findByName(s);
        RolePermissionDto rolePermissionDto = userDao.selectPermissionByUserName(s);
//        /**
//         * 将 rolePermissionDto 转成数组
//         */
//        String[] authoritieArrays = new String[rolePermissionDto.size()];
//        rolePermissionDto.toArray(authoritieArrays);
        if(userDto==null){
            return null;
        }
        if(rolePermissionDto==null){
            return null;
        }
        UserDetails userDetails = User.withUsername(userDto.getUserName()).password(userDto.getPassword()).authorities(rolePermissionDto.getAuthority()).build();
        return userDetails;
    }
}
