package problems.lv2;

import java.util.*;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (i1, i2) -> i1.length() - i2.length());
        
        Set<String> prefixSet = new HashSet<>();
        Set<Integer> lengthSet = new HashSet<>();
        
        for (String phone : phone_book) {
            for (int len : lengthSet) {
                if (prefixSet.contains(phone.substring(0, len)))
                    return false;
            }
            prefixSet.add(phone);
            lengthSet.add(phone.length());
        }
        
        return true;
    }
}
