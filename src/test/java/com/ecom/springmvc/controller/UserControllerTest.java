package com.ecom.springmvc.controller;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import com.ecom.springmvc.model.User;
import com.ecom.springmvc.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	// This @Mock annotation simply creates a mock instance. There is nowhere to
    // inject it. Depending on the particular circumstance, it may be better or
    // clearer to instantiate the mock explicitly in the test itself, but we're
    // doing it here for illustration. Also, I don't know what your real class
    // is like, but it may be more appropriate to just instantiate a real one
    // than a mock one.
	@Mock
	private UserService userService;

	// Create an instance of what you are going to test.
    // When using the @InjectMocks annotation, you must create the instance in
    // the constructor or in the field declaration.
	@InjectMocks
	private UserController userController=new UserController();
	
	@SuppressWarnings("unused")
	private MockMvc mockMvc;
	
	@Mock
    private BindingResult bindingResult;
	
	@Before
	public void setup()
	{
		MockitoAnnotations .initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(userController).build();
	
	}
	
	@Test
	public void shouldAddUser()throws Exception
	{
		final String target = "redirect:/users/user";
		User u=new User(0, "DemoName", "demo", "cybage", "cybage@cybage.com", "1010101010101", "user");
		String nextPage = null;
		// Perform the action
	/*	if(bindingResult.hasErrors())
		{
			final String target1 = "newUser";
			assertEquals("Controller is not requesting the correct form", nextPage,
	                target1);
		}*/
		nextPage=userController.addUser(u, bindingResult);
		assertEquals("Controller is not requesting the correct form", nextPage,
                target);
				
	}
	

}
