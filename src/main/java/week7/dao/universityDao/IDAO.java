package week7.dao.universityDao;

import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public interface IDAO {

    public void add (Object o) throws SQLException;
    public void remove (Object o);
    public void showAll();
    public void update(Object o);



}
