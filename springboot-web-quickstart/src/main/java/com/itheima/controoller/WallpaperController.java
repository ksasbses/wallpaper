package com.itheima.controoller;

import com.itheima.pojo.Result;
import com.itheima.pojo.Wallpaper;
import com.itheima.service.WallpaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class WallpaperController {
//    private static Logger log = LoggerFactory.getLogger(Wallpaper.class);
    @Autowired
    private WallpaperService wallpaperService;
    /**
     * 查询壁纸数据
     */
    //    @RequestMapping("/wallpapers")
    @GetMapping("/wallpapers/all")
    public Result list() {
        log.info("查询全部数据");

        //调用service查询壁纸数据
        List<Wallpaper> wallpaperList = wallpaperService.list();
        return Result.success(wallpaperList);
    }

    /**
     * 指定类别查询
     * @param categoryid
     */
    @GetMapping("/wallpapers/category")
    public Result categoryList(Integer categoryid) {
        log.info("查询指定数据");
        //调用service
        List<Wallpaper> wallpaperList = wallpaperService.categoryList(categoryid);
        return Result.success(wallpaperList);
    }

    /**
     * 搜索查询
     */
    @GetMapping("/wallpaper/search")
    public Result querySearch(String keyword) {
        log.info("查询指定数据");
        //调用service
        List<Wallpaper> querySearchList = wallpaperService.querySearch(keyword);
        return Result.success(querySearchList);
    }

    /**
     * 删除壁纸
     *
     */
    @DeleteMapping("/delwallpapers/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除壁纸：{}", id);
        //调用service删除壁纸
        wallpaperService.delete(id);
        return Result.success();
    }

    /**
     * 新增壁纸
     */
    @PostMapping("/wallpapers/add")
    public Result add(@RequestBody Wallpaper wallpaper) {
        log.info("新增壁纸：{}", wallpaper);
        //调用service新增壁纸
        wallpaperService.add(wallpaper);
        return Result.success();

    }
}
