package dao.iml;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        String sql = "Select * From category ";

        List<CategoryModel> list = query(sql ,new CategoryMapper());
        return list;
    }

    @Override
    public CategoryModel findOne(Long id) {
        String sql = "Select * From category "
                +" where category.id = ?";
        List<CategoryModel> dstk = query(sql, new CategoryMapper(),id);
        return dstk.isEmpty() ? null : dstk.get(0);
    }
}
