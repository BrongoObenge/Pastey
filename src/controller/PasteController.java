package controller;

import java.util.ArrayList;

import manager.TimeManager;
import model.Paste;

public class PasteController {
	TimeManager time = new TimeManager();
	MySqlController mysqlCon = new MySqlController();
	
	public String addPaste(String title, String paste, String password){
		return mysqlCon.addPaste(title, paste, password, time.getTimestamp());
	}
	
	public ArrayList<Paste> getAllPastesLim20(){
		return mysqlCon.getAllPastesLim20();
	}
	
	public ArrayList<Paste> getAllPastes(){
		return mysqlCon.getAllPastes();
	}
	
	public ArrayList<model.Paste> getPasteById(String id){
		return mysqlCon.getPasteById(id);
	}
}
