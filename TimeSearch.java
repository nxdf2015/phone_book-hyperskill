package phonebook;

import java.time.LocalTime;

public class TimeSearch implements ISearch{
    private ISearch search;

    public TimeSearch(ISearch search) {
        this.search = search;
    }

    @Override
    public void start() {
        long startTime = System.currentTimeMillis();
        System.out.println("start searching...");
        search.start();
        long endTime = System.currentTimeMillis();
        LocalTime timeSearch = LocalTime.ofNanoOfDay((endTime - startTime) * (long)Math.pow(10,6));
        long second = timeSearch.getSecond();
        long minute = timeSearch.getMinute();
        long millisecond = timeSearch.getNano()/(long)Math.pow(10,6);

        System.out.printf("Found %d/%d entries. Time taken %d min. %d sec. %d ms. ",getCountFind(),getTotalSearch(),minute,second,millisecond);
    }

    @Override
    public int getCountFind() {
        return search.getCountFind();
    }

    @Override
    public int getTotalSearch() {
        return search.getTotalSearch();
    }
}
