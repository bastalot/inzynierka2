package com.example.bartek.myapplication.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.bartek.myapplication.Model.Przystanek;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME="database.db";
    private static final int DB_VER=1;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    //function get all przystanki
    public List<Przystanek> getPrzystanek()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"idprzystanek", "nazwa_przystanku", "idlinia_autobusowa"};
        String tableName="przystanek";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect,null,null,null,null,null);
        List<Przystanek> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Przystanek przystanek = new Przystanek();
                przystanek.setIdprzysanek(cursor.getInt(cursor.getColumnIndex("idprzystanek")));
                przystanek.setIdlinia_autobusowa(cursor.getInt(cursor.getColumnIndex("idlinia_autobusowa")));
                przystanek.setNazwa_przystanku(cursor.getString(cursor.getColumnIndex("nazwa_przystanku")));

                result.add(przystanek);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<String> getNames()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"nazwa_przystanku"};
        String tableName="przystanek";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect,null,null,null,null,null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{

                result.add(cursor.getString(cursor.getColumnIndex("nazwa_przystanku")));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Przystanek> getPrzystanekByName(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"idprzystanek", "nazwa_przystanku", "idlinia_autobusowa"};
        String tableName="przystanek";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect,"nazwa_przystanku LIKE ?",new String[]{"%"+name+"%"},null,null,null);
        List<Przystanek> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Przystanek przystanek = new Przystanek();
                przystanek.setIdprzysanek(cursor.getInt(cursor.getColumnIndex("idprzystanek")));
                przystanek.setIdlinia_autobusowa(cursor.getInt(cursor.getColumnIndex("idlinia_autobusowa")));
                przystanek.setNazwa_przystanku(cursor.getString(cursor.getColumnIndex("nazwa_przystanku")));

                result.add(przystanek);
            } while (cursor.moveToNext());
        }
        return result;
    }
}
