package com.example.hazirproje;

public class Ogrenci {
    private String adi;
    private String soyad;
    private String numara;
    private String bolum;
    private String TC;
    private DersListesi dersListesi;  // Ogrenci'nin ders listesi

    public static final Ogrenci instance = new Ogrenci();

    public static Ogrenci getInstance(){
        return instance;
    }

    // Constructor - Yerli öğrenci
    public Ogrenci(String adi, String soyad, String numara, String bolum, String TC) {
        this.adi = adi;
        this.soyad = soyad;
        this.numara = numara;
        this.bolum = bolum;
        this.TC = TC;
        this.dersListesi = new DersListesi();  // Yeni bir ders listesi oluştur
    }

    // Constructor - Yabancı öğrenci
    public Ogrenci(String adi, String soyad, String numara, String bolum) {
        this.adi = adi;
        this.soyad = soyad;
        this.numara = numara;
        this.bolum = bolum;
        this.dersListesi = new DersListesi();  // Yeni bir ders listesi oluştur
    }

    public Ogrenci() {
        dersListesi = new DersListesi();
    }

    // Mevcut ders ekleme
    public void mevcutDersEkle(String dersAdi, String dersIcerigi, String dersKodu, int dersKredisi, int donemi, String ogretimUyesi) {
        MevcutDers mevcutDers = new MevcutDers(dersAdi, dersIcerigi, dersKodu, dersKredisi, donemi, ogretimUyesi);
        dersListesi.mevcutDersEkle(mevcutDers);
    }

    // Geçilmiş ders ekleme
    public void gecilmisDersEkle(String dersAdi, String dersIcerigi, String dersKodu, int dersKredisi, int donemi, int vize, int finall) {
        GecilmisDers gecilmisDers = new GecilmisDers(dersAdi, dersIcerigi, dersKodu, dersKredisi, donemi, vize, finall);
        dersListesi.gecilmisDersEkle(gecilmisDers);
    }

    // Mevcut ders çıkarma
    public void mevcutDersCikar(String dersAdi) {
        dersListesi.mevcutDersCikar(dersAdi);  // Ders listesinden çıkar
    }

    // Geçilmiş ders çıkarma
    public void gecilmisDersCikar(String dersAdi) {
        dersListesi.gecilmisDersCikar(dersAdi);  // Ders listesinden çıkar
    }

    // Mevcut dersleri görüntüleme
    public void mevcutDersleriGoruntule() {
        System.out.println("Mevcut Dersler:");
        for (MevcutDers mevcutDers : dersListesi.getMevcutDersler()) {
            mevcutDers.dersGoruntule();
            System.out.println("------------------------");
        }
    }

    // Geçilmiş dersleri görüntüleme
    public void gecilmisDersleriGoruntule() {
        System.out.println("Geçilmiş Dersler:");
        for (GecilmisDers gecilmisDers : dersListesi.getGecilmisDersler()) {
            gecilmisDers.dersGoruntule();
            System.out.println("------------------------");
        }
    }

    // Getter
    public DersListesi getDersListesi() {

        if (dersListesi == null) {
            dersListesi = new DersListesi();
        }

        return dersListesi;

    }

    // Setter
    public void setDersListesi(DersListesi dersListesi) {
        this.dersListesi = dersListesi;
    }
}

