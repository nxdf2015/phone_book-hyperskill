package phonebook;

import java.util.List;

public class JumpSearch implements Operation {
    private List<PhoneNumber> phoneList;
    private List<String> findList;
    private int countFind;

    public JumpSearch(List<PhoneNumber> phoneList, List<String> findList) {
        this.phoneList = phoneList;
        this.findList = findList;
    }




    private int sizeBlock(){
        return (int)Math.sqrt(phoneList.size());
    }
    private boolean isSorted(){
        boolean sorted=false;
        for(int i = 0 ; i < phoneList.size()-1;i++){
            if (phoneList.get(i).getName().compareTo(phoneList.get(i+1).getName())>  0){
                return false;
            }
        }
        return true;
    }
    public boolean find(String name) {
        int rightBlock = 0;

        while(rightBlock < phoneList.size()){

            if (phoneList.get(rightBlock).getName().compareTo(name) > 0){
                break;
            }
            rightBlock = rightBlock + sizeBlock();
        }



        for(int i = rightBlock - sizeBlock() ; i < phoneList.size() ; i++){
            if (phoneList.get(rightBlock).getName().equals(name) ){
                return true;
            }
        }
        return false;
    }

    @Override
    public void start() {
        countFind = 0;
        for(String name : findList){
            if (find(name)){
                countFind++;
            }
        }
    }



    @Override
    public List<PhoneNumber> getData() {
        return phoneList;
    }

//    @Override
//    public String toString() {
//        return "Searching time: ";
//    }
@Override
public String toString() {

    return  String.format("Found %d / %d entries",countFind,findList.size());
}
}
