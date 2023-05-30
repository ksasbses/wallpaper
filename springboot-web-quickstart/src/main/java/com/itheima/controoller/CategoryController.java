package com.itheima.controoller;

import com.itheima.pojo.Category;
import com.itheima.pojo.Result;
import com.itheima.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    /**
     * 查询全部类别
     */
    @GetMapping("/category/all")
    public Result classesList() {
        log.info("查询全部类别");
        //调用service
        List<Category> categoryList = categoryService.classesList();
        return Result.success(categoryList);
    }
    /**
     * 新增类别
     */
    @PostMapping("/category/add")
    public Result classesAdd(@RequestBody Category category) {
        log.info("新增类别：{}", category);
        //调用service
        categoryService.classesAdd(category);
        return Result.success();
    }
    /**
     * 删除类别
     */
    @DeleteMapping("/delcategory/{id}")
    public Result delClasses(@PathVariable Integer id) {
        log.info("根据id删除类别：{}", id);
        //调用service删除壁纸
        categoryService.delClasses(id);
        return Result.success();
    }
}
