package com.epicode.managment.device;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.epicode.managment.security.users.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Device {

	@Id
	private String serialNumber;
	private DeviceType type;
	private DeviceStatus status;
	@ManyToOne
	private User user;
	
	
}
