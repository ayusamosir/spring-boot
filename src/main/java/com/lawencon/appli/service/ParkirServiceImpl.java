package com.lawencon.appli.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.appli.implhibernate.ParkirDaoImpl;
import com.lawencon.appli.implhibernate.UserDaoImpl;
import com.lawencon.appli.model.DataParkir;


@Service
@Transactional
public class ParkirServiceImpl implements ParkirService{
	
	@Autowired
	@Qualifier("park_repo_hibernate") 
	ParkirDaoImpl parkDaoImpl;
	
	@Autowired
	@Qualifier("user_repo_hiber")
	UserDaoImpl userDaoImpl;
	
	@Override
	public DataParkir insertData(DataParkir dp, String us, String ps) throws Exception {
		userDaoImpl.findByUsPs(us, ps);
		return parkDaoImpl.insertData(dp);
	}

	@Override
	public DataParkir checkOut(Long id,String us, String ps) throws Exception {
		userDaoImpl.findByUsPs(us, ps);
		return parkDaoImpl.checkOut(id);
	}

	@Override
	public void deleteParkir(Long id,String us, String ps) throws Exception {
		userDaoImpl.findByUsPs(us, ps);
		parkDaoImpl.deleteParkir(id);
	}

	@Override
	public List<DataParkir> showDataParkir(String jenisKendaraan,String us, String ps) throws Exception {
		userDaoImpl.findByUsPs(us, ps);
		return parkDaoImpl.showDataParkir(jenisKendaraan);
	}

	@Override
	public List<DataParkir> showCheckin(String us, String ps) throws Exception {
		userDaoImpl.findByUsPs(us, ps);
		return parkDaoImpl.showAll();
	}


}
