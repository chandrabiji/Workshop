package com.ojas.MLP323.util;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
    import javax.mail.Session;
    import javax.mail.Transport;
    // import javax.mail.internet.AddressException;
    import javax.mail.internet.InternetAddress;
    import javax.mail.internet.MimeMessage;
import java.util.Random;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/emailVerification")
public class EmailServicesRest {
  /**
   * Returns Customer details.
   * @return the Customer details
   */




  @GET
  @Path("/verify/{id}")
  public final int authenticate(final @PathParam("id") String to) {

    Random rnd = new Random();
    int number = rnd. nextInt(999999);

    // String str="0";
    // String email="cmsdemo323@gmail.com";
    // String password="cms@1234";

    String url = "\n\n[  "+number+"  ]\n\n";
    String m ="Dear Customer , \n\n"+
    "Thank you for being associated with our Project (Canteen Management)\n\n"
    +
    "You have accessed Our platform from email id i.e. :"
    +
    to
    +
    "for which One Time Password (OTP) has been generated and sent on your registered email address \n\n."+
     "And the Otp password is :"+url;




    //  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    //  // Get a Properties object
    //     Properties props = System.getProperties();
    //     props.setProperty("mail.smtp.host", "smtp.gmail.com");
    //     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    //     props.setProperty("mail.smtp.socketFactory.fallback", "false");
    //     props.setProperty("mail.smtp.port", "465");
    //     props.setProperty("mail.smtp.socketFactory.port", "465");
    //     props.put("mail.smtp.auth", "true");
    //     props.put("mail.debug", "true");
    //     props.put("mail.store.protocol", "pop3");
    //     props.put("mail.transport.protocol", "smtp");
        final String username = "cmsdemo323@gmail.com";//
        final String password = "cms@1234";
        try{
          Session session = Session.getDefaultInstance(setProperties(),
                              new Authenticator(){
                                 protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                 }});

       // -- Create a new message --
          Message msg = new MimeMessage(session);

       // -- Set the FROM and TO fields --
          msg.setFrom(new InternetAddress(username));
          msg.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(to,false));
          msg.setSubject("Canteen Management system ["
          +
          number
          +
          "]");
          msg.setText(m);
          msg.setSentDate(new Date());
          Transport.send(msg);
          System.out.println("Message sent.");
        }catch (MessagingException e){
          System.out.println("error");
        }


    return number;
  }

  @GET
  @Path("/sendEmail/{id}/{subject}/{message}")
  public final boolean sendEmail(final @PathParam("id") String to, final @PathParam("subject") String subject, final @PathParam("message") String message) {

    final String username = "cmsdemo323@gmail.com";//
    final String password = "cms@1234";

     // Get a Properties object

        try{
          Session session = Session.getDefaultInstance(setProperties(),
                              new Authenticator(){
                                 protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                 }});

       // -- Create a new message --
          Message msg = new MimeMessage(session);

       // -- Set the FROM and TO fields --
          msg.setFrom(new InternetAddress(username));
          msg.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(to,false));
          msg.setSubject(subject);
          msg.setText(message);
          msg.setSentDate(new Date());
          Transport.send(msg);
          System.out.println("Message sent.");
        }catch (MessagingException e){
          System.out.println("error");
        }


    return true;
  }

  Properties setProperties(){
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
    return props;
  }
}


