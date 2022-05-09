//package Mutualfundscreenercom.example.Mutualfundapp.service;
//
//import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
//import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
//import Mutualfundscreenercom.example.Mutualfundapp.repository.CategoryRepository;
//import Mutualfundscreenercom.example.Mutualfundapp.repository.MutualFundRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class MutualFundService {
//    @Autowired
//    MutualFundRepository mutualFundRepository;
//
//    @Autowired
//    CategoryRepository categoryRepository;
//
////
////    public Category update(int id, Category category){
////        MutualFund mutualFund = mutualFundRepository.findById(id).get();
////        List<Category> cat=mutualFund.getCategory();
////        cat.add(category);
////        mutualFund.setCategory(cat);
////        mutualFundRepository.save(mutualFund);
////        return category;
////
////
////    }
//
//
//    public List<MutualFund> getAllMutualFunds(){
//        return mutualFundRepository.findAll();
//    }
//
//    public MutualFund getMutualFund(int id){
//        return mutualFundRepository.getById(id);
//    }
//
//    public MutualFund addMutualFund(MutualFund mutualFund){
//        return mutualFundRepository.save(mutualFund);
//    }
//    public MutualFund updateMutualFund(MutualFund mutualFund){
//        return mutualFundRepository.save(mutualFund);
//    }
//
//
//}
