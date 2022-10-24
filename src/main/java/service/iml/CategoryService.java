package service.iml;

import dao.ICategoryDAO;
import dao.iml.CategoryDAO;
import model.CategoryModel;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    private ICategoryDAO categoryDAO;
    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public CategoryModel findOne(Long id) {
        return categoryDAO.findOne(id);
    }
}
