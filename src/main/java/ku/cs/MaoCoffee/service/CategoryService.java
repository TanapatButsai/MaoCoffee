package ku.cs.MaoCoffee.service;

import ku.cs.MaoCoffee.entity.Category;
import ku.cs.MaoCoffee.model.CategoryRequest;
import ku.cs.MaoCoffee.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ModelMapper modelMapper;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public void createCategory(CategoryRequest request) {
        Category record = modelMapper.map(request, Category.class);
        categoryRepository.save(record);
    }
}

