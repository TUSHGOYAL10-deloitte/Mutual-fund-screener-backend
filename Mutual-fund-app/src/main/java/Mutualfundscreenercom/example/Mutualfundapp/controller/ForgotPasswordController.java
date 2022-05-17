//package Mutualfundscreenercom.example.Mutualfundapp.controller;
//
//import Mutualfundscreenercom.example.Mutualfundapp.service.UserService;
//import net.bytebuddy.utility.RandomString;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//public class ForgotPasswordController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/forgot_password")
//    public String processForgotPassword(HttpServletRequest request){
//        String email=request.getParameter("email");
//        String token= RandomString.make(64);
//
//        System.out.println(email);
//        System.out.println(token);
//        userService.updateResetPassword(token,email);
//        return "password updated succcefully";
//    }
//}
