import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class MyJsonParser {

    public static void updateList() throws IOException {


        Scanner scanner1 = new Scanner(System.in);

        System.out.println("enter rows");
        int rows = scanner1.nextInt();
        scanner1.nextLine();
        System.out.println("enter columns");
        String columns = scanner1.nextLine();


        JSONObject configs = new JSONObject();

        configs.put("rows", rows);

        configs.put("columns", columns);


        JSONArray array = new JSONArray();
        JSONObject alls = new JSONObject();
        alls.put("config", configs);


        for (int i = 0; i < rows; i++) {
            System.out.println("Enter name");
            String name = scanner1.nextLine();

            System.out.println("Enter amount");
            int amount = scanner1.nextInt();

            scanner1.nextLine();
            System.out.println("Enter price");
            String price = scanner1.nextLine();


            JSONObject items = new JSONObject();
            items.put("name", name);
            items.put("amount", amount);
            items.put("price", price);


            array.add(items);
            alls.put("items", array);

        }


        FileWriter fileWriter = new FileWriter("input3.json");
        fileWriter.write(alls.toJSONString());

        fileWriter.flush();
    }

    public static void showList() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("input2.json");

        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;

        JSONObject js = (JSONObject) jsonObject.get(("config"));
        Object rows = js.get("rows");
        System.out.println(rows);
        Object columns = js.get("columns");
        System.out.println(columns);


        JSONArray items = (JSONArray) jsonObject.get(("items"));
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

}
