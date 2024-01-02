package com.example.hazirproje;

public class MevcutDers extends Ders {
    private String ogretimUyesi;

    public MevcutDers(String dersAdi, String dersIcerigi, String dersKodu, int dersKredisi, int donemi, String ogretimUyesi) {
        super(dersAdi, dersIcerigi, dersKodu, dersKredisi, donemi);
        this.ogretimUyesi = ogretimUyesi;
    }

    @Override
    public void dersGoruntule() {
        System.out.println("Ders Adı: " + getDersAdi());
        System.out.println("Ders İçeriği: " + getDersIcerigi());
        System.out.println("Ders Kodu: " + getDersKodu());
        System.out.println("Ders Kredisi: " + getDersKredisi());
        System.out.println("Dönemi: " + getDonemi());
        System.out.println("Öğretim Üyesi: " + getOgretimUyesi());
    }

    // Getter ve Setter metotları
    public String getOgretimUyesi() {
        return ogretimUyesi;
    }

    public void setOgretimUyesi(String ogretimUyesi) {
        this.ogretimUyesi = ogretimUyesi;
    }
}

