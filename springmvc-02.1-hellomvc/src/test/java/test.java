public class test {
   static boolean death = false;
    static void goDeeper() {
        if (death == true) {
            return;
        }
        goDeeper();
    }
    public static void main(String[] args) {
        goDeeper();
    }
}
