package com.itheima.service.impl;


import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Administrator;
import com.itheima.pojo.User;
import com.itheima.pojo.UserCollect;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加收藏
     * @param id
     * @param w_id
     */
    @Override
    public void collect(Integer id, Integer w_id) {
        userMapper.addFavorit(id,
                w_id);
    }

    /**
     * 取消收藏
     * @param id
     */
    @Override
    public void cancelFavorite(Integer id) {
        userMapper.cancel(id);
    }

    /**
     * 查询用户收藏
     *
     * @param id
     * @return
     */
    @Override
    public List<UserCollect> queryCollection(Integer id) {
        return userMapper.queryByid(id);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    /**
     * 用户注册
     * @param user
     */
    @Override
    public void registerv(User user) {
        userMapper.adduser(user);
    }

    @Override
    public Administrator administratorlogin(Administrator administrator) {
        return userMapper.getByAdminNameAndPassword(administrator);
    }

    @Override
    public List<User> queryUser() {
        return userMapper.queryUserList();
    }

    @Override
    public void delUser(Integer id) {
        userMapper.delByidUser(id);
    }
}
