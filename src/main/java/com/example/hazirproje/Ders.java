package com.example.hazirproje;

public abstract class Ders {
    private String dersAdi;
    private String dersIcerigi;
    private String dersKodu;
    private int dersKredisi;
    private int donemi;

    public Ders(String dersAdi, String dersIcerigi, String dersKodu, int dersKredisi, int donemi) {
        this.dersAdi = dersAdi;
        this.dersIcerigi = dersIcerigi;
        this.dersKodu = dersKodu;
        this.dersKredisi = dersKredisi;
        this.donemi = donemi;
    }

    public abstract void dersGoruntule();

    // Getter ve Setter metotları
    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public String getDersIcerigi() {
        return dersIcerigi;
    }

    public void setDersIcerigi(String dersIcerigi) {
        this.dersIcerigi = dersIcerigi;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public int getDersKredisi() {
        return dersKredisi;
    }

    public void setDersKredisi(int dersKredisi) {
        this.dersKredisi = dersKredisi;
    }

    public int getDonemi() {
        return donemi;
    }

    public void setDonemi(int donemi) {
        this.donemi = donemi;
    }
}

