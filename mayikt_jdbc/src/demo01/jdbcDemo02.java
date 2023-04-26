package demo01;

public class jdbcDemo02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");//反射机制
//        DriverManager.registerDriver(new Driver());
        /*
        * 1.Class.forName("com.mysql.jdbc.Driver")
        * 2.类加载器读取到com.mysql.jdbc.Driver
        * 3.Driver extends NonRegisteringDriver静态代码块
        * 4.静态代码块
        *  static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
    }
        * */
    }
}
