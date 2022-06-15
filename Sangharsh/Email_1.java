import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_1 {
    public static void main(String[] args){
        try {
            File myObj = new File("C:\\Users\\sjanbandhu\\Downloads\\TestMail.eml");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                Pattern p1 = Pattern.compile("To:", Pattern.CASE_INSENSITIVE);
                Matcher m1 = p1.matcher(data);
                boolean Flag1 = m1.find();
                Pattern p2 = Pattern.compile("From:", Pattern.CASE_INSENSITIVE);
                Matcher m2 = p2.matcher(data);
                boolean Flag2 = m2.find();
                Pattern p3 = Pattern.compile("Subject:", Pattern.CASE_INSENSITIVE);
                Matcher m3 = p3.matcher(data);
                boolean Flag3 = m3.find();

                boolean got_to=false;
                if (Flag1 && !got_to) {
                    System.out.println(data);
                    got_to=true;
                }
                boolean got_from=false;
                if (Flag2 && !got_from) {
                    System.out.println(data);
                    got_from=true;
                }
                boolean got_subject=false;
                if (Flag3 && !got_subject) {
                    System.out.println(data);
                    got_subject=true;
                }
                if(data.equals("--0000000000002c980605e087c8b5"))
                {
                    System.out.println("Body :");
                    data = myReader.nextLine();
                    while (true)
                    {
                        data=myReader.nextLine();
                        if(data.equals("--0000000000002c980605e087c8b5"))
                        break;

                        System.out.println(data);
                    }

                }

            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
