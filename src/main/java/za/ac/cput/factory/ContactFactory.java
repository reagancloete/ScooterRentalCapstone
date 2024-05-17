package za.ac.cput.factory;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;
public class ContactFactory {
    public static Contact buildContact(String email, String mobile, String workTel){
        if(
                Helper.testString(email)
                        && Helper.testString(mobile)
                        && Helper.testString(workTel)
                        && Helper.testEmail(email)
                        && Helper.testValidContact(mobile)
                        && Helper.testValidContact(workTel)
        ){
            return new Contact.Builder()
                    .setEmail(email)
                    .setMobile(mobile)
                    .setWorkTel(workTel)
                    .build();
        }
        return null;
    }

    public static Contact buildContact(String email){
        if(Helper.testEmail(email)){
            return new Contact.Builder().setEmail(email).build();
        }
        return null;
    }
}
