package Mutualfundscreenercom.example.Mutualfundapp.controller;

import Mutualfundscreenercom.example.Mutualfundapp.config.TokenProvider;
import Mutualfundscreenercom.example.Mutualfundapp.entities.Users;
import Mutualfundscreenercom.example.Mutualfundapp.extrabody.AuthToken;
import Mutualfundscreenercom.example.Mutualfundapp.extrabody.UserExtraBody;
import Mutualfundscreenercom.example.Mutualfundapp.repository.UserRepository;
import Mutualfundscreenercom.example.Mutualfundapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> generateTokenController(@RequestBody UserExtraBody loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUserController(@RequestBody UserExtraBody user){
        return userService.saveUserService(user);
    }


    @RequestMapping(value="/activate-account/", method = RequestMethod.PUT)
    public ResponseEntity<?> activateUserController(@RequestBody UserExtraBody user) {
        return userService.activateAccountService(user);
    }


}
