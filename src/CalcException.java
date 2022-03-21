public class CalcException extends Exception {
    public CalcException() {
        System.out.println("Ошибка!");
    }

    public CalcException(String message){
        this();
        System.out.println(message);
    }
}
