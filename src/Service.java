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

    //производим вычисления с полученными числами
    static void performCalculations(String operator, int a, int b) throws Exception {
        System.out.print("Результат вычисления: ");
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
