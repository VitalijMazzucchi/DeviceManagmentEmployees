package com.epicode.managment.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
	private String serialNumber;
	private DeviceType type;
	private DeviceStatus status;
}
