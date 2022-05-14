package Mutualfundscreenercom.example.Mutualfundapp.controller;

import Mutualfundscreenercom.example.Mutualfundapp.config.TokenProvider;
import Mutualfundscreenercom.example.Mutualfundapp.entities.Users;
import Mutualfundscreenercom.example.Mutualfundapp.extrabody.*;
import Mutualfundscreenercom.example.Mutualfundapp.repository.UserRepository;
import Mutualfundscreenercom.example.Mutualfundapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutual-fund")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
    public ResponseEntity<?> generateTokenController(@RequestBody LoginUser loginUser) throws AuthenticationException {
        System.out.println(loginUser);
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setJwtToken(token);
        Users users = userRepository.findByUsername(loginUser.getUsername());
        ReturnUserDetails returnUserDetails = new ReturnUserDetails(users.getUsername(),
                                                                    users.getEmail(),
                                                                    users.getIs_active(),
                                                                    users.getId());
        loginResponse.setReturnUserDetails(returnUserDetails);
        System.out.println(returnUserDetails);
        return ResponseEntity.ok(loginResponse);
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUserController(@RequestBody UserExtraBody user){
        return userService.saveUserService(user);
    }


    @RequestMapping(value="/activate-account/", method = RequestMethod.PUT)
    public ResponseEntity<?> activateUserController(@RequestBody UserExtraBody user) {
        return userService.verifyEmailService(user);
    }

    //add and delete mutual fund
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user/{userId}/add-mutualfund-to-watchlist/{mutualFundId}/",method = RequestMethod.POST)
    public ResponseEntity<?> addMutualFundToUserWishList(@PathVariable("mutualFundId") Long mutualFundId,@PathVariable("userId") Long userId){
        System.out.println(mutualFundId.intValue()+" "+userId);
//        return ResponseEntity.ok().body("ok");
        return  userService.addMutualFundToWatchList(userId,mutualFundId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/remove-mutual-fund/{userId}/fromuser/{mutualFundId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeMutualFundFromUserWishList(@PathVariable("mutualFundId") Long mutualFundId,@PathVariable("userId") Long userId){
        return userService.removeMutualFunFromUser(mutualFundId,userId);
    }

}