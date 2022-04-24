package geekbrains.com.Java2HomeWorkApp.HomeWork3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, Set<String>> phonesBySurname = new TreeMap<>();

    public void add(String surname, String phoneNumber) {
        Set<String> phones = phonesBySurname.get(surname);
        if (phones == null) {
            Set<String> phonesSet = new HashSet<>();
            phonesSet.add(phoneNumber);
            phonesBySurname.put(surname, phonesSet);
        } else {
            phones.add(phoneNumber);
            phonesBySurname.put(surname, phones);
        }
    }

    public Set<String> get(String surname) {
        return phonesBySurname.get(surname);
    }

    public Set<String> allSurname() {
        return phonesBySurname.keySet();
    }
}
