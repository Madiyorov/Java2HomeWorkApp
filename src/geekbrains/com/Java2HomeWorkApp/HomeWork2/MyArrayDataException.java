package geekbrains.com.Java2HomeWorkApp.HomeWork2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int row, int col) {
        super(String.format("Невозможно получить число из элемента по адресу array[%d][%d]", row, col));
    }
}
