# Library Management

Java 22 kullanılarak **katmanlı mimari** yapısına ve **Clean Code prensiplerine** uygun şekilde geliştirilmiş bir **Library Management** uygulamasıdır.
Uygulama, herhangi bir veritabanına ihtiyaç duymadan **JSON formatında veri depolayabilir**. Bu sayede hızlı, hafif ve kolayca genişletilebilir bir yapı sunar.

## Özellikler

-  **Kitap Ekleme**  
  Yeni bir kitap sisteme eklenir ve JSON dosyasına kaydedilir.

- **Bütün Kitapları Listeleme**  
  Sistemde kayıtlı tüm kitaplar görüntülenebilir.

- **Kitap Silme**  
  Belirli bir kitap sistemden kaldırılabilir.

- **Kitap Ödünç Alma**  
  Kitabın durumu “ödünç verildi” olarak güncellenir.

- **Kitap Teslim Etme**  
  Ödünç alınmış kitap teslim edilerek tekrar kullanılabilir hale getirilir.

---

## Kullanılan Teknolojiler

- **Java 22**
- **Google Gson**  
  JSON formatındaki verileri okuma, yazma ve serileştirme işlemleri için kullanılmıştır.

## Bağımlılıklar

Projenin çalışması için aşağıdaki bağımlılık eklenmelidir:

### Maven için
```<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10.1</version>
        </dependency>
```

## Kurulum

1. Projeyi Klonlayın:
```
git clone https://github.com/OgulcanOnder/library-management.git
```
2. Gson Bağımlılığının eklendiğinden emin olun.
3. Uygulamayı Java 22 veya daha üst versiyonlar ile çalıştırın.
