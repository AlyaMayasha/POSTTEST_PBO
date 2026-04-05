package aksesorisrajut;

public class KeychainRajut extends Produk {

    private String bentuk;

    public KeychainRajut(String namaProduk, Kategori kategori, BahanRajut bahan, int harga, int stok, String bentuk) {
        super(namaProduk, kategori, bahan, harga, stok);
        this.bentuk = bentuk;
    }

    public String getBentuk() {
        return bentuk;
    }

    public void setBentuk(String bentuk) {
        this.bentuk = bentuk;
    }
}