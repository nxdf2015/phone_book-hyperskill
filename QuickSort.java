package phonebook;

import java.time.LocalTime;
import java.util.List;



public class QuickSort implements  Operation{
    private List<PhoneNumber> phoneNumbers;
    private LocalTime timeSort;

    public QuickSort(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public void start() {
        long  startTime = System.currentTimeMillis();

        sort(0,phoneNumbers.size()-1);
        timeSort  = LocalTime.ofNanoOfDay((System.currentTimeMillis() - startTime) * (long)Math.pow(10,6));

    }

    private void sort(int first, int last){
        if ((last > first  )){
            PhoneNumber pivot = phoneNumbers.get(last);

            int indexPartition = first;
            for(int i = first ; i <= last  - 1 ; i++){
                if (phoneNumbers.get(i).compareTo(pivot) < 0){
                    PhoneNumber temp = phoneNumbers.get(i);
                    phoneNumbers.set(i,phoneNumbers.get(indexPartition));
                    phoneNumbers.set(indexPartition,temp);
                    indexPartition++;

                }
            }

            PhoneNumber temp = phoneNumbers.get(indexPartition);
            phoneNumbers.set(indexPartition,phoneNumbers.get(last));
            phoneNumbers.set(last,temp);

            sort(first,indexPartition-1);
            sort(indexPartition+1,last);
        }
    }

    @Override
    public List<PhoneNumber> getData() {
        return phoneNumbers;
    }

    public LocalTime getTimeSort() {
        return timeSort;
    }
    @Override
    public String toString() {
        return String.format("Sorting time: %d min. %d sec. %d ms.",
                timeSort.getMinute(),timeSort.getSecond(),timeSort.getNano()/(long)Math.pow(10,6));
    }
}
