package com.zwm.service.impl;

import com.zwm.mapper.UsersMapper;
import com.zwm.pojo.Users;
import com.zwm.service.UsersService;

public class UsersServiceImpl implements UsersService {
    public UsersMapper getUsersMapper() {
        return usersMapper;
    }

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    private UsersMapper usersMapper;
    @Override
    public Users login(Users users) {
        return usersMapper.selByUsersPwd(users);
    }
}
