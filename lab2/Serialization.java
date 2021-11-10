package lab2;
import lab2.lab2.Patient;
import lab2.lab2.Hospital;

import java.io.IOException;

public interface Serialization  {
    public void serialaze(Hospital h, String f) throws IOException;
    public Hospital deserialize(String f) throws IOException;
}
