package DataProviders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class TestDataProvider {

    // user role, emp name, username, status, passwd, confirm pass
    // 6 columns and depending on how much data to send rows


    @DataProvider

    public static Object [][] getData(Method m) throws IOException, ParseException {
    //public static  Iterator<Object[]> getData(Method m){


        System.out.println("Running for method " +m.getName());

//        In the below example object array was filled with data and data provider would return Object[][]
//        Object [][] data = new Object[1][6];
//        data [0][0] = "1";
//        data [0][1] = "John Smith"; // in actual test scenario reading this name from employee info page
//        data [0][2] = "temp235";
//        data [0][3] = "1";
//        data [0][4] = "automation123";
//        data [0][5] = "automation123";
//        return data;

        // List of object array and here the iterator is returned from data provider

//        System.out.println("Running using Arraylist of objects...");
//        ArrayList<Object[]> testData = new ArrayList<>();
//        Object ob[] ={"1","John Smith","temp235","1","automation123","automation123"};
//        testData.add(ob);
//        ob = new Object[]{"0", "John Smith", "temp456", "0", "automation678", "automation678"};
//        testData.add(ob);
//
//        return testData.iterator();

        //using hash map instead of object array so that the num of columns if changed in the excel sheet or json won't cause issur '

        // 1) Reading data from json and putting it in hashmap and putting that hashmap in object array


        String path_sys_data = System.getProperty("user.dir")+"/src/main/resources/test.json";
        FileReader reader = new FileReader(path_sys_data);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(reader);

        JSONArray arr_data = (JSONArray) json.get("data");
        System.out.println("array of all tests" +arr_data);

        Object [][] obj = new Object[arr_data.size()][1];

        System.out.println("array size " +arr_data.size());
        for(int i=0 ; i< arr_data.size(); i++){
            Map maps = new HashMap();
            JSONObject object = (JSONObject) arr_data.get(i);
            Set<String> keys = object.keySet();
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()){
                String key = (String) iterator.next();
                String val = (String) object.get(key);
                maps.put(key,val);
            }
            obj[i][0] = maps;
        }
        return obj;
    }

}
