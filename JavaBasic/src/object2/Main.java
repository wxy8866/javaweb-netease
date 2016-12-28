package object2;

import java.util.Scanner;

public class Main
{
    private static final String BEGIN_STRING = "$GPRMC";
    private static final String END_STRING   = "*";

    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        String wholeTextString = "";
        String readLineString = inputScanner.nextLine();
        StringBuffer wholeTextStringBuffer;
        int checksumFromMessage;
        int verifyCodeFromThis;

        while (!readLineString.equals("END"))
        {
            if (readLineString.startsWith(BEGIN_STRING))
            {
                wholeTextString = wholeTextString.concat(readLineString);
            }
            readLineString = inputScanner.nextLine();
        }

        wholeTextStringBuffer = new StringBuffer(wholeTextString);

        while (true)
        {
            int indexLastBegin = wholeTextStringBuffer.lastIndexOf(BEGIN_STRING);
            int indexLastEnd = wholeTextStringBuffer.lastIndexOf(END_STRING);
            // System.out.println("begin index is " + indexLastBegin);
            // System.out.println("end index is " + indexLastEnd);
            // System.out.println("string buffer length is " + wholeTextString.length());
            if (indexLastBegin == -1)
                break;
            if (indexLastEnd == -1)
                break;

            checksumFromMessage = Integer.parseInt(wholeTextStringBuffer.substring(indexLastEnd + 1, indexLastEnd + 3),
                    16);

            // System.out.println("processing string is " + wholeTextStringBuffer.substring(indexLastBegin,
            // indexLastEnd));
//             System.out.println("It's very code is " + checksumFromMessage);

            verifyCodeFromThis = wholeTextStringBuffer.charAt(indexLastBegin + 1);
            for (int i = indexLastBegin + 2; i < indexLastEnd; i++)
            {
                verifyCodeFromThis = verifyCodeFromThis ^ wholeTextStringBuffer.charAt(i);
            }

            verifyCodeFromThis = verifyCodeFromThis % 65536;

            // System.out.println("my verification code is " + verifyCodeFromThis);
            if (checksumFromMessage != verifyCodeFromThis)
            {
                wholeTextStringBuffer = wholeTextStringBuffer.delete(indexLastBegin, indexLastEnd + 3);
                // System.out.println("deleted something" + wholeTextStringBuffer);
                continue;
            }
            else
            {

                String[] seperatedFields = wholeTextStringBuffer.substring(indexLastBegin, indexLastEnd).toString()
                        .split(",");
                // System.out.println("whole text string buffer is " + wholeTextStringBuffer.toString());
                // System.out.println("signal pass is " + seperatedFields[2]);
                if (seperatedFields[2].equals("A"))
                {
                    // System.out.println("processed string is a verified message.");
                    String utcTime = seperatedFields[1].substring(0, seperatedFields[1].indexOf("."));

                    int utcTimeInt = Integer.parseInt(utcTime);
                    int time;

                    if (utcTimeInt >= 160000)
                    {
                        time = utcTimeInt - 160000;
                    }
                    else
                    {
                        time = utcTimeInt + 80000;
                    }

                    printTime(time);
                    break;
                }
                else
                {
                    wholeTextStringBuffer = wholeTextStringBuffer.delete(indexLastBegin, indexLastEnd + 3);
                    // System.out.println("deleted something" + wholeTextStringBuffer);
                    continue;
                }
            }

        }
        inputScanner.close();
    }

    private static void printTime(int time)
    {
        int hour = time / 10000;
        int min = time % 10000 / 100;
        int sec = time % 100;

        if (hour >= 10)
        {
            System.out.print(hour + ":");
        }
        else
        {
            System.out.print("0" + hour + ":");
        }

        if (min >= 10)
        {
            System.out.print(min + ":");
        }
        else
        {
            System.out.print("0" + min + ":");
        }

        if (sec >= 10)
        {
            System.out.print(sec);
        }
        else
        {
            System.out.print("0" + sec);
        }

    }

}
