public class App {
    public static void main(String[] args) throws Exception {

        boolean selesai = false;
        Integer adminExit = 0;
        Integer userExit = 0;
        Pengguna pengguna = new Pengguna();
        admin admin = new admin();
        user user = new user();
        do {
            adminExit = 0;
            userExit = 0;
            Integer done = pengguna.Menu();
            if (done == 0) { // exit
                selesai = true;
            } else if (done == 2) { // ke menu admin
                while (adminExit == 0) {
                    System.out.println("Selamat datang admin");
                    adminExit = admin.Menu();
                }
                done = 1; // Set done to 1 to prevent returning to user menu

            } else if (done == 3) { // ke menu user
                while (userExit == 0) {
                    System.out.println("Selamat datang user");
                    userExit = user.Menu();
                }
                done = 1; // Set done to 1 to prevent returning to admin menu
            }
        } while (selesai == false);
    }
}
