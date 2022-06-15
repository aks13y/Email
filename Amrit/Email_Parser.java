package org.example;

import com.mysql.cj.Session;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_Parser {
    public static void main(String args[]) throws IOException {
        boolean fromfound=false;
        boolean tofound=false;
        boolean subfound=false;
        boolean boun=false;
        try{
            File obj= new File("C:\\Users\\amanand\\Downloads\\TestMail.eml");
            Scanner sc= new Scanner (obj);
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                Pattern p1= Pattern.compile("From",Pattern.CASE_INSENSITIVE);
                Pattern p2= Pattern.compile("To",Pattern.CASE_INSENSITIVE);
                Pattern p3= Pattern.compile("Subject",Pattern.CASE_INSENSITIVE);
                Pattern p4= Pattern.compile("Boundary",Pattern.CASE_INSENSITIVE);

                Matcher m1= p1.matcher(str);
                Matcher m2= p2.matcher(str);
                Matcher m3= p3.matcher(str);
                Matcher m4=p4.matcher(str);
                boolean n1=m1.find();
                boolean n2=m2.find();
                boolean n3=m3.find();
                boolean n4=m4.find();
                if(n1==true && !fromfound){
                    System.out.println(str);
                    fromfound=true;
                }
                else if(n2==true && !tofound){
                    System.out.println(str);
                    tofound=true;
                }
                else if(n3==true && !subfound) {
                    System.out.println(str);
                    subfound=true;
                }
                if (str.equals("--0000000000002c980605e087c8b5")){
                        System.out.println("Body:");

                    while(true){
                        String str1=sc.nextLine();
                        if (str1.equals("--0000000000002c980605e087c8b5"))
                        {
                            break;
                        }
                        System.out.println(str1);
                        }
                }

        }}
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
