package jSonParser;

import item.Item;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyJsonParser {
    public static final List<Item> itemList = new ArrayList<>();
    final static Logger logger = Logger.getLogger(MyJsonParser.class);

    public MyJsonParser() throws IOException {
    }

    public static List<Item> listOfItems()  {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("input2.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Object obj = null;
        try {
            obj = jsonParser.parse(fileReader);
            logger.info("The Json file was read");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JSONObject jsonObject = (JSONObject) obj;

        JSONObject js = (JSONObject) jsonObject.get(("config"));
        Object rows = js.get("rows");
        System.out.println(rows);
        Object columns = js.get("columns");
        System.out.println(columns);


        JSONArray itemsJson = (JSONArray) jsonObject.get(("items"));
        for (Object it : itemsJson) {
            JSONObject itemJsonObject = (JSONObject) it;

            String nameFromJson = (String) itemJsonObject.get("name");
            long amountFromJson = (Long) itemJsonObject.get("amount");
            String priceFromJson = (String) itemJsonObject.get("price");

            Item item = new Item(nameFromJson, (int) amountFromJson, priceFromJson);
            itemList.add(item);
        }
        logger.info("The items from JSon was inserted into list");
        return itemList;
    }


    public static void updateList(Item item, int amountForUpdate) {
        Scanner scanner1 = new Scanner(System.in);

//        System.out.println("enter rows");
//        int rows = scanner1.nextInt();
//        scanner1.nextLine();
//        System.out.println("enter columns");
//        String columns = scanner1.nextLine();
        int rows = 4;
        String columns = "8";
        JSONObject configs = new JSONObject();
        configs.put("rows", rows);
        configs.put("columns", columns);

        JSONArray array = new JSONArray();
        JSONObject alls = new JSONObject();
        alls.put("config", configs);

        String name;
        Integer amount;
        String price;
        Item newItem = null;
        JSONObject items = null;
        for (int i = 0; i < itemList.size(); i++) {
            name = itemList.get(i).getName();
            price = itemList.get(i).getPrice();

            if(itemList.get(i).equals(item)) {
                amount = amountForUpdate;
                newItem = new Item(name, amount, price);
            } else {
                amount = itemList.get(i).getAmount();
                newItem = new Item(name, amount, price);
            }

            items = new JSONObject();
            items.put("name", name);
            items.put("amount", amount);
            items.put("price", price);

            array.add(items);
            alls.put("items", array);
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("input2.json");
            logger.info("The Json file was updated");
        } catch (IOException e) {
            e.printStackTrace();
            logger.info(e);
        }
        try {
            fileWriter.write(alls.toJSONString());
        } catch (IOException e) {
            logger.info(e);
            e.printStackTrace();
        }

        try {
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
