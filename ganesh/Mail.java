import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    static boolean toFound=false,fromFound=false,subFound=false;
    //static String  data;
    static boolean checkStr(String check,String with)
    {
        if(check.indexOf(with)==0)
        {
            System.out.println(check);
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        try {


            File myObj = new File("C:\\Users\\gsathinedi\\IdeaProjects\\mailRead\\TestMail.eml");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(!toFound)
                {
                    toFound=checkStr(data,"To:");
                }
                if(!fromFound)
                {
                    fromFound=checkStr(data,"From:");
                }

                if(!subFound)
                {
                    subFound=checkStr(data,"Subject:");
                }
                if(data.equals("--0000000000002c980605e087c8b5"))
                {
                    System.out.println("Body :");
                    String data1 = myReader.nextLine();
                    while (true)
                    {
                        //System.out.println("hiiiii");
                        //System.out.println();
                        data1=myReader.nextLine();
                        if(data1.equals("--0000000000002c980605e087c8b5"))
                        {
                            break;
                        }
                        System.out.println(data1);
                    }

                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
