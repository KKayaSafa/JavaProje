package com.example.hazirproje;

import java.util.ArrayList;

public class DersListesi {
    // Dersleri tutacak arraylist yapıları
    private ArrayList<MevcutDers> mevcutDersler;
    private ArrayList<GecilmisDers> gecilmisDersler;


    // Constructor metodu
    public DersListesi() {
        mevcutDersler = new ArrayList<>();
        gecilmisDersler = new ArrayList<>();

        GecilmisDers g = new GecilmisDers("Kimya","Temel Üniversite Kimyası","KIM2002",6,3,40,60);
        gecilmisDersler.add(g);

        MevcutDers m = new MevcutDers("Bilgisayar Programlama 2","Python Programlama Dili","BLM2002",6,3,"Doç.Dr. Ayşe Berna Altınel Girgin");
        mevcutDersler.add(m);



    }


    // Mevcut dersler için ekleme fonksiyonu
    public void mevcutDersEkle(MevcutDers mevcutDers) {
        mevcutDersler.add(mevcutDers);
    }

    // Mevcut dersler için çıkarma fonksiyonu
    public void mevcutDersCikar(String dersAdi) {
        for (int i = 0; i < mevcutDersler.size(); i++) {
            if (mevcutDersler.get(i).getDersAdi().equals(dersAdi)) {
                mevcutDersler.remove(i);
                break; // İlk bulunan dersi silip döngüden çık
            }
        }
    }

    // Geçilmiş dersler için ekleme fonksiyonu
    public void gecilmisDersEkle(GecilmisDers gecilmisDers) {
        gecilmisDersler.add(gecilmisDers);
    }

    // Geçilmiş dersler için çıkarma fonksiyonu
    public void gecilmisDersCikar(String dersAdi) {



        for (int i = 0; i < gecilmisDersler.size(); i++) {
            if (gecilmisDersler.get(i).getDersAdi().equals(dersAdi)) {
                gecilmisDersler.remove(i);
                break; // İlk bulunan dersi silip döngüden çık
            }
        }


    }

    // Mevcut derslerin listesini getiren fonksiyon
    public ArrayList<MevcutDers> getMevcutDersler() {
        return mevcutDersler;
    }

    // Geçilmiş derslerin listesini getiren fonksiyon
    public ArrayList<GecilmisDers> getGecilmisDersler() {
        return gecilmisDersler;
    }

    public void setMevcutDersler(ArrayList<MevcutDers> mevcutDersler) {
        this.mevcutDersler = mevcutDersler;
    }

    // Setter metodu - Geçilmiş dersler listesi
    public void setGecilmisDersler(ArrayList<GecilmisDers> gecilmisDersler) {
        this.gecilmisDersler = gecilmisDersler;
    }


}
