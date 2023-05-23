package com.itheima.mapper;

import com.itheima.pojo.Administrator;
import com.itheima.pojo.User;
import com.itheima.pojo.UserCollect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface UserMapper {
    /**
     * 添加收藏
     * @param id
     * @param w_id
     */
    @Insert("insert into collection(name,url,collect_id) select wallpaper.name,wallpaper.url,user.id from wallpaper,user where user.id=#{id} and wallpaper.id=#{w_id}")
    void addFavorit(Integer id, Integer w_id);

    /**
     * 取消收藏
     * @param id
     */
    @Delete("delete from collection where id =#{id}")
    void cancel(Integer id);

    /**
     * 查询用户收藏
     * @param id
     * @return
     */
    @Select("select * from collection where collect_id=#{id}")
    List<UserCollect> queryByid(Integer id);

    /**
     * 查询用户是否存在
     * @param user
     * @return
     */
    @Select("select * from user where user_name = #{user_name} and user_password = #{user_password}")
    User getByUsernameAndPassword(User user);

    /**
     * 新增用户
     * @param user
     */
    @Insert("insert into user(user_name, user_password, age, image) values(#{user_name},#{user_password},#{age},#{image})")
    void adduser(User user);

    /**
     * 查询管理员
     * @param administrator
     * @return
     */
    @Select("select * from administrator where name = #{name} and password = #{password}")
    Administrator getByAdminNameAndPassword(Administrator administrator);

    /**
     * 查询用户
     * @return
     */
    @Select("select * from user")
    List<User> queryUserList();

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delByidUser(Integer id);
}
