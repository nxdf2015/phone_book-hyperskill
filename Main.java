package phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String dataPath ="D:\\hyperskill\\phonebook\\";
        String directory = dataPath + "directory.txt";
        String findPath = dataPath + "find.txt";



            List<PhoneNumber> phoneList = new ArrayList<>();
            List<String> findList =null;

            try(BufferedReader reader = new BufferedReader(new FileReader(new File(directory))) ) {

                String line;
                Pattern  linePattern = Pattern.compile("(\\d+)\\s(.+)");

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

            try(BufferedReader reader = new BufferedReader(new FileReader(new File(findPath)))) {
                String line;
                findList = reader.lines().collect(Collectors.toList());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ISearch search = new TimeSearch(new Search(phoneList,findList));

            search.start();

    }
}
