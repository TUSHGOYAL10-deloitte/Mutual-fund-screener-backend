//package Mutualfundscreenercom.example.Mutualfundapp.service;
//
//import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
//import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
//import Mutualfundscreenercom.example.Mutualfundapp.repository.CategoryRepository;
//import Mutualfundscreenercom.example.Mutualfundapp.repository.MutualFundRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CategoryService {
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @Autowired
//    MutualFundRepository mutualFundRepository;
//
//    public List<Category> getAllCategoryService() {
//        List<Category> categoryList = new ArrayList<>();
//        categoryRepository.findAll().iterator().forEachRemaining(categoryList::add);
//        return categoryList;
//    }
//
//    public ResponseEntity<?> getCategoryByIdService(Integer categoryId) {
//        if (categoryId != null && categoryRepository.existsById(categoryId)) {
//            Category category = categoryRepository.getByCategoryId(categoryId);
//            if (category.getIs_active()) {
//                return ResponseEntity.ok().body(category);
//            }
//        }
//        return ResponseEntity.status(404).body("provide correct name");
//    }
//
//    public ResponseEntity<?> getCategoryByNameService(String categoryName) {
//        if (categoryName != null && categoryRepository.existsByName(categoryName)) {
//            Category category = categoryRepository.getByName(categoryName);
//            if (category.getIs_active()) {
//                return ResponseEntity.ok().body(category);
//            }
//        }
//        return ResponseEntity.status(404).body("provide correct name");
//    }
//
//    public ResponseEntity<?> addCategoryService(Category[] categoryArray) {
//        if (categoryArray != null && categoryArray.length != 0) {
//            for(Category category : categoryArray) {
//                categoryRepository.save(category);
//            }
//            return ResponseEntity.ok().body("added category successfully!");
//        } else {
//            return ResponseEntity.status(404).body("category provided is not valid");
//        }
//    }
//
//    public ResponseEntity<?> updateCategoryService(Integer categoryId, Category category) {
//        if (category == null) {
//            return ResponseEntity.status(401).body("Provide a correct body!");
//        }
//        if (categoryRepository.existsById(categoryId)) {
//            return ResponseEntity.status(404).body("Not found this category");
//        }
//        Category fetchCategory = categoryRepository.getByCategoryId(categoryId);
//        if (!fetchCategory.getIs_active()) {
//            return ResponseEntity.status(404).body("Not found this category");
//        }
//        category.setCategoryId(categoryId);
//        categoryRepository.save(category);
//        return ResponseEntity.ok().body("Successfully updated Category");
//    }
//
//    public ResponseEntity<?> addMutualFundToCategoryService(Integer mutualFundId, Integer categoryId) {
//        if(!categoryRepository.existsById(categoryId) || !mutualFundRepository.existsById(mutualFundId)) {
//            return ResponseEntity.status(404).body("cannot add non existing mutual fund or category!");
//        }
//        Category category = categoryRepository.getByCategoryId(categoryId);
//        MutualFund mutualFund = mutualFundRepository.getById(mutualFundId);
//        if (!category.getIs_active() || !mutualFund.getIs_active()) {
//            return ResponseEntity.status(404).body("delete cannot be performed as it is non existing mutual fund or|and category!");
//        }
//        List<MutualFund> mutualFunds = new ArrayList<>(category.getMutualFunds());
//        mutualFunds.add(mutualFund);
//        category.getMutualFunds().clear();
//        category.setMutualFunds(mutualFunds);
//        categoryRepository.save(category);
//        return ResponseEntity.ok().body(categoryRepository.getByCategoryId(categoryId));
//    }
//
//    public ResponseEntity<?> removeMutualFundFromCategoryService(Integer mutualFundId, Integer categoryId) {
//        Category category = categoryRepository.getByCategoryId(categoryId);
//        MutualFund mutualFund = mutualFundRepository.getById(mutualFundId);
//
//        if (!categoryRepository.existsById(categoryId) || !mutualFundRepository.existsById(mutualFundId)) {
//            return ResponseEntity.status(404).body("cannot add non existing mutual fund or category!");
//        }
//
//        if (!category.getIs_active() || !mutualFund.getIs_active()) {
//            return ResponseEntity.status(404).body("remove route cannot add non existing mutual fund or category!");
//        }
//        List<MutualFund> mutualFunds = new ArrayList<>();
//        for (MutualFund mutualFundIt : category.getMutualFunds()) {
//            if (mutualFundIt == mutualFund) {
//                continue;
//            }
//            mutualFunds.add(mutualFundIt);
//        }
//        category.setMutualFunds(mutualFunds);
//        categoryRepository.save(category);
//        return ResponseEntity.ok().body(categoryRepository.getByCategoryId(categoryId));
//    }
//}
