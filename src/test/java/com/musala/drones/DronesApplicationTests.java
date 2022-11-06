package com.musala.drones;

import com.musala.drones.controller.DroneController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DronesApplicationTests {

	@Autowired
	private DroneController droneController;

	@Test
	void contextLoads() {
		assertThat(droneController).isNotNull();
	}

}
