package ct.virtusa;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumberToWordConversion {

    public static final String INVALID_INPUT_GIVEN = "Invalid input given";
    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };


    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred and " + soFar;
    }


    public static String getMoneyIntoWords(int number) {

        if(number<0)
            return INVALID_INPUT_GIVEN;
        if (number == 0) {
            return "zero";
        }

        String sNumber;
        String mask = "000000000";
        DecimalFormat df = new DecimalFormat(mask);
        sNumber = df.format(number);

        int millions = Integer.parseInt(sNumber.substring(0, 3));

        int hundredThousands = Integer.parseInt(sNumber.substring(3, 6));

        int thousands = Integer.parseInt(sNumber.substring(6, 9));

        String tradMillions="";

        if(millions>0){
            tradMillions = convertLessThanOneThousand(millions)
                    + " million ";
        }
        String result = tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "one thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + " thousand ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Please enter number to convert, else -1 to exit");
            int s = scanner.nextInt();
            if (s < 0)
                break;
            System.out.println(NumberToWordConversion.getMoneyIntoWords(s));
        }

    }
}