package com.lawencon.appli.dao;

import java.util.List;

import com.lawencon.appli.model.DataParkir;

public interface ParkirDao {
	
	abstract DataParkir checkOut(Long id) throws Exception;
	abstract DataParkir insertData(DataParkir dp)throws Exception;
	abstract List<DataParkir> showAll() throws Exception;
	abstract void deleteParkir(Long id) throws Exception;
	abstract List<DataParkir> showDataParkir(String jenisKendaraan) throws Exception;
	
}
