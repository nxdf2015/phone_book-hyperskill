package phonebook;

import java.util.List;

public class Search implements ISearch {
    private List<PhoneNumber> phoneList;
    private List<String> findList;
    private int countFind;

    public Search(List<PhoneNumber> phoneList, List<String> findList) {
        this.phoneList = phoneList;
        this.findList=findList;
    }

    @Override
    public int getCountFind() {
        return countFind;
    }

    @Override
    public int getTotalSearch(){
        return findList.size();
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
}
