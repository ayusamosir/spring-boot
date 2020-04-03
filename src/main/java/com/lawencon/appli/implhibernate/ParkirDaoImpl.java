package com.lawencon.appli.implhibernate;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.appli.dao.ParkirDao;
import com.lawencon.appli.model.DataParkir;

@Repository("park_repo_hibernate")
public class ParkirDaoImpl extends ParkiranEm implements ParkirDao {
	
	@Override
	public DataParkir checkOut(Long id) throws Exception {
		javax.persistence.Query q = em.createQuery("from DataParkir where id = :idParam");
		q.setParameter("idParam", id);
		DataParkir dp = new DataParkir();
		dp = (DataParkir) q.getSingleResult();
		dp.setStatus("CHECK-OUT");
		dp.setCheckOut(LocalDate.now());
		em.merge(dp);
		return dp;
	}

	@Override
	public DataParkir insertData(DataParkir dp) throws Exception {
		dp.setStatus("CHECK-IN");
		dp.setCheckIn(LocalDate.now());
		em.persist(dp);
		return dp;
	}

	@Override
	public void deleteParkir(Long id) throws Exception {
		Query q = em.createQuery(" from DataParkir where id= :idParam");
		q.setParameter("idParam", id);
		DataParkir dp = new DataParkir();
		dp = (DataParkir) q.getSingleResult();
		em.remove(dp);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataParkir> showDataParkir(String jenisKendaraan) throws Exception {
		Query q = em.createQuery(" from DataParkir where kendaraan = :idParam");
		q.setParameter("idParam", jenisKendaraan);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataParkir> showAll() throws Exception {
		Query q = em.createQuery(" from DataParkir");
		return q.getResultList();
	}


}
