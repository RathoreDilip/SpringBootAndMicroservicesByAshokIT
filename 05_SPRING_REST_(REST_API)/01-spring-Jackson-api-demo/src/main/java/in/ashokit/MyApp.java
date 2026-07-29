package in.ashokit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MyApp {

    public static void main(String[] args) throws IOException {
        MyApp app=new MyApp();
        app.convertJavaToJson();

        //app.convertJsonToJava();
    }

    public void convertJavaToJson() throws IOException {
        Customer customer=new Customer();

        customer.setId(1);
        customer.setName("Deep");
        customer.setPhno(524210l);
        customer.setGender("Male");

        // serialization
        System.out.println("Serialization started...");
        File file = new File("customer.json");

        // convert java object to jackson
        ObjectMapper objectMapper=new ObjectMapper();

        objectMapper.writeValue(file,customer); // objectMapper.writeValue(System.out,customer); -- on console

        String json = objectMapper.writeValueAsString(customer);

        System.out.println(json); // force new line
        System.out.println("Serialization completed...");

    }

    public void convertJsonToJava() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();

        // deserialization
        System.out.println("De-serialization started...");
        Customer customer = objectMapper.readValue(new File("customer.json"), Customer.class);

        System.out.println(customer);
        System.out.println("De-Serialization completed...");
    }

}
