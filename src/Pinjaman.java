public class Pinjaman {
    private int jumlahPinjaman;
    private int jangkaWaktuPinjaman;
    private double bungaPinjaman;
    private String statusPinjaman;

    public void catatPembayaran(double jumlahPembayaran) {
        System.out.println("Pembayaran: $" + jumlahPembayaran);
    }

    public Pinjaman(int jumlahPinjaman, int jangkaWaktuPinjaman, double bungaPinjaman, String statusPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
        this.jangkaWaktuPinjaman = jangkaWaktuPinjaman;
        this.bungaPinjaman = bungaPinjaman;
        this.statusPinjaman = "Pending"; 
    }

    public int getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void setJumlahPinjaman(int jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public int getJangkaWaktuPinjaman() {
        return jangkaWaktuPinjaman;
    }

    public void setJangkaWaktuPinjaman(int jangkaWaktuPinjaman) {
        this.jangkaWaktuPinjaman = jangkaWaktuPinjaman;
    }

    public double getBungaPinjaman() {
        return bungaPinjaman;
    }

    public void setBungaPinjaman(double bungaPinjaman) {
        this.bungaPinjaman = bungaPinjaman;
    }

    public String getStatuspinjaman() {
        return statusPinjaman;
    }

    public void setStatusPinjaman(String statusPinjaman) {
        this.statusPinjaman = statusPinjaman;
    }
}
