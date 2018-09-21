package com.sk.sampleMS.domain.sample.model.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sk.sampleMS.domain.sample.model.valid.*;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private boolean onlyNumber = false;
	@Override
	public void initialize(Phone phone) {
		onlyNumber = phone.onlyNumber();
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext cxt) {
		if (input == null) {
			return false;
		}
		if(onlyNumber)
		{
			return input.matches("[0-9]*");
		}else {
			return input.matches("[0-9()-]*");
	
		}
		}

}
