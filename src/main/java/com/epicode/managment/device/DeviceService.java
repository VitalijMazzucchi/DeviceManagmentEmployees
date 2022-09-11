package com.epicode.managment.device;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.managment.security.users.UserDto;
@Service
public class DeviceService {
	
	@Autowired
	DeviceRepossitory deviceRepository;
	
	
	public Page<Device> findAllDevice(Pageable pageable  ) {
		return deviceRepository.findAll(pageable);
	}

	public Device findById(String id) {
		if (!deviceRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		return deviceRepository.findById(id).get();
	}

	public String deleteById(String id) {
		if (!deviceRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		deviceRepository.deleteById(id);
	
		return "Device eliminated";
	}

	public Device save(DeviceDto dto) {
		if (deviceRepository.existsById(dto.getSerialNumber())) {
			throw new EntityExistsException("User not found");
		}

		Device u = new Device();
		BeanUtils.copyProperties(dto, u);
		deviceRepository.save(u);
		return u;
	}

	public Device refresh(String id, Device device) {
		if (!deviceRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
	
			return	deviceRepository.save(device);
		
	}
}
