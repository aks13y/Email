import java.util.*;
import java.io.*;
import java.util.regex.*;


public class java_email_parsing {
    public static void main(String[] args)
    {
        try
        {
            File file = new File("C:\\TestMail.eml");
            Scanner sc = new Scanner(file);
            int f1=0,f2=0,f3=0;
            while(sc.hasNextLine())
            {
                String data=sc.nextLine();
                data=data.toLowerCase();
                Pattern p1=Pattern.compile("to:");
                Matcher m1=p1.matcher(data);
                Pattern p2=Pattern.compile("from:");
                Matcher m2=p2.matcher(data);
                Pattern p3=Pattern.compile("subject:");
                Matcher m3=p3.matcher(data);
                if (m1.find() && f1==0) {System.out.println(data);f1=1;}
                if (m2.find() && f2==0) {System.out.println(data);f2=1;}
                if (m3.find() && f3==0) {System.out.println(data);f3=1;}
                if (data.equals("--0000000000002c980605e087c8b5"))
                {
                    System.out.println("Body:");
                    String body=sc.nextLine();
                    while(true)
                    {
                        body=sc.nextLine();
                        if (body.equals("--0000000000002c980605e087c8b5"))
                            break;
                        System.out.println(body);
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
