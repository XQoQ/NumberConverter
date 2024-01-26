import java.util.Scanner;
import java.util.Arrays;


class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        while (!isNumberValid(base, number)) {
            System.out.print("The number you entered, " + number + ", is invalid, enter a new one: ");
            number = s.nextLine();
        }

        NumberConverter nc = new NumberConverter(number, base);
        String[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        displayConversions(base, nc);
        System.out.println("--------------------------------");


        System.out.print("Enter decimal number: ");
        int decimalNumber = Integer.parseInt(s.nextLine());
        System.out.print("Enter any base less than 64: ");
        base = Integer.parseInt(s.nextLine());
        s.close();
        String[] anyBaseNumber = nc.convertToAnyBase(decimalNumber, base);
        System.out.print("Your Number In Base " + base + ": " + nc.getAnyBaseNumber(anyBaseNumber));

    }


    public static boolean isNumberValid(int base, String n) {
        String[] conversionArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d",
                "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z", "+", "/"};

        String[] digits = new String[n.length()];
        for (int i = 0; i < n.length(); i++) {
            String single = n.substring(i, i + 1);
            digits[i] = single;
        }

        for (int i = 0; i < digits.length; i++) {
            if (NumberConverter.findIndex(conversionArray, digits[i]) > base - 1) {
                return false;
            }
        }

        return true;
    }


    public static void displayConversions(int base, NumberConverter nc) {
        if (base == 2) {
            System.out.println("Decimal Number: " + nc.getDecimalNumber());
            System.out.print("Octal Number: " + nc.getOctalNumber());
            System.out.print("Hexadecimal Number: " + nc.getHexadeciamlNumber());
        } else if (base == 8) {
            System.out.println("Decimal Number: " + nc.getDecimalNumber());
            System.out.print("Binary Number: " + nc.getBinaryNumber());
            System.out.print("Hexadecimal Number: " + nc.getHexadeciamlNumber());
        } else if (base == 10) {
            System.out.print("Binary Number: " + nc.getBinaryNumber());
            System.out.print("Octal Number: " + nc.getOctalNumber());
            System.out.print("Hexadecimal Number: " + nc.getHexadeciamlNumber());
        } else {
            System.out.println("Decimal Number: " + nc.getDecimalNumber());
            System.out.print("Binary Number: " + nc.getBinaryNumber());
            System.out.print("Octal Number: " + nc.getOctalNumber());
        }
    }
}













