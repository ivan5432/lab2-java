package lab2;

import java.io.File;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import lab2.lab2.Patient;
import lab2.lab2.Hospital;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerialazeXML implements Serialization {
    XmlMapper xmlMapper;
    public SerialazeXML() {
        this.xmlMapper = new XmlMapper();
    }
    public void serialaze(Hospital h, String f) throws IOException {
            xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            this.xmlMapper.writeValue(new File(f), h);
    }

    public Hospital deserialize(String f) throws IOException {
            return xmlMapper.readValue(new File(f), Hospital.class);
    }
}
