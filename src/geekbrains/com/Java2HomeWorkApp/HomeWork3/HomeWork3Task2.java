package geekbrains.com.Java2HomeWorkApp.HomeWork3;

import java.util.Set;

public class HomeWork3Task2 {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ilyasov", "+99899-125-15-11");
        phoneBook.add("Ilyasov", "+99899-125-15-51");
        phoneBook.add("Ilyasov", "+99899-112-15-11");
        phoneBook.add("Eshov", "+99899-111-10-11");
        phoneBook.add("Madiyarov", "+99899-819-43-46");
        phoneBook.add("Turanov", "+99890-003-10-01");

        Set<String> surnames = phoneBook.allSurname();
        for (String surname : surnames) {
            System.out.printf("Ползователь %s имеет номер(а) телефонов %s %n", surname, phoneBook.get(surname));
        }
    }
}
