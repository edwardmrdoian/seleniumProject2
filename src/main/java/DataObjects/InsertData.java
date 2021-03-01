
package DataObjects;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class InsertData {
    Random random = new Random();
    int number= random.nextInt(1000);
     int low =10000,high=99999, zip, phone;
     String email,name,surname,passwd,address,city,state;

    public InsertData() {
        name = RandomStringUtils.randomAlphabetic(5);
        email+=number+"@gmail.com";
        surname = RandomStringUtils.randomAlphabetic(10);
        passwd = RandomStringUtils.randomAlphabetic(7);
        address = random.nextInt(10) +" "+ RandomStringUtils.randomAlphabetic(5) + "  street";
        city =  RandomStringUtils.randomAlphabetic(5);
        state = "California";
        zip = random.nextInt(high-low)+low;
        phone = random.nextInt(999999999-100000000)+100000000;
    }

    public  String getState() {
        return state;
    }

    public  int getZip() {
        return zip;
    }

    public  String  getPhone() {
        return String.valueOf(phone);
    }

    public  String getEmail() {return email=name+email;}

    public  String getName() {return name;}

    public  String getSurname() {
        return surname;
    }

    public  String getPasswd() {
        return passwd;
    }

    public  String getAddress() {
        return address;
    }

    public  String getCity() {
        return city;
    }
}