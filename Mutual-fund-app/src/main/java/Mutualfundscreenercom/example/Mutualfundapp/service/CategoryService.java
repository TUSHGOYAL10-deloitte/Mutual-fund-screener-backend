package Mutualfundscreenercom.example.Mutualfundapp.service;

import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import Mutualfundscreenercom.example.Mutualfundapp.repository.CategoryRepository;
import Mutualfundscreenercom.example.Mutualfundapp.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MutualFundRepository mutualFundRepository;

    public List<Category> getAllCategoryService() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categoryList::add);
        return categoryList;
    }

    public ResponseEntity<?> getCategoryByIdService(Integer categoryId) {
        if (categoryId != null) {
            Category category = categoryRepository.getByCategoryId(categoryId);
            if (category != null) {
                return ResponseEntity.ok().body(category);
            }
        }
        return ResponseEntity.status(404).body("provide correct name");
    }

    public ResponseEntity<?> getCategoryByNameService(String categoryName) {
        if (categoryName != null) {
            Category category = categoryRepository.getByName(categoryName);
            if (category != null) {
                return ResponseEntity.ok().body(category);
            }
        }
        return ResponseEntity.status(404).body("provide correct name");
    }

    public ResponseEntity<?> addCategoryService(Category category) {
        if (category != null) {
            categoryRepository.save(category);
            return ResponseEntity.ok().body("added category successfully!");
        } else {
            return ResponseEntity.status(404).body("category provided is not valid");
        }
    }

    public ResponseEntity<?> updateCategoryService(Integer categoryId, Category category) {
        if (category != null) {
            Category fetchCategory = categoryRepository.getByCategoryId(categoryId);
            if (fetchCategory != null) {
                category.setCategoryId(categoryId);
                categoryRepository.save(category);
                return ResponseEntity.ok().body("Successfully updated Category");
            } else {
                return ResponseEntity.status(404).body("category does not exist!");
            }
        } else {
            return ResponseEntity.status(404).body("Not found this category");
        }
    }

    public ResponseEntity<?> addMFundToCategoryService(Integer mutualFundId, Integer categoryId) {
        Category category = categoryRepository.getByCategoryId(categoryId);
        MutualFund mutualFund = mutualFundRepository.getById(mutualFundId);
        if (category != null && mutualFund != null) {
            List<MutualFund> mutualFunds = new ArrayList<>(category.getMutualFunds());
            mutualFunds.add(mutualFund);
            category.getMutualFunds().clear();
            category.setMutualFunds(mutualFunds);
            System.out.println(mutualFund);
            System.out.println(mutualFunds);
            System.out.println(category.getMutualFunds());
            categoryRepository.save(category);
            return ResponseEntity.ok().body(categoryRepository.getByCategoryId(categoryId));
        } else {
            return ResponseEntity.status(404).body("cannot add non existing mutual fund or category!");
        }
    }
}
