import Session.Session;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class parseeml {
    static boolean toFound=false,fromFound=false,subFound=false;
    public static void main(String[] args) throws FileNotFoundException {
        File contents=new File("C:\\Users\\rbiswas\\Downloads\\TestMail (1).eml");
        Scanner read= new Scanner(contents);
        while (read.hasNextLine()){
            String data= read.nextLine();
            Pattern p1= Pattern.compile("To",Pattern.CASE_INSENSITIVE);
            Pattern p2= Pattern.compile("From",Pattern.CASE_INSENSITIVE);
            Pattern p3= Pattern.compile("Subject",Pattern.CASE_INSENSITIVE);
            Matcher m1= p1.matcher(data);
            Matcher m2= p2.matcher(data);
            Matcher m3= p3.matcher(data);
            boolean match1found= m1.find();
            boolean match2found= m2.find();
            boolean match3found= m3.find();
            if (match1found && !toFound) {
                System.out.println(data);
                toFound = true;
            }
            if (match2found && !fromFound) {
                System.out.println(data);
                fromFound=true;
            }
            if (match3found && !subFound) {
                System.out.println(data);
                subFound=true;
            }
            if(data.equals("--0000000000002c980605e087c8b5"))
            {
                System.out.println("Body :");
                String data1 = read.nextLine();
                while (true)
                {
                    //System.out.println("hiiiii");
                    //System.out.println();
                    data1=read.nextLine();
                    if(data1.equals("--0000000000002c980605e087c8b5"))
                    {
                        break;
                    }
                    System.out.println(data1);
                }

            }

            }
        }




    }

