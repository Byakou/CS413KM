package BankOfPhillipMa;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDemo {
    public static void main(String[] args) throws Exception {
        ObjectMapper om = new ObjectMapper();

        // 1. Object to JSON String
        User userObject = new User("John Doe", "jdoe@sfsu.edu");
        String jsonString = om.writeValueAsString(userObject);
        System.out.println("JSON String: " + jsonString);

        // 2. JSON String to Object
        User deserializedUser = om.readValue(jsonString, User.class);
        System.out.println(deserializedUser); 
    }
}
