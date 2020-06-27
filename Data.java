package phonebook;

import kotlin.jvm.internal.SpreadBuilder;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.System.currentTimeMillis;


public class Data {

    public static List<PhoneNumber> phoneList;
    private final String findPath;
    private List<String> findList;
    private String directory;
    private LocalTime timeSearch;
    private LocalTime timeSort;

    public Data(String directory,String findPath) {
        this.directory = directory;
        this.findPath = findPath;
        this.phoneList=new ArrayList<>();
        this.findList = new ArrayList<>();
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList.subList(0,phoneList.size()-1);
    }
    public void setTimeSearch(LocalTime timeSearch){
        this.timeSearch = timeSearch;
    }

    public void get(){
        getData();
        getListToFind();
    }
    private void getData(){
        if (!phoneList.isEmpty())
            return;

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(directory))) ) {

            String line;
            Pattern linePattern = Pattern.compile("(\\d+)\\s(.+)");

            while((line  = reader.readLine())!= null)
            {
                Matcher matcher = linePattern.matcher(line);
                matcher.matches();

                String number = matcher.group(1);
                String name = matcher.group(2);
                phoneList.add(new PhoneNumber(number,name));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void getListToFind(){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(findPath)))) {
            String line;
            findList =  reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String name(int i){
        return phoneList.get(i).getName();
    }




    public List<String> getFindList() {
        return findList;
    }
}
