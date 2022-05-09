//package Mutualfundscreenercom.example.Mutualfundapp.controller;
//
//import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
//import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
//import Mutualfundscreenercom.example.Mutualfundapp.service.MutualFundService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class MutualFundController {
//    @Autowired
//    MutualFundService mutualFundService;
//
//    @RequestMapping(value = "/api/all-mutualfunds",method = RequestMethod.GET)
//    public List<MutualFund> getFunds(){
//        return mutualFundService.getAllMutualFunds();
//    }
//    @RequestMapping(value = "/api/mutualfunds/{id}",method = RequestMethod.GET)
//   public MutualFund getFundByid(@PathVariable("id") int id){
//        return mutualFundService.getMutualFund(id);
//    }
//    @RequestMapping(value = "/api/createMF",method = RequestMethod.POST)
//    public MutualFund createMF(@RequestBody MutualFund mutualFund){
//        return mutualFundService.addMutualFund(mutualFund);
//    }
//
//    @RequestMapping(value = "/api/updateMF",method = RequestMethod.PUT)
//    public MutualFund updateMF(@RequestBody MutualFund mutualFund){
//        return mutualFundService.updateMutualFund(mutualFund);
//    }
////    @RequestMapping(value="/api/mutualFund/{id}/category",method = RequestMethod.POST)
////    public Category updateCategory(@RequestBody Category category, @PathVariable("id") int id){
////        return mutualFundService.update(id,category);
////
////    }
//}
