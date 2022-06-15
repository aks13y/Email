import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MailReader {
    public static void main(String[] args) {
               try {
                File file = new File("C:\\Users\\vmudavath\\Downloads\\TestMail.eml");
                Scanner scan = new Scanner(file);

                String s = "";
                int i=0;
                while(scan.hasNextLine()){
                    s= scan.nextLine();
                    //System.out.println(s+"   "+i);
                    if(i==5 || i==3 || i ==4 ){
                        System.out.println(s);
                    }
                    i++;

                    if(s.equals("--0000000000002c980605e087c8b5")){
                        s=scan.nextLine();
                        s=scan.nextLine();

                        while(!s.equals("--0000000000002c980605e087c8b5")){
                            System.out.println(s);
                            s=scan.nextLine();
                        }
                    }

                }


        } catch (FileNotFoundException e) {
                   throw new RuntimeException(e);
               }
    }
}