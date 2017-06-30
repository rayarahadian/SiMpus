package pemula.simpus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by Evlive-Tenshi-PC on 6/30/2017.
 */

public class DatabaseActivity extends SQLiteOpenHelper {
    public DatabaseActivity(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Siswa(id_siswa integer primary key autoincrement, email varchar, " +
                "password varchar, nama  varchar, jenis_kelamin varchar, tgl_lahir date, asal varchar, " +
                "asal_sekolah varchar, pil_1 varchar, pil_2 varchar )");
        db.execSQL("CREATE TABLE Mahasiswa(id_mahasiswa integer primary key autoincrement, email varchar, password varchar, nama  varchar, " +
                "jenis_kelamin varchar, tgl_lahir date, asal varchar, asal_kampus varchar)");
        db.execSQL("CREATE TABLE Universitas(id_universitas integer primary key autoincrement, nama varchar, alamat varchar");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Siswa");
        db.execSQL("DROP TABLE IF EXISTS Mahasiswa");
        db.execSQL("DROP TABLE IF EXISTS Universitas");
        onCreate(db);
    }

    public void insertSiswa(String email, String password, String nama, String jenis_kelamin) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("nama", nama);
        contentValues.put("jenis_kelamin", jenis_kelamin);
        this.getWritableDatabase().insertOrThrow("Siswa", "", contentValues);
    }
    public void deleteSiswa(Integer id_siswa) {
        this.getWritableDatabase().delete("Siswa","id_siswa='"+id_siswa+"'", null);
    }

    public void updateSiswa(Integer id_siswa, Date tgl_lahir, String asal, String asal_sekolah, String pil_1, String pil_2) {
        this.getWritableDatabase().execSQL("UPDATE Siswa SET tgl_lahir='"+tgl_lahir+"', asal='"+asal+"', asal_sekolah='"+asal_sekolah+"', pil_1='"+pil_1"', pil_2='"+pil_2"' WHERE id_siswa='"+id_siswa"'");
    }

    public void insertMahasiswa(String email, String password, String nama, String jenis_kelamin) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("nama", nama);
        contentValues.put("jenis_kelamin", jenis_kelamin);
        this.getWritableDatabase().insertOrThrow("Mahasiswa", "", contentValues);
    }
    public void deleteMahasiswa(Integer id_mahasiswa) {
        this.getWritableDatabase().delete("Mahasiswa","id_mahasiswa='"+id_mahasiswa+"'", null);
    }

    public void updateMahasiswa(Integer id_mahasiswa, Date tgl_lahir, String asal, String asal_kampus) {
        this.getWritableDatabase().execSQL("UPDATE Mahasiswa SET tgl_lahir='"+tgl_lahir+"', asal='"+asal+"', asal_kampus='"+asal_kampus+"' WHERE id_mahasiswa='"+id_mahasiswa"'");
    }
}
