package phonebook;

import java.util.List;

public class BinarySearch implements Operation {
    private List<PhoneNumber> phoneNumbers;
    private List<String> findList;
    private int countFind;


    public BinarySearch(List<PhoneNumber> phoneNumbers,List<String> findList) {
        this.phoneNumbers = phoneNumbers;
        this.findList = findList;
    }

    @Override
    public void start() {
        countFind = 0;
        for (String name : findList){
            countFind += binarySearch(name)? 1 : 0;
        }

    }

    private boolean binarySearch(String name) {
        int middle ;
        int left = 0;
        int right = phoneNumbers.size() - 1;
        while (left <= right){
            middle = left + (right - left) / 2;
            String  namePivot = phoneNumbers.get(middle).getName();
            if (namePivot.equals(name)){
                return true;
            }
            else if(namePivot.compareTo(name) < 0){
                left = middle+1;
            }
            else {
                right = middle - 1;
            }
        }
        return false;
    }

    @Override
    public List<PhoneNumber> getData() {
        return phoneNumbers;
    }


    @Override
    public String toString() {

        return  String.format("Found %d / %d entries",countFind,findList.size());
    }

}
