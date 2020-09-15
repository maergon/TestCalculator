import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        //считываем с консоли значение
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        //переводим в верхний регистр, для римских цифр
        String inputStringWithArgs = str.toUpperCase();

        //получаем аргументы из строки
        String[] subStr = inputStringWithArgs.split(" ");
        String[] numbers = new String[]{"I", "IV", "V", "IX", "X"};

        //Римские цифры
        String rom_a = subStr[0];
        String rom_b = subStr[2];
        String rom_operator = subStr[1];

        //проверяем входные параметры, на соответствие римским или арабским цифрам
        if (
                Arrays.asList(numbers).contains(rom_a) &&
                        Arrays.asList(numbers).contains(rom_b)
        ) {
            Utils.informationLine(rom_a, rom_b, rom_operator); //пояснительная строка
            //произведение расчетов
            Service.performCalculations(
                    rom_operator,
                    Service.convertingToArabic(rom_a),
                    Service.convertingToArabic(rom_b)
            );
        } else {
            //Арабские цифры
            int a = Integer.parseInt(subStr[0]);
            int b = Integer.parseInt(subStr[2]);
            String operator = subStr[1];

            //задаем границы чисел для расчетов от 1 до 10
            if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
                Utils.informationLine(String.valueOf(a), String.valueOf(b), operator);
                Service.performCalculations(operator, a, b);
            } else {
                throw new Exception("Данные не соотвествуют формату в диапазоне от 1 до 10");
            }
        }
    }
}
