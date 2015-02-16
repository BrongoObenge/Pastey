package manager;

import java.security.MessageDigest;

import org.jasypt.util.text.StrongTextEncryptor;

public class CryptionManager {
	private MessageDigest md5;
	private MessageDigest sha;
	private StrongTextEncryptor crypt;
	
	public CryptionManager(){
		try{
			crypt = new StrongTextEncryptor();
			crypt.setPassword("nigglet");
		}catch(Exception e){}
	}
	
	public String encryptUid(String uid){
		String a = crypt.encrypt(uid);
		return a;
	}
	public String decryptUid(String uid){
		return crypt.decrypt(uid);
	}
}
