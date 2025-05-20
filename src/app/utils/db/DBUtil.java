
package app.utils.db;
import java.sql.Connection;
public class DBUtil {
    public static void closeQuietly(AutoCloseable... res) {
        for (var r : res) try { if (r!=null) r.close(); } catch(Exception ignored){ }
    }
    public static void rollbackQuietly(Connection c) { try{ if(c!=null) c.rollback(); }catch(Exception ignored){} }
}
