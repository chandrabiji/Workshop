package com.ojas.MLP323.util;
// import javax.mail.Message;
// import javax.mail.Session;
// import javax.mail.Transport;
// // import javax.mail.PasswordAuthentication;
// // import java.util.Random;

// import javax.mail.internet.InternetAddress;
// import javax.mail.internet.MimeMessage;
// import java.util.Properties;
// import javax.mail.MessagingException;



// public class testClass{}
    // public static void main(String[] args) {

    //     System.out.println(authenticate());
    // }
    // public static String authenticate() {

    //     Random rnd = new Random();
    //     int number = rnd. nextInt(999999);

    //     String str="0";
    //     String email="cmsdemo323@gmail.com";
    //     // String password="cms@1234";

    //     String url = "<strong>"+number+"</strong>";
    //     String msg ="Dear Customer , \n\n"+
    //     "Thank you for being associated with our Project (Canteen Management)\n\n"
    //     +
    //     "You have accessed Our platform from email id i.e. :"
    //     +
    //     "omkarsp644@gmail.com"
    //     +
    //     "for which One Time Password (OTP) has been generated and sent on your registered email address \n\n."+
    //      "And the Otp password is :"+url;

    //      try{
    //       //Get the session object
    //         Properties props = new Properties();
    //         str="1";
    //         props.put("mail.smtp.host", "smtp.gmail.com");
    //         str="2";
    //         props.put("mail.smtp.socketFactory.port", "465");
    //         str="3";
    //         props.put("mail.smtp.socketFactory.class",
    //             "javax.net.ssl.SSLSocketFactory");
    //             str="4";
    //         props.put("mail.smtp.auth", "true");
    //         str="5";
    //         props.put("mail.smtp.port", "465");

    //         str="6";
    //         Session session = Session.getInstance(props,null);
    //         str="7";
    //           //compose message

    //         // Transport transport = session.getTransport("smtp");
    //         // System.out.println("ss :"+transport);
    //         str="8";
    //         // transport.connect();
    //         str="9";
    //         MimeMessage message = new MimeMessage(session);
    //         str="10";
    //         message.setFrom(new InternetAddress(email));//change accordingly
    //         str="11";
    //         message.addRecipient(Message.RecipientType.TO, new InternetAddress("omkarsp644@gmail.com"));
    //         str="12";
    //         message.setSubject("Regarding Your Canteen Management System login Successfully");
    //         str="13";
    //         message.setText(msg);
    //         str="14";
    //         //send message
    //         Transport.send(message);
    //         str="15";
    //         // transport.close();

    //       } catch (MessagingException e) {
    //         System.out.println( e.getMessage());
    //      }


    //     return str;
    //   }

    // }

    // public class testClass {
    //   public static void main(String[] args) {

    //   }
    // }