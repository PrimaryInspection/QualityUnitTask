package ua.mishko.training.webhosting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mishko.training.webhosting.domain.SubCategory;
import ua.mishko.training.webhosting.repository.SubCategoryRepository;
import ua.mishko.training.webhosting.service.SubCategoryService;

import java.util.List;

@Service
public class SubCategoryServiceImplementation implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImplementation(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public List<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }
}
