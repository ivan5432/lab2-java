package lab2;

import java.io.*;

import lab2.lab2.Patient;
import lab2.lab2.Hospital;
public class SerialazeTXT implements Serialization{
    public SerialazeTXT(){

    }
    public void serialaze(Hospital h, String f) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write(h.name+'\n');
        writer.write(Integer.toString(h.patients.size()));
        writer.write('\n');
        for (int i=0;i<4; i++){
            writer.write(h.patients.get(i).toString());
        }
        writer.close();

    }

    public Hospital deserialize(String f) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        Hospital h=new Hospital(br.readLine());
        int size=Integer.parseInt(br.readLine());
        for (int i=0; i<size; i++){
            h.add_patient(new Patient.Builder()
                    .setFirstName(br.readLine())
                    .setMiddleName(br.readLine())
                    .setLastName(br.readLine())
                    .setAddress(br.readLine())
                    .setAge(Integer.parseInt(br.readLine()))
                    .setSocialGroup(br.readLine())
                    .setBloodGroup(br.readLine()).build());
        }
        return h;
    }
}
