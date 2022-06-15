import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


            File filename=new File("C:\\Users\\tholigi\\Downloads\\TestMail.eml");
            Scanner file = new Scanner(filename);
            while (file.hasNext()) {
                String word = file.next();
                //System.out.println(word);
                Pattern pattern1 = Pattern.compile("Subject:");
                Matcher matcher1 = pattern1.matcher(word);
                if(matcher1.matches()){
                    System.out.println(file.nextLine());
                }

                Pattern pattern2 = Pattern.compile("From:");
                Matcher matcher2 = pattern2.matcher(word);
                if(matcher2.matches()){
                    System.out.println(file.nextLine());
                }
                Pattern pattern3 = Pattern.compile("To:");
                Matcher matcher3 = pattern3.matcher(word);
                if(matcher3.matches()) {
                    System.out.println(file.nextLine());
                }

                    int i = 0 ;
                String bdStart = "--0000000000002c980605e087c8b5" ;
                int flag = 0 ;

                while(file.hasNextLine())
                {

                    String str = file.nextLine();
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
                            bdLine = file.nextLine();
                            boolean f = false ;
                            while(!(bdLine.equals(bdStart)))
                            {
                                if(f == false)
                                {
                                    f = true;
                                    bdLine = file.nextLine();
                                    continue;
                                }
                                System.out.println(bdLine);
                                bdLine = file.nextLine();
                            }
                        }
                        flag = 1;
                    }
                }
            }

        }
    }
