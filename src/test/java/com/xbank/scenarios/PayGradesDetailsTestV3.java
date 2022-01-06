package com.xbank.scenarios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.xbank.core.BaseCl;

public class PayGradesDetailsTestV3 extends BaseCl{
	
	
	@Test
	public void getDetailsFrompayGrades() {
		Logger log = LogManager.getLogger(PayGradesDetailsTestV3.class);
		int age = 10;
		if(age > 18) {
			log.info("age Validated in getDetailsFrompayGrades to process further");
		}else {
			log.error("age invalidated in getDetailsFrompayGrades, so no further action done");
		}
		
	}
	
	
	

}
