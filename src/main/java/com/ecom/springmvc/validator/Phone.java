package com.ecom.springmvc.validator;

import javax.validation.Payload;

public @interface Phone {

	String message()
	default "{Phone}";
    
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
}
