package com.example.sqlitecrud_sinhvien.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitecrud_sinhvien.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class SinhvienDao {
    private SQLiteDatabase db;

    public SinhvienDao(Context context) {
        DBHelper helper = new DBHelper(context);

        db = helper.getWritableDatabase();
    }

    public List<Sinhvien> get(String sql, String ...selectArgs){
        List<Sinhvien> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);

        while(cursor.moveToNext()){ //su dung vong lap while de duyet qua tap ket qua duoc luu va quan ly o trong cursor
            Sinhvien sinhvien = new Sinhvien();
            sinhvien.setMasv(cursor.getString(Integer.parseInt(cursor.getColumnName(Integer.parseInt("masv")))));
            sinhvien.setTen(cursor.getString(Integer.parseInt(cursor.getColumnName(Integer.parseInt("ten")))));
            sinhvien.setLop(cursor.getString(Integer.parseInt(cursor.getColumnName(Integer.parseInt("lop")))));

            list.add(sinhvien);
        }
        return  list;
    }
    public List<Sinhvien> getAll(){
        String sql = "SELECT * FROM sinhvien";
        return get(sql);
    }
    public Sinhvien getByMasv(String masv){ //tra ve thong tin sv theo ma sv
        String sql = "SELECT * FROM sinhvien WHERE masv=?";
        List<Sinhvien> list = get(sql, masv);
        return list.get(0);
    }
    public long insert(Sinhvien sinhvien){
        ContentValues values = new ContentValues(); //xac dinh cac thuoc tinh duoc chen vao
        values.put("masv", sinhvien.getMasv());
        values.put("ten", sinhvien.getTen());
        values.put("lop", sinhvien.getLop());

        return db.insert("sinhvien",null,values);
    }
    public long update(Sinhvien sinhvien){
        ContentValues values = new ContentValues(); //xac dinh cac thuoc tinh duoc chen vao

        values.put("ten", sinhvien.getTen());
        values.put("lop", sinhvien.getLop());

        return db.update("sinhvien",values, "id=?", new String[]{sinhvien.getMasv()});
    }
    public int delete(String masv){
        return db.delete("sinhvien","id=?",new String[]{masv});
    }
}
