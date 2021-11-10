package lab2;

import lab2.lab2.Patient;
import lab2.lab2.Hospital;

public class Main {
    public static void main(String[] args)  {
        Patient p1 = new Patient.Builder()
                .setFirstName("FName1")
                .setMiddleName("MName1")
                .setLastName("LName1")
                .setAddress("address1")
                .setAge(30)
                .setSocialGroup("Group1")
                .setBloodGroup("A0").build();
        Patient p2 = new Patient.Builder()
                .setFirstName("FName2")
                .setMiddleName("MName2")
                .setLastName("LName2")
                .setAddress("address2")
                .setAge(30)
                .setSocialGroup("Group2")
                .setBloodGroup("A0").build();
        Patient p3 = new Patient.Builder()
                .setFirstName("FName3")
                .setMiddleName("MName3")
                .setLastName("LName3")
                .setAddress("address3")
                .setAge(30)
                .setSocialGroup("Group3")
                .setBloodGroup("A0").build();
        Patient p4 = new Patient.Builder()
                .setFirstName("FName4")
                .setMiddleName("MName4")
                .setLastName("LName4")
                .setAddress("address4")
                .setAge(30)
                .setSocialGroup("Group4")
                .setBloodGroup("A0").build();
        Hospital h=new Hospital("Hospital");
        h.add_patient(p1);
        h.add_patient(p2);
        h.add_patient(p3);
        h.add_patient(p4);


        SerialazeXML sxml=new SerialazeXML();
        SerialazeJSON sjson=new SerialazeJSON();
        SerialazeTXT stxt=new SerialazeTXT();

        try {
            sxml.serialaze(h, "D:\\projects\\sem5\\projects\\java\\serialization_lab2\\hospital.xml");
            System.out.println("Xml serialized");
            sjson.serialaze(h, "D:\\projects\\sem5\\projects\\java\\serialization_lab2\\hospital.json");
            System.out.println("Json serialized");
            stxt.serialaze(h, "D:\\projects\\sem5\\projects\\java\\serialization_lab2\\hospital.txt");
            System.out.println("Txt serialized");

            Hospital h1=sxml.deserialize("D:\\projects\\sem5\\projects\\java\\serialization_lab2\\hospital.xml");
            System.out.println("Xml deserialized");
            System.out.println(h1.name);

            for (int i=0; i<4; i++){
                System.out.println(h1.patients.get(i).toString());
            }
            Hospital h2=sjson.deserialize("D:\\projects\\sem5\\projects\\java\\serialization_lab2\\hospital.json");
            System.out.println("Json deserialized");
            System.out.println(h2.name);

            for (int i=0; i<4; i++){
                System.out.println(h2.patients.get(i).toString());
            }
            Hospital h3=stxt.deserialize("D:\\projects\\sem5\\projects\\java\\serialization_lab2\\hospital.txt");
            System.out.println("Txt deserialized");
            System.out.println(h3.name);

            for (int i=0; i<4; i++){
                System.out.println(h3.patients.get(i).toString());
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
//            System.out.print("error");
        }
    }
}
