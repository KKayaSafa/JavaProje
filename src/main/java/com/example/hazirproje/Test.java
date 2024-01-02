package com.example.hazirproje;

public class Test {
    public static void main(String[] args) {
        // Yerli öğrenci oluştur
        Ogrenci yerliOgrenci = new Ogrenci("Ahmet", "Yılmaz", "123456789", "Bilgisayar Mühendisliği", "12345678910");

        // Yabancı öğrenci oluştur
        Ogrenci yabanciOgrenci = new Ogrenci("John", "Doe", "111111111", "Computer Science");

        // Yerli öğrenciye mevcut ders ekleme
        yerliOgrenci.mevcutDersEkle("Programlama", "Java programlama dili", "CS101", 3, 1, "Dr. Ayşe Öğretmen");
        yerliOgrenci.mevcutDersEkle("Veritabanı", "Veritabanı yönetimi", "CS102", 3, 1, "Dr. Mehmet Hoca");

        // Yabancı öğrenciye geçilmiş ders ekleme
        yabanciOgrenci.gecilmisDersEkle("Algorithms", "Algorithm design and analysis", "CS201", 4, 2, 80, 85);
        yabanciOgrenci.gecilmisDersEkle("Database Systems", "Advanced database concepts", "CS202", 4, 2, 75, 90);

        // Yerli öğrenciden mevcut ders çıkarma
        yerliOgrenci.mevcutDersCikar("Programlama");

        // Yabancı öğrenciden geçilmiş ders çıkarma
        yabanciOgrenci.gecilmisDersCikar("Database Systems");

        // Yerli öğrencinin mevcut derslerini görüntüleme
        System.out.println("Yerli Öğrencinin Mevcut Dersleri:");
        yerliOgrenci.mevcutDersleriGoruntule();

        // Yabancı öğrencinin geçilmiş derslerini görüntüleme
        System.out.println("\nYabancı Öğrencinin Geçilmiş Dersleri:");
        yabanciOgrenci.gecilmisDersleriGoruntule();
    }
}
