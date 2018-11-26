import java.util.ArrayList;

public interface Strategy<T> {

    public String calculateHeader(ArrayList<String> header);
    public String calculateRow(T t, int headerSize);





}
