package controller;

import java.net.URL;

import org.jpaste.exceptions.PasteException;
import org.jpaste.pastebin.Pastebin;

public class PastebinController {
	
	public URL pastebin(String title, String content){
		String developerKey = "b47a9376f041a50a9de538664b58fc2c";
		URL pastebinUrl = null;
		// paste, get URL & print
		try {
			pastebinUrl = Pastebin.pastePaste(developerKey, content, title);
		} catch (PasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pastebinUrl;
	}
}
