package online.tekwillacademy.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {

    public static CharSequence get;
    private static Faker fakerObject = new Faker();

    public static String getRandomEmail(){
        String email = fakerObject.internet().emailAddress();
        return email;

    }

    public static String getRandomFirstName(){
        return fakerObject.name().firstName();
    }

    public static String getRandomLastName(){
        return fakerObject.name().lastName();
    }

    public static String getRandomPassword(){
        return fakerObject.internet().password();
    }

    public static String getRandomPassword(int min, int max){
        return fakerObject.internet().password(min, max);
    }

    public static String getRandomPassword(int min, int max, boolean includeUpperCases, boolean includeSpecialCharacters){
        return fakerObject.internet().password(min, max, includeUpperCases,includeSpecialCharacters);
    }
}
