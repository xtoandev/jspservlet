package mapper;


import model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CategoryMapper implements RowMapper<CategoryModel>{
    DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    @Override
    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel category = new CategoryModel();
        try {
            category.setId(rs.getLong("id"));
            category.setCategoryName(rs.getString("category_name"));
            category.setStatus(rs.getInt("status"));
            return category;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
