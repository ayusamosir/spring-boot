package com.lawencon.appli.service;

import java.util.List;

import com.lawencon.appli.model.DataParkir;

public interface ParkirService {
	abstract DataParkir checkOut(Long id ,String us, String ps) throws Exception;
	abstract DataParkir insertData(DataParkir dp , String us, String ps)throws Exception;
	abstract List<DataParkir> showCheckin(String us, String ps) throws Exception;
	abstract void deleteParkir(Long id,String us, String ps) throws Exception;
	abstract List<DataParkir> showDataParkir(String jenisKendaraan,String us, String ps) throws Exception;

}
