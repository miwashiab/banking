package net.miwashi.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccountRepository {

    private static final String CREATE_TABLE_SQL = "CREATE TABLE ACCOUNT(ID BIGINT AUTO_INCREMENT, HOLDER VARCHAR(255), BALANCE INT DEFAULT 0)";
    private static final String CONNECTION_STRING_IM = "jdbc:h2:mem:";
    private static final String CONNECTION_STRING_FILE = "jdbc:h2:./account_db";

    public static boolean createTable(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_STRING_FILE);
            var stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS ACCOUNT");
            return stmt.execute(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }catch(Exception ignore){System.err.println(ignore);}
        }
        return false;
    }

    public Account create(Account account) {

        return account;
    }
}