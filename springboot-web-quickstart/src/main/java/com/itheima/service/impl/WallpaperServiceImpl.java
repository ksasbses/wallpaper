package com.itheima.service.impl;


import com.itheima.mapper.WallpaperMapper;
import com.itheima.pojo.Wallpaper;
import com.itheima.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallpaperServiceImpl implements WallpaperService {

    @Autowired
    private WallpaperMapper  wallpaperMapper;

    @Override
    public List<Wallpaper> list() {
        return wallpaperMapper.List();
    }

    @Override
    public void delete(Integer id) {
        wallpaperMapper.deleteById(id);
    }

    @Override
    public void add(Wallpaper wallpaper) {
        wallpaperMapper.insert(wallpaper);
    }

    @Override
    public List<Wallpaper> querySearch(String keyword) {
        return wallpaperMapper.querySearch(keyword);
    }

    @Override
    public List<Wallpaper> categoryList(Integer categoryid) {
        return wallpaperMapper.categoryList(categoryid);
    }


}
