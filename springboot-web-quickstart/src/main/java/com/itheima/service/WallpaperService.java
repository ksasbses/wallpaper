package com.itheima.service;

import com.itheima.pojo.Wallpaper;

import java.util.List;

public interface WallpaperService {
    /**
     * 查询壁纸数据
     * @return
     */
    List<Wallpaper> list();

    /**
     * 查询指定分类的壁纸
     * @return
     */
    List<Wallpaper> categoryList(Integer categoryid);
    /**
     * 删除壁纸
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增壁纸
     * @param wallpaper
     */
    void add(Wallpaper wallpaper);


    List<Wallpaper> querySearch(String keyword);
}
