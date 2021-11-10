package lab2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import lab2.lab2.Patient;
import lab2.lab2.Hospital;

public class SerialazeJSON implements Serialization {
    Gson gson;
    public SerialazeJSON(){
        gson=new GsonBuilder().setPrettyPrinting().create();
    }

    public void serialaze(Hospital h, String f)throws IOException  {

        FileWriter writer=new FileWriter(f);
        gson.toJson(h, writer);
        writer.flush();
        writer.close();;
    }
    public Hospital deserialize(String f)throws IOException {
        return gson.fromJson(new FileReader(f), Hospital.class);
    }
}
