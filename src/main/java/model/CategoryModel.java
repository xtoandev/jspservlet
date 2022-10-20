package model;

import mapper.RowMapper;

public class CategoryModel extends RowMapper.AbstractModel {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryModel(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryModel() {
    }
}
