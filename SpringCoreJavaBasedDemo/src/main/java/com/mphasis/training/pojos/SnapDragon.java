package com.mphasis.training.pojos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class SnapDragon implements Processor {

	public void Process() {
		System.out.println("snapDragan Processor");
	}

}
