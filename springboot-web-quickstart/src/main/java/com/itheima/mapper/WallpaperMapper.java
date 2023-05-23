package com.itheima.mapper;

import com.itheima.pojo.Wallpaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface WallpaperMapper {
    /**
     * 查询全部壁纸数据
     * @return
     */
    @Select("select * from wallpaper")
    List<Wallpaper> List();

    /**
     * 根据ID删除壁纸
     * @param id
     */
    @Delete("delete from wallpaper where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增壁纸
     * @param wallpaper
     */
    @Insert("insert into wallpaper(name,classify,url,categoryid) values(#{name},#{classify},#{url},#{categoryid})")
    void insert(Wallpaper wallpaper);
    /**
     * 查询指定分类的壁纸
     * @return
     */
    @Select("select * from wallpaper where categoryid = #{categoryid}")
    List<Wallpaper> categoryList(Integer categoryid);

    /**
     * 搜索查询
     * @param keyword
     * @return
     */
    @Select("select * from wallpaper where name like concat('%',#{keyword},'%')")
    List<Wallpaper> querySearch(String keyword);
}
