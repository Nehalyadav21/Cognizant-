public class SingletonTest {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");

        System.out.println("logger1 hashCode:" +  logger1.hashCode());
        System.out.println("logger2 hashCode:" +  logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Only one logger instance exists.");
        } else {
            System.out.println("Multiple logger instances exists.");
        }
    }
}
