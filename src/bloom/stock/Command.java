package bloom.stock;

import java.util.ArrayList;

public interface Command {
    void execute();
    ArrayList<String> getOutput();
}
