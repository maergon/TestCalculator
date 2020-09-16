import java.util.List;

public class Service {
    static int convertingToArabic(String number) {
        //получаем список римских цифр
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        int result = 0;

        //перебираем символы в обратном порядке от X до I
        while ((number.length() > 0) && (i < romanNumerals.size())) {
            //берем каждый римский символ
            RomanNumeral symbol = romanNumerals.get(i);
            //сверяем с полученым аргументом
            if (number.startsWith(symbol.name())) {
                //добавляем значение символа к общему результату
                result += symbol.getValue();
                //удаляем уже проверенный символ из полученного аргумента
                number = number.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    //производим вычисления с полученными числами
    static void performCalculations(String operator, int a, int b, boolean isRom) throws Exception {
        System.out.print("Результат вычисления: ");
        if (isRom){
            switch (operator) {
                case "+":
                    System.out.println(arabicToRoman(a + b));
                    break;
                case "-":
                    System.out.println(arabicToRoman(a - b));
                    break;
                case "*":
                    System.out.println(arabicToRoman(a * b));
                    break;
                case "/":
                    System.out.println(arabicToRoman(a / b));
                    break;
                default:
                    throw new Exception("Неверно введены данные");
            }
        } else {
            switch (operator) {
                case "+":
                    System.out.println(a + b);
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
                case "*":
                    System.out.println(a * b);
                    break;
                case "/":
                    System.out.println(a / b);
                    break;
                default:
                    throw new Exception("Неверно введены данные");
            }
        }
    }
}
