import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	static String emailFrom="jbot2059@gmail.com";
	static String paswordFrom="fdnfoatrshbnlwre";
	static String emailTo="juanpuc004@gmail.com";
	static String asunto="Prueba enviar correo";
	static String mensaje="Todo final es un comienzo.";
	
	static Properties prop;
	static Session mses;
	static MimeMessage mim;

	public static void main(String[] args) {
		prop=new Properties();
		createEmail();
		sendEmail();
	}
	
	static void createEmail() {
		 prop.put("mail.smtp.host", "smtp.gmail.com");
		 prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		 prop.setProperty("mail.smtp.starttls.enable", "true");
		 prop.setProperty("mail.smtp.port", "587");
		 prop.setProperty("mail.smtp.user", emailFrom);
		 prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		 prop.setProperty("mail.smtp.auth", "true");
		 
		 mses=Session.getDefaultInstance(prop);
		 
		 mim=new MimeMessage(mses);
		 try {
			mim.setFrom(new InternetAddress(emailFrom));
			mim.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mim.setSubject(asunto);
			mim.setText(mensaje, "ISO-8859-1", "html");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	static void sendEmail() {
		try {
			Transport trans=mses.getTransport("smtp");
			trans.connect(emailFrom, paswordFrom);
			trans.sendMessage(mim, mim.getRecipients(Message.RecipientType.TO));
			trans.close();
			System.out.println("Mensaje enviado exitosamente.");
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
