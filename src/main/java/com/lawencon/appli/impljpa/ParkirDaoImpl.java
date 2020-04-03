package com.lawencon.appli.impljpa;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.appli.dao.ParkirDao;
import com.lawencon.appli.implhibernate.ParkiranEm;
import com.lawencon.appli.model.DataParkir;

@Repository("park_repo_jpa")
public class ParkirDaoImpl extends ParkiranEm implements ParkirDao {
	
	@Autowired
	private ParkRepo parkRepo;

	@Override
	public DataParkir checkOut(Long id) throws Exception {
		javax.persistence.Query q = em.createQuery("from DataParkir where id = :idParam");
		q.setParameter("idParam", id);
		DataParkir dp = new DataParkir();
		dp = (DataParkir) q.getSingleResult();
		dp.setStatus("CHECK-OUT");
		dp.setCheckOut(LocalDate.now());
		return parkRepo.save(dp);
	}

	@Override
	public DataParkir insertData(DataParkir dp) throws Exception {
		dp.setStatus("CHECK-IN");
		dp.setCheckIn(LocalDate.now());
		return parkRepo.save(dp);
	}

	@Override
	public void deleteParkir(Long id) throws Exception {
		Query q = em.createQuery(" from DataParkir where id= :idParam");
		q.setParameter("idParam", id);
		DataParkir dp = new DataParkir();
		dp = (DataParkir) q.getSingleResult();
		parkRepo.delete(dp);
	}


	@Override
	public List<DataParkir> showDataParkir(String jenisKendaraan) throws Exception {
		Query q = em.createQuery(" from DataParkir where kendaraan = :idParam");
		q.setParameter("idParam", jenisKendaraan);
		return parkRepo.findByKendaraan(jenisKendaraan);
	}

	@Override
	public List<DataParkir> showAll() throws Exception {
		return parkRepo.findAll();
	}

}
