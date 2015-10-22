package week7.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class RanksTableCreator {
    private Connection connection;

    public RanksTableCreator(Connection connection) {
        this.connection = connection;
    }

    public void createRanksData() throws IOException, SQLException {
        ResultSet tableRS = connection.prepareStatement("SELECT st.student_id, stud.subject_id \n" +
                "FROM (student st JOIN student_group stgr ON st.group_id=stgr.student_group_id join study stud ON stgr.student_group_id=stud.group_id)").executeQuery();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/home/juff/Java/ArtCode/src/main/resources/university/ranks.unv")));
        while (tableRS.next()) {
            bufferedWriter.write(tableRS.getInt(1) + "\t" + tableRS.getInt(2) + "\t" + new Random().nextInt(10) + "\r\n");
            bufferedWriter.flush();
        }
    }
}
