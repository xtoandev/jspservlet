package dao;

import model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();
    CategoryModel findOne(Long id);
}
