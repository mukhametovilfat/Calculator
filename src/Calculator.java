
import java.util.Scanner;


public class Calculator {

    public static void main(String[] args) {
        try {
            System.out.println("Введите два числа и знак операции\"(+-/*)\" через пробел.");
            System.out.println("Не ошибитесь, арабские или римские цифры вместе писать нельзя.");
            System.out.print("Ввод: ");
            Scanner sc = new Scanner(System.in);
            String strInput = sc.nextLine();

            BrainCalc brainCalc = new BrainCalc();
            String result = brainCalc.result(strInput);
            System.out.println("Ответ: " + result);
        } catch (CalcException e) {
            System.out.println("Пробуем еще!");
        }
    }
}