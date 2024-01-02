package com.example.hazirproje;

public class GecilmisDers extends Ders {
    private int vize;
    private int finall;
    private double ortalama;
    private String harfNotu;

    public GecilmisDers(String dersAdi, String dersIcerigi, String dersKodu, int dersKredisi, int donemi,
                        int vize, int finall) {
        super(dersAdi, dersIcerigi, dersKodu, dersKredisi, donemi);
        this.vize = vize;
        this.finall = finall;
        ortalamaHesapla();  // Ortalamayı hemen hesapla
        harfNotuHesapla();  // Harf notunu hemen hesapla
    }

    @Override
    public void dersGoruntule() {
        System.out.println("Ders Adı: " + getDersAdi());
        System.out.println("Ders İçeriği: " + getDersIcerigi());
        System.out.println("Ders Kodu: " + getDersKodu());
        System.out.println("Ders Kredisi: " + getDersKredisi());
        System.out.println("Dönemi: " + getDonemi());
        System.out.println("Vize: " + getVize());
        System.out.println("Final: " + getFinall());
        System.out.println("Ortalama: " + getOrtalama());
        System.out.println("Harf Notu: " + getHarfNotu());
    }

    // Ortalamayı hesaplayan metod
    public void ortalamaHesapla() {
        ortalama = (vize * 0.4) + (finall * 0.6);
    }

    // Harf notunu hesaplayan metod
    public void harfNotuHesapla() {
        if (ortalama >= 90) {
            harfNotu = "AA";
        } else if (ortalama >= 80) {
            harfNotu = "BA";
        } else if (ortalama >= 70) {
            harfNotu = "BB";
        } else if (ortalama >= 60) {
            harfNotu = "CB";
        } else if (ortalama >= 50) {
            harfNotu = "CC";
        } else {
            harfNotu = "FF";
        }
    }

    // Getter ve Setter metotları
    public int getVize() {
        return vize;
    }

    public void setVize(int vize) {
        this.vize = vize;
        ortalamaHesapla();  // Vize değişirse ortalamayı güncelle
        harfNotuHesapla();  // Vize değişirse harf notunu güncelle
    }

    public int getFinall() {
        return finall;
    }

    public void setFinall(int finall) {
        this.finall = finall;
        ortalamaHesapla();  // Final değişirse ortalamayı güncelle
        harfNotuHesapla();  // Final değişirse harf notunu güncelle
    }

    public double getOrtalama() {
        return ortalama;
    }

    public String getHarfNotu() {
        return harfNotu;
    }
}

