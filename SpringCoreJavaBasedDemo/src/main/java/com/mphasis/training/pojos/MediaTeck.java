package com.mphasis.training.pojos;

import org.springframework.stereotype.Component;

@Component
public class MediaTeck implements Processor {

	public void Process() {
		System.out.println("MediaTeck Processor");
	}

}
