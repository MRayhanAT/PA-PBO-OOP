import java.util.ArrayList;

public class App {
    protected ArrayList<String> usernames = new ArrayList<>();
    protected ArrayList<String> passwords = new ArrayList<>();
    protected ArrayList<String> roles = new ArrayList<>();
    protected ArrayList<Integer> ids = new ArrayList<>();
    protected ArrayList<String> emails = new ArrayList<>();
    protected ArrayList<String> nomorTelepons = new ArrayList<>();
    protected ArrayList<String> niks = new ArrayList<>();
    protected ArrayList<Pinjaman> pinjaman = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        boolean selesai = false;
        Integer adminExit = 0;
        Integer userExit = 0;
        Pengguna pengguna = new Pengguna();
        Admin admin = new Admin();
        User user = new User();
        do {
            adminExit = 0;
            userExit = 0;
            pengguna.setUsername(user.getUsernames());
            pengguna.setPasswords(user.getPasswords());
            pengguna.setRoles(user.getRoles());
            pengguna.setIds(user.getIds());
            pengguna.setEmails(user.getEmails());
            pengguna.setNomorTelepons(user.getNomorTelepons());
            pengguna.setNiks(user.getNiks());
            pengguna.setPinjaman(user.getPinjaman());
            pengguna.setPenggunaSekarang(user.getPenggunaSekarang());

            pengguna.setUsername(admin.getUsernames());
            pengguna.setPasswords(admin.getPasswords());
            pengguna.setRoles(admin.getRoles());
            pengguna.setIds(admin.getIds());
            pengguna.setEmails(admin.getEmails());
            pengguna.setNomorTelepons(admin.getNomorTelepons());
            pengguna.setNiks(admin.getNiks());
            pengguna.setPinjaman(admin.getPinjaman());
            pengguna.setPenggunaSekarang(admin.getPenggunaSekarang());

            Integer done = pengguna.Menu();
            if (done == 0) {
                selesai = true;
            } else if (done == 2) { // ke menu admin
                while (adminExit == 0) {
                    admin.setUsername(pengguna.getUsernames());
                    admin.setPasswords(pengguna.getPasswords());
                    admin.setRoles(pengguna.getRoles());
                    admin.setIds(pengguna.getIds());
                    admin.setEmails(pengguna.getEmails());
                    admin.setNomorTelepons(pengguna.getNomorTelepons());
                    admin.setNiks(pengguna.getNiks());
                    admin.setPinjaman(pengguna.getPinjaman());
                    admin.setPenggunaSekarang(pengguna.getPenggunaSekarang());
                    System.out.println("Selamat datang admin");
                    adminExit = admin.Menu();
                }
                done = 1;
            } else if (done == 3) { // ke menu user
                while (userExit == 0) {
                    user.setUsername(pengguna.getUsernames());
                    user.setPasswords(pengguna.getPasswords());
                    user.setRoles(pengguna.getRoles());
                    user.setIds(pengguna.getIds());
                    user.setEmails(pengguna.getEmails());
                    user.setNomorTelepons(pengguna.getNomorTelepons());
                    user.setNiks(pengguna.getNiks());
                    user.setPinjaman(pengguna.getPinjaman());
                    user.setPenggunaSekarang(pengguna.getPenggunaSekarang());
                    System.out.println("Selamat datang user");
                    userExit = user.Menu();
                }
                done = 1;
            }
        } while (selesai == false);
    }

}
