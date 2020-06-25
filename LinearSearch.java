package phonebook;

import java.util.List;

public class LinearSearch  implements Operation  {
    private List<PhoneNumber> phoneList;
    private List<String> findList;
    private int countFind;
    public String nameOperation = "Linear search";
    public LinearSearch(List<PhoneNumber> phoneList, List<String> findList) {
        this.phoneList = phoneList;
        this.findList=findList;
    }



    @Override
    public void start(){
        countFind=0;
        for (String name : findList){
            for(PhoneNumber  item : phoneList){
                if (item.getName().equals(name)){
                    countFind++;
                    break;
                }
            }
        }
    }

    @Override
    public List<PhoneNumber> getData() {
        return phoneList;
    }



    @Override
    public String toString() {

        return  String.format("Found %d / %d entries",countFind,findList.size());
    }
}
