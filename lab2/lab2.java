package lab2;
// зробити колекції
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class lab2 {
    public static class Person{
        protected String firstName, middleName, lastName, address;
        protected int age;
        Person(String firstName, String middleName, String lastName,String address, int age){
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
            this.address=address;
            this.age=age;
        }
        public Person(){}
        public String getFirstName(){
            return this.firstName;
        }
        public String getMiddleName(){
            return this.middleName;
        }
        public String getLastName(){
            return this.lastName;
        }
        public String getAddress(){
            return this.address;
        }
        public int getAge(){
            return this.age;
        }
    }

    /**
     * Patient class. Inherited from Person.
     */
    public static class Patient extends Person implements Comparable<Patient>{
        String socialGroup, bloodGroup;
        private Patient(Builder b) {
            super(b.firstName, b.middleName, b.lastName,b.address, b.age);
            this.socialGroup=b.socialGroup;
            this.bloodGroup=b.bloodGroup;
        }
        public Patient(String fname, String mname, String lname, String add,Integer age, String sG, String bG){
            super(fname, mname, lname, add, age);
            this.socialGroup=sG;
            this.bloodGroup=bG;
        }
        public Patient(){
            super();
        }
        public String getSocialGroup(){return this.socialGroup;}
        public String getBloodGroup(){return this.bloodGroup;}

        @Override
        public int compareTo(Patient other){
            return Integer.compare(getAge(), other.getAge());
        }

        public static class Builder{
            private String firstName, middleName, lastName, socialGroup, bloodGroup, address;
            private int age;
            public Builder(){}
            public Builder setFirstName(String name){
                if (name.length()>0)
                    this.firstName = name;
                else
                    throw new IllegalArgumentException("Illegal Argument");
                return this;
            }
            public Builder setMiddleName(String name){
                if (name.length()>0)
                    this.middleName = name;
                else
                    throw new IllegalArgumentException("Illegal Argument");
                return this;
            }
            public Builder setLastName(String name){
                if (name.length()>0)
                    this.lastName = name;
                else
                    throw new IllegalArgumentException("Illegal Argument");
                return this;
            }
            public Builder setAddress(String address){
                if (address.length()>0)
                    this.address = address;
                else
                    throw new IllegalArgumentException("Illegal Argument");
                return this;
            }
            public Builder setBloodGroup(String blood_group){
                this.bloodGroup=blood_group;
                return this;
            }
            public Builder setSocialGroup(String social_group){
                this.socialGroup=social_group;
                return this;
            }
            public Builder setAge(int age){
                this.age=age;
                return this;
            }
            public Patient build(){
                return new Patient(this);
            }

        }

        @Override
        public String toString() {
            return  firstName + '\n' +
                    middleName + '\n' +
                    lastName + '\n' +
                    address + '\n' +
                    age + '\n' +
                    socialGroup + '\n' +
                    bloodGroup + '\n';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Patient patient = (Patient) o;
            return Objects.equals(firstName, patient.firstName) && Objects.equals(middleName, patient.middleName) &&Objects.equals(lastName, patient.lastName) &&Objects.equals(address, patient.address) &&Objects.equals(age, patient.age) && Objects.equals(socialGroup, patient.socialGroup) && Objects.equals(bloodGroup, patient.bloodGroup);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, middleName,lastName, address, age, bloodGroup);
        }
    }

    static class Hospital{
//        Patient[] patients[];
        List<Patient> patients= new ArrayList<>();
        String name;
        public Hospital(String name){
            this.name=name;
        }
        public Hospital(){}
        public void add_patient(Patient p){
            patients.add(p);
        }
        public void sort_p(){
            Collections.sort(patients);
        }
        public List<Patient> filter(){
            return null;
        }

        public void update(){

        }
    }

}
