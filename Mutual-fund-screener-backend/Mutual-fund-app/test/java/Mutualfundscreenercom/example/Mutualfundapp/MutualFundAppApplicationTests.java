package Mutualfundscreenercom.example.Mutualfundapp;

import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import Mutualfundscreenercom.example.Mutualfundapp.entities.Roles;
import Mutualfundscreenercom.example.Mutualfundapp.entities.Users;
import Mutualfundscreenercom.example.Mutualfundapp.extrabody.LoginUser;
import Mutualfundscreenercom.example.Mutualfundapp.extrabody.UserExtraBody;
import Mutualfundscreenercom.example.Mutualfundapp.repository.MutualFundRepository;
import Mutualfundscreenercom.example.Mutualfundapp.repository.RoleRepository;
import Mutualfundscreenercom.example.Mutualfundapp.repository.UserRepository;
import Mutualfundscreenercom.example.Mutualfundapp.service.RoleService;
import Mutualfundscreenercom.example.Mutualfundapp.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

import java.util.List;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class MutualFundAppApplicationTests {


	@Autowired
	MutualFundRepository mutualFundRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;


	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	@Test
	public void testGetMutualFUnds(){
		RestTemplate restTemplate=new RestTemplate();
		MutualFund mutualFund=restTemplate.getForObject("http://localhost:8080/mutual-fund/119585",MutualFund.class);
		assertNotNull(mutualFund);
		assertEquals("SBI BlueChip Fund(IDCW-Payout)",mutualFund.getName());

	}


	@Test
	void testcreateuser(){
		RestTemplate restTemplate=new RestTemplate();
		UserExtraBody userExtraBody=new UserExtraBody();

		userExtraBody.setUsername("SMG");
		userExtraBody.setPassword("1234");
		userExtraBody.setEmail("smg.agsec@gmail.com");
		userExtraBody.setCreatedAt("22-03-2019");
		String newUser=restTemplate.postForObject("http://localhost:8080/mutual-fund/register",userExtraBody,String.class);
		System.out.println(newUser);
	}



	@Test
	void testCreateUserDetails(){
		Users users=new Users();
		users.setUsername("SMG");
		users.setPassword(bCryptPasswordEncoder.encode("@1234@"));
		users.setEmail("smg.agsec@gmail.com");
		users.setCreatedAt("23-04-1999");
		userRepository.save(users);
		assertNotNull(userRepository.findByUsername("SMG"));

	}

	@Test
	void testloginUser(){
		LoginUser user=new LoginUser();
		user.setUsername("SMG");
		user.setPassword("@1234@");
		assertNotNull(userRepository.findByUsername("SMG"));
	}

	@Test
	public  void testGetAllUsers(){
		RestTemplate restTemplate=new RestTemplate();
		Users users=restTemplate.getForObject("http://localhost:8080/admin/get-all-users",Users.class);
		assertNotNull(users);
		assertEquals("SMG",users.getUsername());
	}



}
