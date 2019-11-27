import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("util: " + date);

        java.sql.Date dateSQL = new java.sql.Date(2001);

        System.out.println("sql: " + dateSQL);

        System.out.println(java.sql.Date.valueOf("2001-01-02"));



    }
}
