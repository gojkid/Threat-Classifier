/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentingTheResult;

import java.util.Calendar;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSend2 {

    public static String senderName;
    public static String hostName; //change according to need
    public static String fromMailId;  //change according to need 
    public static String password;
    public static String portNumber;             //change according to need
    public static String protocol;
    public static String to = "";
    public static String authentication;
    String subject;
    String body;
    String filename;

    public MailSend2(String emailOfUser) {

        senderName = "School Shooting Threat Classification Developers"; //change according to need
         hostName = "smtp.gmail.com";     //change according to need
         fromMailId = "testingexcelsheet2@gmail.com"; //change according to need 
         password = "I'mtesting";         //change according to need .
         authentication = "true";
         portNumber = "587";               //change according to need
         protocol = "smtp";
         to = emailOfUser;
        
        subject = "Result of your classification of threats requrest";
        body = "This is the result of the threats that you entered in the Google Excel Sheet.";        
        filename ="resultGoogleSheet2.txt";
        Properties props = null;
        Transport t = null;
        MimeMessage message = null;
        try {
            // Get system properties
            props = System.getProperties();
            // Setup mail server
            props.put("mail.smtp.starttls.enable", authentication);
            props.put("mail.smtp.host", hostName);
            props.put("mail.smtp.port", portNumber);
            props.put("mail.smtp.auth", authentication);
            props.put("mail.smtp.user", fromMailId);
            props.put("mail.smtp.password", password);
            // Get session
            javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);
            // Define message 
            message = new MimeMessage(mailSession);
            // create the message part   
            BodyPart messageBodyPart = new MimeBodyPart();
            //set message here
            messageBodyPart.setText(body);
            //create MimeMultipart object and set Data Handler and then set File Name 
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            // Put multipart object in message object
            message.setContent(multipart);

            Calendar today = Calendar.getInstance();
            // Now compose message by setting all necessary details
            message.setSentDate(today.getTime());
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(senderName + "<" + fromMailId + ">"));

            message.setSubject(subject);
            message.saveChanges();
            t = mailSession.getTransport(protocol);
            t.connect(hostName, fromMailId, password);
            // Send the message
            t.sendMessage(message, message.getAllRecipients());
            if (t != null) {
                //System.out.println("Email Sent Successfully");
            }
        } catch (Exception e) {
           
        }
    }
}