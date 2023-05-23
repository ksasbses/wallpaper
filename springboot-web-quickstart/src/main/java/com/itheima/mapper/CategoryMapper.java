package com.itheima.mapper;

import com.itheima.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 查询全部类别
     * @return
     */
    @Select("select * from category")
    List<Category> classesList();

    /**
     * 新增类别
     * @param category
     */
    @Insert("insert into category(name) values(#{name})")
    void classesinsert(Category category);

    /**
     * 根据id删除类别
     * @param id
     */
    @Delete("delete wallpaper,category from wallpaper left join category on wallpaper.categoryid = category.id  where wallpaper.categoryid=#{id}")
    void deleteClasses(Integer id);

    @Delete("delete from category where id = #{id}")
    void delCategory(Integer id);
}
