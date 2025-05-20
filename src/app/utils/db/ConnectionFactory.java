package app.utils.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            System.out.println(">> Teste de conexão: buscando /db.properties");

            InputStream in = ConnectionFactory.class.getResourceAsStream("/db.properties");
            if (in == null) {
                throw new RuntimeException("Arquivo db.properties não encontrado no classpath!");
            }

            var props = new Properties();
            props.load(in);

            var url = props.getProperty("jdbc.url");
            var usr = props.getProperty("jdbc.user");
            var pwd = props.getProperty("jdbc.password");

            System.out.println(">> URL: " + url);
            System.out.println(">> Usuário: [" + usr + "]");
            System.out.println(">> Tentando conexão...");

            var conn = DriverManager.getConnection(url, usr, pwd);
            System.out.println(">> Conexão bem-sucedida.");
            conn.setAutoCommit(false);
            return conn;

        } catch (Exception e) {
            e.printStackTrace(); // <-- MOSTRA O ERRO REAL NO CONSOLE
            throw new DBException("Falha ao obter conexão", e);
        }
    }
}
