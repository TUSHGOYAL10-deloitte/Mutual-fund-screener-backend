package Mutualfundscreenercom.example.Mutualfundapp.controller;

import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import Mutualfundscreenercom.example.Mutualfundapp.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "/api/all-category",method = RequestMethod.GET)
    public List<Category> getCategory(){
        return categoryService.getAllCategory();
    }
    @RequestMapping(value = "/api/category/{category_id}",method = RequestMethod.GET)
    public Category getCategoryByid(@PathVariable("category_id") int category_id){
        return categoryService.getCategory(category_id);
    }
    @RequestMapping(value = "/api/createCat",method = RequestMethod.POST)
    public Category createCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @RequestMapping(value = "/api/updateCat",method = RequestMethod.PUT)
    public Category updateCat(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @RequestMapping(value = "/api/addMutualFund/{category_id}/category",method = RequestMethod.POST)
    public MutualFund updateMFs(@PathVariable("category_id") int category_id, @RequestBody MutualFund mutualFund){
        return categoryService.update(category_id,mutualFund);
    }
//    @RequestMapping(value = "/api/getCategory",method = RequestMethod.GET)
//    public Category getCategoryMF(@PathVariable("category_id") int category_id){
//        return categoryService.mutualFundCategory(category_id);
//    }

}
