package com.lawencon.appli.impljpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.appli.model.DataParkir;

@Repository
public interface ParkRepo extends JpaRepository<DataParkir, Long> {
	
	List<DataParkir> findByKendaraan(String kendaraan);	
}
