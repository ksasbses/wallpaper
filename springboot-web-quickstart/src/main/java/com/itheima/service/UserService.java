package com.itheima.service;


import com.itheima.pojo.Administrator;
import com.itheima.pojo.User;
import com.itheima.pojo.UserCollect;
import java.util.List;

public interface UserService {
    void collect(Integer id, Integer w_id);

    void cancelFavorite(Integer id);

    List<UserCollect> queryCollection(Integer id);

    User login(User user);

    void registerv(User user);

    Administrator administratorlogin(Administrator administrator);

    List<User> queryUser();

    void delUser(Integer id);
}
