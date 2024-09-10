/* *****************************************************************************
 * Takes two names as command-line arguments and prints hello and goodbye
 * messages with the names for the hello message in the same order as the
 * command-line arguments and with the names for the goodbye message in reverse
 * order.
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
