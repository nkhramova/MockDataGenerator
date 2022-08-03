import com.github.javafaker.Faker;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        int num = getNumber();
        getMockData(num);
    }

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of identities to create \n");
        return sc.nextInt();
    }

    public static void getMockData(int num) {
        DataFactory df = new DataFactory();
        Faker faker = new Faker();

        for (int i = 0; i < num; i++) {
            StringJoiner joiner = new StringJoiner(", ");
            String email = faker.internet().emailAddress();
            String firstName = df.getFirstName();
            String lastName = df.getLastName();
            String city = df.getCity();
            String country = faker.address().country();
            String id = df.getNumberText(9);
            String joinedString = joiner.add(email).add(firstName).add(lastName).add(city).add(country).add(id).toString();
            System.out.print("\n" + joinedString);
        }
    }
}
