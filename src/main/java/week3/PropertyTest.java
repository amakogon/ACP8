package week3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String path = "/home/amakogon/workspace/review/ACP8/target/classes/prices";
        File file = new File(PropertyTest.class.getClassLoader().getResource("prices").getFile());
        properties.load(new FileInputStream(path));

        System.out.println(properties.get("milk"));

    }
}
