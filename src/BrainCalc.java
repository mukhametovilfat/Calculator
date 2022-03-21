public class BrainCalc {
    int num1, num2;
    String operator;

    // выполнение арифметического выражения
    private int calcExp(int n1, String op, int n2) {
        int res;
        if ("+".equals(op)) {
            res = n1 + n2;
        } else if ("-".equals(op)) {
            res = n1 - n2;
        } else if ("*".equals(op)) {
            res = n1 * n2;
        } else if ("/".equals(op)) {
            res = n1 / n2;
        } else {
            throw new AssertionError();
        }
        return res;
    }


    // метод с проверками и с выводом результата
    public String result(String str) throws CalcException {
        boolean isRoman;     // Признак, что числа римские
        Calc1 calc1 = new Calc1();

        // разбиваем исходное выражение String

        String[] arrayStr = str.split(" ");

        // проверка что создалось 3 элемента
        if (arrayStr.length != 3) {
            throw new CalcException("Выражение должно иметь вид: \"Число1 Операция Число2\", разделенные пробелом");
        }

        // проверка оператора, должен быть: + - * /
        if (calc1.checkOperator(arrayStr[1])) {
            operator = arrayStr[1];
        } else {
            throw new CalcException("Оператор \"" + arrayStr[1] + "\" не корректен, должен быть: + - * / ");
        }

        // проверка чисел, должны быть оба арабские или оба римские
        if (calc1.isNumeric(arrayStr[0]) && calc1.isNumeric(arrayStr[2])) {      // проверяем, что оба числа арабские
            num1 = Integer.parseInt(arrayStr[0]);
            num2 = Integer.parseInt(arrayStr[2]);
            isRoman = false;
        } else if (calc1.isRoman(arrayStr[0]) && calc1.isRoman(arrayStr[2])) {   // проверяем, что оба числа римские
            num1 = calc1.romanToNumber(arrayStr[0]);
            num2 = calc1.romanToNumber(arrayStr[2]);
            isRoman = true;
        } else {    // числа не соответствуют
            throw new CalcException("Числа должны быть оба арабские или оба римские");
        }

        // проверка чисел, должны быть от 1 до 10 включительно
        if (!(num1 >= 1 && num1 <= 10)) {
            throw new CalcException("Число #1 должно быть от 1 до 10 или от I до X включительно");
        }

        if (!(num2 >= 1 && num2 <= 10)) {
            throw new CalcException("Число #2 должно быть от 1 до 10 или от I до X включительно");
        }

        // получаем результат
        int res = calcExp(num1, operator, num2);

        // если числа римские, то конвертируем в римские и возвращаем результат
        if (isRoman) {
            return calc1.convertToRoman(res);
        }
        return String.valueOf(res);
    }
}
