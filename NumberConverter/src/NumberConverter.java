public class NumberConverter {
    String[] valueTable = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
    String[] digits;
    int base;


    public NumberConverter(String number, int base) {
        digits = new String[number.length()];

        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i, i + 1);
            digits[i] = single;
        }
        this.base = base;
    }


    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";

        return o;
    }


    public String[] getDigits() {
        return digits;
    }


    public int[] convertToDecimal() {
        int[] decimalNumbers = new int[digits.length];
        for (int index = 0; index < digits.length; index++) {
            int d = (int) (findIndex(valueTable, digits[index]) * Math.pow(base, (digits.length - index - 1)));
            decimalNumbers[index] = d;
        }

        return decimalNumbers;
    }


    public int getDecimalNumber() {
        int[] decimalNumbers = convertToDecimal();
        int decimalNumber = 0;
        for (int index = 0; index < decimalNumbers.length; index++) {
            decimalNumber += decimalNumbers[index];
        }

        return decimalNumber;
    }


    public int[] convertToBinary() {
        int decimalNumber = getDecimalNumber();
        int exponent = 0;
        while (decimalNumber >= Math.pow(2, exponent)) {
            exponent++;
        }


        int[] binaryNumbers = new int[exponent];
        for (int index = 0; index < binaryNumbers.length; index++) {
            if (decimalNumber >= Math.pow(2, exponent - index - 1)) {
                decimalNumber -= Math.pow(2, exponent - index - 1);
                binaryNumbers[index] = 1;
            } else {
                binaryNumbers[index] = 0;
            }
        }

        return binaryNumbers;
    }


    public String getBinaryNumber() {
        int[] binaryNumbers = convertToBinary();
        String o = "";
        for (int i = 0; i < binaryNumbers.length; i++) {
            o = o + binaryNumbers[i];
        }
        o = o + "\n";

        return o;
    }


    public int[] convertToOctal() {
        int decimalNumber = getDecimalNumber();
        int exponent = 0;
        while (decimalNumber >= Math.pow(8, exponent)) {
            exponent++;
        }


        int[] octalNumbers = new int[exponent];
        for (int index = 0; index < octalNumbers.length; index++) {
            while (decimalNumber >= Math.pow(8, exponent - index - 1)) {
                decimalNumber -= Math.pow(8, exponent - index - 1);
                octalNumbers[index] += 1;
            }
        }

        return octalNumbers;
    }


    public String getOctalNumber() {
        int[] octalNumbers = convertToOctal();
        String o = "";
        for (int i = 0; i < octalNumbers.length; i++) {
            o = o + octalNumbers[i];
        }
        o = o + "\n";

        return o;
    }


    public String[] convertToHexadecimal() {
        int decimalNumber = getDecimalNumber();
        int exponent = 0;
        while (decimalNumber >= Math.pow(16, exponent)) {
            exponent++;
        }


        String[] hexadeciamlNumbers = new String[exponent];
        for (int index = 0; index < hexadeciamlNumbers.length; index++) {
            int digitCount = 0;
            while (decimalNumber >= Math.pow(16, exponent - index - 1)) {
                decimalNumber -= Math.pow(16, exponent - index - 1);
                digitCount++;
            }
            hexadeciamlNumbers[index] = valueTable[digitCount];
        }

        return hexadeciamlNumbers;
    }


    public String getHexadeciamlNumber() {
        String[] hexadecimalNumbers = convertToHexadecimal();
        String o = "";
        for (int i = 0; i < hexadecimalNumbers.length; i++) {
            o = o + hexadecimalNumbers[i];
        }
        o = o + "\n";

        return o;
    }

    public String[] convertToAnyBase(int decimalNumber, int base) {
        int exponent = 0;
        while (decimalNumber >= Math.pow(base, exponent)) {
            exponent++;
        }


        String[] baseNumbers = new String[exponent];
        for (int index = 0; index < baseNumbers.length; index++) {
            int digitCount = 0;
            while (decimalNumber >= Math.pow(base, exponent - index - 1)) {
                decimalNumber -= Math.pow(base, exponent - index - 1);
                digitCount++;
            }
            baseNumbers[index] = valueTable[digitCount];
        }

        return baseNumbers;
    }


    public String getAnyBaseNumber(String[] bn) {
        String[] baseNumbers = bn;
        String o = "";
        for (int i = 0; i < baseNumbers.length; i++) {
            o = o + baseNumbers[i];
        }
        o = o + "\n";

        return o;
    }


    public static int findIndex(String arr[], String t)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(t)) {
                return i;
            }
        }

        return -1;
    }
}