package com.epicode.managment.device;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeviceRepossitory extends PagingAndSortingRepository<Device, String> {

	boolean existsById(String serialNumber);

}
