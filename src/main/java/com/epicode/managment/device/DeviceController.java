package com.epicode.managment.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/devices")
public class DeviceController {

	@Autowired
	DeviceService deviceService;

	@GetMapping
	@PreAuthorize("isAutenticated()")
	public ResponseEntity<Page<Device>> findAllDevice(Pageable pageable) {
		return ResponseEntity.ok(deviceService.findAllDevice(pageable));
	}

	@GetMapping("/{id}")
	@PreAuthorize("isAutenticated()")
	public ResponseEntity<Device> findById(@PathVariable String id) {
		return ResponseEntity.ok(deviceService.findById(id));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		return ResponseEntity.ok(deviceService.deleteById(id));
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> save(@RequestBody DeviceDto dto) {
		return ResponseEntity.ok(deviceService.save(dto));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> refresh(@PathVariable String id, @RequestBody Device device) {
		return ResponseEntity.ok(deviceService.refresh(id, device));
	}
}
