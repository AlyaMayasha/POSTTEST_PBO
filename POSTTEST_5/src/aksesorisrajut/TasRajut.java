package aksesorisrajut;

public class TasRajut extends Produk {

    private String model;

    public TasRajut(String namaProduk, Kategori kategori, BahanRajut bahan, int harga, int stok, String model) {
        super(namaProduk, kategori, bahan, harga, stok);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getJenisProduk() {
        return "Tas Rajut";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Model        : " + model);
    }
}