package phonebook;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class TimeSearch implements Operation {
    private Operation search;
    private LocalTime timeSearch;
    private LocalTime timeSort = LocalTime.of(0,0,0,0);

    public TimeSearch(Operation search) {
        this.search = search;
    }

    @Override
    public void start() {
        long startTime = System.currentTimeMillis();
      //  System.out.println("start searching...");
        search.start();
        long endTime = System.currentTimeMillis();
        timeSearch = LocalTime.ofNanoOfDay((endTime - startTime) * (long)Math.pow(10,6));

    }



    @Override
    public List<PhoneNumber> getData() {
        return null;
    }

    @Override
    public String toString() {
        Duration d = Duration.ZERO.plusSeconds(timeSort.getSecond())
                .plusMinutes(timeSort.getMinute())
                .plusMillis(timeSort.getNano()/100000);
        LocalTime totalTime=  (LocalTime) d.addTo(timeSearch);
        long second = totalTime.getSecond();
        long minute = totalTime.getMinute();
        long millisecond = totalTime.getNano()/(long)Math.pow(10,6);

        return search.toString() + String.format(" Time taken %d min. %d sec. %d ms. ",minute,second,millisecond);
    }

    public void addTimeToSort(LocalTime timeSort){
        this.timeSort = timeSort;
    }
    public LocalTime getTimeSearch() {
        return timeSearch;
    }


}
