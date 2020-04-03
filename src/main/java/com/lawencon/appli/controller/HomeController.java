package com.lawencon.appli.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import com.lawencon.appli.model.DataParkir;
import com.lawencon.appli.service.ParkirService;

@RestController
public class HomeController extends BaseCtrl {
	
	@Autowired
	private ParkirService parkServ;

	@PostMapping("/checkin/body")
	public ResponseEntity<String> CheckIn (@RequestBody DataParkir dp, @RequestHeader("Authorization") String username ) {
		
		try {
			String[] author = super.authorUser(username);
			dp = parkServ.insertData(dp, author[0], author[1]);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<String> checkOut(@RequestParam("id") Long id ,  @RequestHeader("Authorization") String username ){
		
		try {
			String[] author = super.authorUser(username);
			parkServ.checkOut(id, author[0], author[1]);
		
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deletePark (@RequestParam("id") Long id , @RequestHeader("Authorization") String username){
	
		try {
			String[] author = super.authorUser(username);
			parkServ.deleteParkir(id, author[0], author[1]);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Delete Berhasil", HttpStatus.OK);
	}
	
	@GetMapping("/showData")
	public ResponseEntity<List<DataParkir>> showJenis (@RequestParam("kendaraan") String kendaraan , @RequestHeader("Authorization") String username){
		
		List<DataParkir> listData = new ArrayList<>();
		try {
			String[] author = super.authorUser(username);
			parkServ.showDataParkir(kendaraan,  author[0], author[1]);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listData, HttpStatus.OK);	
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<DataParkir>> showDataParkir (@RequestHeader("Authorization") String username){
		List<DataParkir> listParking = new ArrayList<DataParkir>();
		try {
			String[] author = super.authorUser(username);
			listParking = parkServ.showCheckin( author[0], author[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listParking, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listParking, HttpStatus.OK);
	}

}
