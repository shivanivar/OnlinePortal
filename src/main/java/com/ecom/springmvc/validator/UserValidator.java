package com.ecom.springmvc.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ecom.springmvc.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmpty(errors, "user_phone", "user_phone.required");
		ValidationUtils.rejectIfEmpty(errors, "user_email", "user_email.required");
		
		/*User user = (User) target;*/
		/*if(user.getUser_phone().length() == 0)
		{
			errors.rejectValue("phone","phone.required");
		}*/
	
	}

}
