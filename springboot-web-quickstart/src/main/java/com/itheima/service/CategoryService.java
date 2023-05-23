package com.itheima.service;

import com.itheima.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> classesList();

    void classesAdd(Category category);

    void delClasses(Integer id);

}
