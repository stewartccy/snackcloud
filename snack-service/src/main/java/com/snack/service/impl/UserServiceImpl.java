package com.snack.service.impl;

import com.snack.mapper.UsersMapper;
import com.snack.pojo.Users;
import com.snack.pojo.bo.UserBO;
import com.snack.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username",username);

        Users result = usersMapper.selectOneByExample(userExample);
        return result == null? false : true;
    }

    @Override
    public Users createUser(UserBO userBO) {
        return null;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        return null;
    }
}
