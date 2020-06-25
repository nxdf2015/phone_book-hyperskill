package phonebook;

import java.util.List;

public interface Operation {
    public void start();

    public List<PhoneNumber> getData();
}
