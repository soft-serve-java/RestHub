package statGen.src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;

import static javax.script.ScriptEngine.FILENAME;

public class DataGenerator {
    private static final String FILENAME = "populateForStatistic.sql";
    public static void generate() throws IOException {

        try (FileWriter fw =new FileWriter(FILENAME); BufferedWriter bw = new BufferedWriter(fw); Scanner in = new Scanner(new File("dishNames.txt"));
        ) {
            for (int i = 0; i < 100; i++) {
                String content = ("INSERT INTO rh.user(email, password, name, confirmationtoken, enabled) VALUES" +
                        "('user" + i + "@i.ua', '$2a$10$tkXKWLaylsMChogk6Ros.OXHjp5BDVpNlkuVFyrTJNjxjNtpu/6Gu'," +
                        "'user" + i + "', '123456', TRUE);\n");
                bw.write(content);
            }
            System.out.println("Done users");

            for (int i = 0; i < 50; i++) {
                Random random = new Random();
                int num = random.nextInt(3) + 1;
                String content = ("INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability\n" +
                        ", category_id) VALUES " +
                        "('"+ in.nextLine() + "', 'Fresh cauliflower florets buttermilk-battered and fried to a golden brown, then tossed in housemade Sriracha buffalo sauce and topped with a salad of celery, Gorgonzola and cilantro.'\n" +
                        ", 300, 1200, 3, 130, true," + num +");\n"+
                        "INSERT INTO rh.image (url, dish_id) VALUES ('/assets/images/Spicy%20buffalo%20Cauliflower.jpg', " +(i+7) +");\n");
                bw.write(content);
            }
            for (int i = 0; i < 1000; i++) {
                Random random = new Random();
                int num = random.nextInt(100) +1;
                int table = random.nextInt(8) + 1;
                long offset = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
                long end = Timestamp.valueOf("2018-04-01 00:00:00").getTime();
                long diff = end - offset + 1;
                Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
                String content = ("INSERT INTO rh.order(time, tablenumber, closed, user_id, waiter) VALUES ( '" +
                        rand+ "'," + table + ", TRUE," + num +", 3);\n");
                bw.write(content);
            }

            for (int i = 0; i < 3000; i++) {
                Random random = new Random();
                int quantity = random.nextInt(3) +1;
                int dish_id = random.nextInt(50) + 1;
                int order_id = random.nextInt(999) + 1;
                String content = ("INSERT INTO rh.orderdish(quantity, dish_id, status_id, order_id) VALUES ( '" +
                        quantity+ "'," + dish_id + ", 3," + order_id +");\n");
                bw.write(content);
            }


        }

    }
    }

