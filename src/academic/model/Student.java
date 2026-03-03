package academic.model; // Mendefinisikan paket untuk kelas Student

/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */

public class Student {
    // Atribut-atribut kelas Student. Dibuat private untuk enkapsulasi.
    private String nim; // Nomor Induk Mahasiswa
    private String name; // Nama Mahasiswa
    private int entranceYear; // Tahun Masuk
    private String major; // Program Studi (Jurusan)

    /**
     * Konstruktor untuk membuat objek Student baru.
     * @param nim Nomor Induk Mahasiswa
     * @param name Nama Mahasiswa
     * @param entranceYear Tahun Masuk Mahasiswa
     * @param major Program Studi Mahasiswa
     */
    public Student(String nim, String name, int entranceYear, String major) {
        this.nim = nim;
        this.name = name;
        this.entranceYear = entranceYear;
        this.major = major;
    }

    // Metode getter untuk mengakses nilai atribut dari luar kelas.
    // Tidak ada setter karena kita asumsikan data mahasiswa tidak akan diubah setelah dibuat.

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public String getMajor() {
        return major;
    }

    /**
     * Metode ini akan dipanggil secara otomatis saat objek Student dicetak.
     * Kita format outputnya sesuai permintaan, menggunakan '|' sebagai separator.
     * @return String representasi objek Student.
     */
    @Override
    public String toString() {
        // Menggabungkan atribut dengan pemisah '|'
        return nim + "|" + name + "|" + entranceYear + "|" + major;
    }
}
