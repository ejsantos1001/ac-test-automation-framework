package com.angloinfo.tools;

import javax.mail.*;
import java.util.Properties;
import com.sun.mail.imap.IMAPStore;
import javax.mail.search.FlagTerm;



public class MailManager {

	static String  host = "imap.gmail.com";
	
	public static void checkGmail(String user, String password) {
		try {
			Session emailSession = createIMAPEmailSession();
			
			Store store = emailSession.getStore("imaps");
			store.connect(host, user, password);
			IMAPStore imapStore = (IMAPStore) store;
			Folder emailFolder = imapStore.getFolder("[Gmail]/All Mail");
			emailFolder.open(Folder.READ_WRITE);
			
			Message message = emailFolder.getMessage(2);
			System.out.println(message.getSubject());
			System.out.println(message.getDescription());
			
			emailFolder.close(true);
			store.close();
			
		} catch(NoSuchProviderException e) { 
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
			
			
	 } 
		public static boolean verifyEmailRecieved(String subject, String user,String password,long timeoutInSec) {
		boolean success = false;
		try {
			Session emailSession = createIMAPEmailSession();
			Store store = emailSession.getStore("imaps");
			store.connect(host,user, password);
			IMAPStore imapStore = (IMAPStore) store;
			Folder emailfolder = imapStore.getFolder("[Gmail]/All Mail");
			emailfolder.open(Folder.READ_WRITE);
			
			Flags seen = new Flags(Flags.Flag.SEEN);
			FlagTerm unseenFlagTerm = new FlagTerm(seen,false);
			Message messages[] = emailfolder.search(unseenFlagTerm);
			
			
			long startTime = System.nanoTime();
			Long maxTimeout = new Long(timeoutInSec * 1000000000L);  //  1sec = 1000000000nsec
			
		
			
			
			do {
		
		
			if(messages.length == 0) {
				System.out.println("no unread messages");
				
				
			
		
			} else {
				
				
								for(int i = 0;i< messages.length;i++ ) {
												if(messages[i].getSubject().equals(subject))  {
												System.out.println(messages[i].getSubject());
												messages[i].setFlag(Flags.Flag.SEEN, true);
												success = true;
												
												}
								
				    }
		
			}  
			
			}while((System.nanoTime() - startTime) < maxTimeout && success != true) ;
			
		
			emailfolder.close(true);
			store.close();
		
			
		} catch(NoSuchProviderException e) { 
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return success; 
		
		}
	
	
			
		public static Session createIMAPEmailSession() {
			Properties properties =  new Properties();
			properties.put("mail.store.protocol","imaps");
			properties.put("mail.imaps.port","993");
			properties.put("mail.imaps.starttls.enable","true");
			
			Session emailSession =  Session.getInstance(properties);
			return emailSession;
		 
	 }
	 
	 
		
		
	 }
	
	
			
			
	

