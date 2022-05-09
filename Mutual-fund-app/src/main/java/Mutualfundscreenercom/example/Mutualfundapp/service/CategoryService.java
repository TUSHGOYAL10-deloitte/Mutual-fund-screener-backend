package Mutualfundscreenercom.example.Mutualfundapp.service;

import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import Mutualfundscreenercom.example.Mutualfundapp.repository.CategoryRepository;
import Mutualfundscreenercom.example.Mutualfundapp.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MutualFundRepository mutualFundRepository;


    public List<MutualFund> getMutualFunds(){
        return mutualFundRepository.findAll();
    }
    public Category update(int category_id, ParserClass parserClass){
//        Category category  = categoryRepository.getById(category_id);
//        List<MutualFund> mf=category.getMutualFunds();
//        mf.add(mutualFund);
////        category.setMutualFunds(mf);
//        List<MutualFund> currMutualFundList=category.getMutualFunds();
//        for(MutualFund i:mf){
//            currMutualFundList.add(i);
//        }
//        category.setMutualFunds(currMutualFundList);
//
//        return categoryRepository.save(category);
        System.out.println(parserClass);
        return categoryRepository.getById(1);

    }


//    public Category mutualFundCategory(int category_id){
//        List<MutualFund> mutualFunds=mutualFundRepository.findAll();
//        Category category=categoryRepository.findById(category_id).get();
//        Set<MutualFund> set=new HashSet<>();
//        for(MutualFund i:mutualFunds){
//            set.add(i);
//        }
//        category.setMutualFunds(set);
//        return category;
//
//    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category getCategory(int category_id){
        return categoryRepository.getById(category_id);
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }
}
