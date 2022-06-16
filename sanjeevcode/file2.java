import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class file2 {
    static boolean toFound=false,fromFound=false,subFound=false;
        public static void main(String[] args) {
            try {
                File myObj = new File("C:\\Users\\syadav\\Downloads\\TestMail (2).eml");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {

                    String data = myReader.nextLine();
                    Pattern pattern1 = Pattern.compile("To:", Pattern.CASE_INSENSITIVE);
                    Pattern pattern2 = Pattern.compile("From:", Pattern.CASE_INSENSITIVE);
                    Pattern pattern3 = Pattern.compile("Subject:", Pattern.CASE_INSENSITIVE);
                    Matcher matcher1 = pattern1.matcher(data);
                    Matcher matcher2 = pattern2.matcher(data);
                    Matcher matcher3 = pattern3.matcher(data);
                    boolean match1Found = matcher1.find();
                    boolean match2Found = matcher2.find();
                    boolean match3Found = matcher3.find();

                    if (match1Found && !toFound) {
                        System.out.println(data);
                        toFound=true;
                    }
                    if (match2Found && !fromFound) {
                        System.out.println(data);
                        fromFound=true;
                    }
                    if (match3Found && !subFound) {
                        System.out.println(data);
                        subFound=true;
                    }
                    if(data.equals("--0000000000002c980605e087c8b5"))
                    {
                        System.out.println("Body :");
                        String data1 = myReader.nextLine();
                        while (true)
                        {

                            data1=myReader.nextLine();
                            if(data1.equals("--0000000000002c980605e087c8b5"))
                            {
                                break;
                            }
                            System.out.println(data1);
                        }

                    }

                }
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
