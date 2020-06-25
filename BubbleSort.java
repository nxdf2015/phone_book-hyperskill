package phonebook;

import java.time.LocalTime;
import java.util.List;

public class BubbleSort implements Operation{
    private Data data;
    private LocalTime timeSearch;
    private boolean isSorted = false;
    private List<PhoneNumber> phoneNumberList;
    private LocalTime timeSort;

    public BubbleSort(Data data, LocalTime timeSearch) {
        this.data = data;
        this.timeSearch = timeSearch;
    }

    @Override
    public void start() {

            long  startTime = System.currentTimeMillis();
            LocalTime limit = LocalTime.of(0,timeSearch.getMinute()*10,timeSearch.getSecond()*10,0);

            phoneNumberList = data.getPhoneList();
            for(int i = 0;i <phoneNumberList.size();i++){
                for(int j = 0; j < phoneNumberList.size()-i-1;j++){
                    LocalTime time = LocalTime.ofNanoOfDay((System.currentTimeMillis() - startTime) * (long)Math.pow(10,6));

                    if (time.isAfter(limit)){
                        timeSort = LocalTime.ofNanoOfDay((System.currentTimeMillis() - startTime) * (long)Math.pow(10,6));
                        isSorted = false;
                        return ;
                    }
                    if (phoneNumberList.get(j).compareTo(phoneNumberList.get(j+1)) > 0){
                         PhoneNumber tmp = phoneNumberList.get(j);
                         phoneNumberList.set(j,phoneNumberList.get(j+1));
                         phoneNumberList.set(j+1,tmp);
                    }
                }

            }
            timeSort = LocalTime.ofNanoOfDay((System.currentTimeMillis() - startTime) * (long)Math.pow(10,6));
            isSorted = true;
        }



    @Override
    public String toString() {
        return String.format("Sorting time: %d min. %d sec. %d ms.",
                timeSort.getMinute(),timeSort.getSecond(),timeSort.getNano()/(long)Math.pow(10,6))
                + (isSorted ? "" : "- STOPPED, moved to linear search");
    }

    @Override
    public List<PhoneNumber> getData() {
        return phoneNumberList;
    }

    public LocalTime getTimeSort() {
        return timeSort;
    }

    public boolean isSorted() {
        return isSorted;
    }
}

