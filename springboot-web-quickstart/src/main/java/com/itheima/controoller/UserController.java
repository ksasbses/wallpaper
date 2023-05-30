package com.itheima.controoller;

import com.itheima.pojo.*;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加收藏
     * @param id 用户id
     * @param w_id 壁纸id
     */
    @PostMapping("/user/collect")
    public Result collect(Integer id ,Integer w_id){
        log.info("添加收藏成功：{},{}",id,w_id);
        //调用service
        userService.collect(id,w_id);
        return Result.success();
    }

    /**
     * 取消收藏
     * @param id
     */
    @DeleteMapping("/user/cancel")
    public Result cancelFavorite(Integer id){
        log.info("取消收藏成功：{}",id);
        //调用service
        userService.cancelFavorite(id);
        return Result.success();
    }

    /**
     * 查询用户的收藏
     * @param id
     */
    @GetMapping("/user/collectall")
    public Result queryCollection(Integer id){
        log.info("查询成功,用户id：{}",id);
        //调用service
        List<UserCollect> collectList = userService.queryCollection(id);
        return Result.success(collectList);
    }

    /**
     * 用户注册
     * @param user
     */
    @PostMapping("/user/register")
    public Result register(@RequestBody User user){
        log.info("用户注册：{}",user);
        //调用service
        userService.registerv(user);
        return Result.success();

    }

    /**
     * 查询全部用户
     */
    @GetMapping("/queryuser")
    public Result queryUser(){
        log.info("查询全部用户");
        //调用service
        List<User> userList = userService.queryUser();
        return Result.success(userList);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @DeleteMapping("/deluser/{id}")
    public Result delUser(@PathVariable Integer id){
        log.info("根据id删除用户：{}", id);
        //调用service
        userService.delUser(id);
        return Result.success();
    }
    /**
     * 登录
     * @param user
     */
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        log.info("用户登录：{}",user);
        //调用service
        User u = userService.login(user);
//        log.info(u.getImage());
        //登录成功，生成令牌，下发令牌
        if (u !=  null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("user_name",user.getUser_name());
            claims.put("image",u.getImage());
            Object jwt = JwtUtils.generateJwt(claims);
            claims.put("jwt",jwt);
            return Result.success(claims);
        }
        return u != null?Result.success():Result.error("用户名或者密码错误");
    }

    /**
     * 管理员登陆
     * @param administrator
     */
    @PostMapping("/administratorlogin")
    public Object AdministratorLogin(@RequestBody Administrator administrator){
        log.info("管理员登录：{}",administrator);
        Administrator a = userService.administratorlogin(administrator);

        //登录成功，生成令牌，下发令牌
        if (a !=  null){
            Map<String,Object> admin = new HashMap<>();
            admin.put("id",a.getId());
            admin.put("user_name",a.getName());

            Object jwt = JwtUtils.generateJwt(admin);
            return Result.success(jwt);

        }
        return a != null?Result.success():Result.error("用户名或者密码错误");
    }



}
