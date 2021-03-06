package phonebook;

import java.io.*;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String dataPath ="D:\\hyperskill\\phonebook\\";
        String directory = dataPath + "directory.txt";
        String findPath = dataPath + "find.txt";




            List<String> findList =null;

            Data data =new Data(directory,findPath);
            data.get();



            TimeSearch search = new TimeSearch(new LinearSearch(data.getPhoneList(),data.getFindList()));

            System.out.println("Start searching (linear search)...");
            search.start();

            System.out.println(search);
            System.out.println();


            LocalTime timeSearch = search.getTimeSearch();
            LocalTime timeSort;
            LocalTime totalSearch;
            data.setTimeSearch(timeSearch);


            System.out.println("Start searching (bubble sort + jump search)...");

            BubbleSort bubbleSort = new BubbleSort(data,timeSearch);
            bubbleSort.start();
            Operation operation;

            if (bubbleSort.isSorted()){
                operation = new JumpSearch(bubbleSort.getData(),data.getFindList());

            }
            else{
               operation = new LinearSearch(bubbleSort.getData(),data.getFindList());
            }
            search = new TimeSearch(operation);

            search.start();

            search.addTimeToSort(bubbleSort.getTimeSort());

        System.out.println(search);
        System.out.println(bubbleSort);
          timeSearch = search.getTimeSearch();

        System.out.println("Searching time: "+ String.format("%d min. %d sec. %d ms.",timeSearch.getMinute(),timeSearch.getSecond(),
                timeSearch.getNano()/(long)Math.pow(10,6)));

        System.out.println();
        System.out.println("Start searching (quick sort + binary search)...");
        QuickSort quickSort = new QuickSort(data.getPhoneList());
        quickSort.start();

        Operation binarySearch = new BinarySearch(quickSort.getData(),data.getFindList());

        search = new TimeSearch(binarySearch);
        search.start();
        search.addTimeToSort(quickSort.getTimeSort());

        timeSearch = search.getTimeSearch();
        System.out.println(search);
        System.out.println(quickSort);
        System.out.println("Searching time: "+ String.format("%d min. %d sec. %d ms.",timeSearch.getMinute(),timeSearch.getSecond(),
                timeSearch.getNano()/(long)Math.pow(10,6)));


    }
}
