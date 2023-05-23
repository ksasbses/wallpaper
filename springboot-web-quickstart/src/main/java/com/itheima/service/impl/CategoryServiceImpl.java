package com.itheima.service.impl;

import com.itheima.mapper.CategoryMapper;
import com.itheima.pojo.Category;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询全部类别
     * @return
     */
    @Override
    public List<Category> classesList() {
        return categoryMapper.classesList();
    }

    /**
     * 新增类别
     * @param category
     */
    @Override
    public void classesAdd(Category category) {
        categoryMapper.classesinsert(category);
    }

    /**
     * 删除类别
     * @param id
     */
    @Override
    public void delClasses(Integer id) {
        categoryMapper.deleteClasses(id);
        categoryMapper.delCategory(id);

    }

}
