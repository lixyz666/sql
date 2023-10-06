import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<SqlData> sql = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("操作名称: ");
            String action = scanner.nextLine();
            
            if (action.equals("添加")) {
                interest(sql);
            } else if (action.equals("删除")) {
                remove(sql);
            } else if (action.equals("搜索")) {
                search(sql);
            } else if (action.equals("更新")) {
                update(sql);
            } else if (action.equals("退出")) {
                break;
            } else {
                System.out.println("无效操作");
            }
        }
    }

    public static void interest(List<SqlData> sql) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("表名： ");
        String table = scanner.nextLine();
        System.out.print("值: ");
        String value = scanner.nextLine();
        System.out.print("定义: ");
        String var = scanner.nextLine();
        sql.add(new SqlData(table, value, var));
    }

    public static void remove(List<SqlData> sql) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("删除什么值: ");
        int sqlremove = Integer.parseInt(scanner.nextLine());
        
        if (sqlremove >= 0 && sqlremove < sql.size()) {
            SqlData data = sql.remove(sqlremove);
            System.out.println(data);
        } else {
            System.out.println("无效索引");
        }
    }

    public static void search(List<SqlData> sql) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("表名: ");
        String table = scanner.nextLine();
        
        for (SqlData data : sql) {
            if (data.getTable().equals(table)) {
                System.out.println(data);
            }
        }
    }

    public static void update(List<SqlData> sql) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("表名: ");
        String table = scanner.nextLine();
        System.out.print("新的值: ");
        String newdb = scanner.nextLine();
        
        for (int i = 0; i < sql.size(); i++) {
            SqlData data = sql.get(i);
            
            if (data.getTable().equals(table)) {
                sql.set(i, new SqlData(table, newdb, data.getVar()));
                System.out.println("=> " + sql.get(i));
            }
        }
    }

    static class SqlData {
        private String table;
        private String value;
        private String var;

        public SqlData(String table, String value, String var) {
            this.table = table;
            this.value = value;
            this.var = var;
        }

        public String getTable() {
            return table;
        }

        public String getValue() {
            return value;
        }

        public String getVar() {
            return var;
        }

        @Override
        public String toString() {
            return table + " " + value + " " + var;
        }
    }
}
