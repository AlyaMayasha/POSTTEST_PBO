package aksesorisrajut;

public class BonekaRajut extends Produk {

    private String karakter;

    public BonekaRajut(String namaProduk, Kategori kategori, BahanRajut bahan, int harga, int stok, String karakter) {
        super(namaProduk, kategori, bahan, harga, stok);
        this.karakter = karakter;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }
}