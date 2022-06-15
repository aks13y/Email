//import javax.mail.*;
//import javax.mail.internet.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class email {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\atatikella\\Downloads\\TestMail.eml");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        while(sc.hasNextLine())
//        {
//            System.out.println(sc.nextLine());
//        }
//        String from = "" ;
//        String to = "" ;
        int i = 0 ;
        String bdStart = "--0000000000002c980605e087c8b5" ;
        int flag = 0 ;
        while(sc.hasNextLine())
        {

            String str = sc.nextLine();
            int p = str.indexOf("From");
            int q = str.indexOf("To");
            int r = str.indexOf("Subject");
            if(p == 0)
            {
                System.out.println(str.substring(p) );
            }
            if(q == 0)
            {
                System.out.println(str.substring(q));
            }
            if(r == 0)
            {
                System.out.println(str.substring(r));
            }
            if(str.equals(bdStart))
            {
                System.out.println("Body : ");
                if(flag == 0)
                {
                    String bdLine = "" ;
                    bdLine = sc.nextLine();
                    boolean f = false ;
                    while(!(bdLine.equals(bdStart)))
                    {
                        if(f == false)
                        {
                            f = true;
                            bdLine = sc.nextLine();
                            continue;
                        }
                        System.out.println(bdLine);
                        bdLine = sc.nextLine();
                    }
                }
                flag = 1;
            }
        }
    }
}
