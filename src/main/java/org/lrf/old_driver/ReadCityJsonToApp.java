package org.lrf.old_driver;

import org.lrf.old_driver.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReadCityJsonToApp  implements CommandLineRunner{

	@Autowired
	private CityService cityService;
	
	@Override
	public void run(String... arg0) throws Exception {
		cityService.setAllCities();
	}

}
