package practice7;

public class Task13 {

    private String table;
    private String fields = "*";
    private String whereClause = "";

    public Task13(String table) {
        this.table = table;
    }

    public Task13 select(String fields) {
        this.fields = fields;
        return this;
    }

    public Task13 where(String condition) {
        this.whereClause = condition;
        return this;
    }

    public String build() {
        String sql = "SELECT " + fields + " FROM " + table;
        if (!whereClause.isEmpty()) {
            sql += " WHERE " + whereClause;
        }
        return sql + ";";
    }

    public static void main(String[] args) {
        String sql1 = new Task13("users").select("id, name, email").where("age >= 18").build();
        String sql2 = new Task13("products").build();
        String sql3 = new Task13("orders").where("total > 1000").build();

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }
}
