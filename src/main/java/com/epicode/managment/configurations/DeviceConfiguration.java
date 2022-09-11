package com.epicode.managment.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.managment.device.DeviceDto;
import com.epicode.managment.device.DeviceStatus;
import com.epicode.managment.device.DeviceType;

@Configuration
public class DeviceConfiguration {

	@Bean("device1")
	public DeviceDto newDevice() {
		return new DeviceDto("666", DeviceType.SMARTPHONE, DeviceStatus.AVAILABLE);
	}
	@Bean("device2")
	public DeviceDto newDevice2() {
		return new DeviceDto("333", DeviceType.SMARTPHONE, DeviceStatus.MAINTENANCE);
	}
	
	
}
