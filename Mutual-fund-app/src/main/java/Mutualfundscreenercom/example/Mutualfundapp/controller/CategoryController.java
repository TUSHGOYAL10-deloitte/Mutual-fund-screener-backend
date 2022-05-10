package Mutualfundscreenercom.example.Mutualfundapp.controller;

import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import Mutualfundscreenercom.example.Mutualfundapp.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/all-category", method = RequestMethod.GET)
    public List<Category> getCategory() {
        return categoryService.getAllCategoryService();
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryByIdController(@PathVariable Integer categoryId) {
        return categoryService.getCategoryByIdService(categoryId);
    }

    @RequestMapping(value = "/{categoryName}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryByNameController(@PathVariable String categoryName) {
        return categoryService.getCategoryByNameService(categoryName);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createCategoryController(@RequestBody Category category) {
        System.out.println(category);
        return categoryService.addCategoryService(category);
    }

    @RequestMapping(value = "/updateCat", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCategoryController(@PathVariable Integer categoryId, @RequestBody Category category) {
        return categoryService.updateCategoryService(categoryId, category);
    }

    @RequestMapping(value = "/addMutualFund/{mutualFundId}/category/{categoryId}", method = RequestMethod.POST)
    public ResponseEntity<?> addMutualFundToCategoryController(@PathVariable("mutualFundId") Integer mutualFundId,
                                                               @PathVariable("categoryId") Integer categoryId) {
        return categoryService.addMFundToCategoryService(mutualFundId, categoryId);
    }

}
