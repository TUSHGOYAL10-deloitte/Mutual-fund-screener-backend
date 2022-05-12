package Mutualfundscreenercom.example.Mutualfundapp.controller;

import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import Mutualfundscreenercom.example.Mutualfundapp.service.CategoryService;
import Mutualfundscreenercom.example.Mutualfundapp.service.MutualFundService;
import Mutualfundscreenercom.example.Mutualfundapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MutualFundService mutualFundService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/createMF", method = RequestMethod.POST)
    public ResponseEntity<?> createMutualFundController(@RequestBody MutualFund mutualFund) {
        System.out.println("create end point");
        return mutualFundService.addMutualFundService(mutualFund);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/updateMF", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMutualFundController(@RequestBody MutualFund mutualFund) {
        return mutualFundService.updateMutualFundService(mutualFund);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    public ResponseEntity<?> addCategoryController(@RequestBody Category[] category) {
        return categoryService.addCategoryService(category);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/category/update/{categoryId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCategoryController(@PathVariable Integer categoryId, @RequestBody Category category) {
        return categoryService.updateCategoryService(categoryId, category);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/addMutualFund/{mutualFundId}/category/{categoryId}", method = RequestMethod.POST)
    public ResponseEntity<?> addMutualFundToCategoryController(@PathVariable("mutualFundId") Integer mutualFundId,
                                                               @PathVariable("categoryId") Integer categoryId) {
        return categoryService.addMutualFundToCategoryService(mutualFundId, categoryId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete-account/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserAccountController(@PathVariable Integer userId) {
        return userService.deleteAccountService(userId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete-Mutual-Fund/{mutualFundId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMutualFundController(@PathVariable Integer mutualFundId) {
        return mutualFundService.deleteMutualFundService(mutualFundId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/removeMutualFund/{mutualFundId}/category/{categoryId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeMutualFundToCategoryController(@PathVariable("mutualFundId") Integer mutualFundId,
                                                                  @PathVariable("categoryId") Integer categoryId) {
        return categoryService.removeMutualFundFromCategoryService(mutualFundId, categoryId);
    }
}
