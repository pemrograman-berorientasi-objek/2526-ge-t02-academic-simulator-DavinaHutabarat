package academic.model; // Mendefinisikan paket untuk kelas Course

/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */


public class Course {
    // Atribut-atribut kelas Course. Dibuat private untuk enkapsulasi.
    private String code;
    private String name;
    private int sks;
    private String grade;

    /**
     * Konstruktor untuk membuat objek Course baru.
     * @param code Kode mata kuliah (misal: 12S2203)
     * @param name Nama mata kuliah (misal: Object-oriented Programming)
     * @param sks Jumlah SKS (misal: 3)
     * @param grade Nilai mata kuliah (misal: A, B, C)
     */
    public Course(String code, String name, int sks, String grade) {
        this.code = code;
        this.name = name;
        this.sks = sks;
        this.grade = grade;
    }

    // Metode getter untuk mengakses nilai atribut dari luar kelas.
    // Tidak ada setter karena kita asumsikan data course tidak akan diubah setelah dibuat.

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSks() {
        return sks;
    }

    public String getGrade() {
        return grade;
    }

    /**
     * Metode ini akan dipanggil secara otomatis saat objek Course dicetak.
     * Kita format outputnya sesuai permintaan, menggunakan '|' sebagai separator.
     * @return String representasi objek Course.
     */
    @Override
    public String toString() {
        // Menggabungkan atribut dengan pemisah '|'
        return code + "|" + name + "|" + sks + "|" + grade;
    }
}
