package com.example.bartek.myapplication.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.bartek.myapplication.Model.Bus;
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

    public List<String> getPrzystanekNames()
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

    /*public String getPrzystanekById(int id, String przystanek) {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String tablePrzystanek="przystanek";
        String tableBus="linia_autobusowa";



        qb.setTables(tablePrzystanek+" JOIN "+tableBus+" ON "+tablePrzystanek+".idprzystanek="+tableBus+"."+przystanek);
        String[] sqlSelect={tablePrzystanek+".nazwa_przystanku"};


        Cursor cursor = qb.query(db, sqlSelect, tablePrzystanek+".idprzystanek="+id,null, null, null, null);
        String result = cursor.getString(cursor.getColumnIndex("nazwa_przystanku"));

        //List<String> result = new ArrayList<>();
        /*if(cursor.moveToFirst())
        {
            do{
                result.add(cursor.getString(cursor.getColumnIndex("nazwa_przystanku")));
            } while (cursor.moveToNext());
        }*/
        //return result;
    //}

    public List<Bus> getBus()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"idlinia_autobusowa", "przystanek_poczatkowy", "przystanek_koncowy"};
        String tableName="linia_autobusowa";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Bus> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Bus bus = new Bus();
                bus.setIdlinia_autobusowa(cursor.getInt(cursor.getColumnIndex("idlinia_autobusowa")));
                bus.setPrzystanek_poczatkowy(cursor.getInt(cursor.getColumnIndex("przystanek_poczatkowy")));
                bus.setPrzystanek_koncowy(cursor.getInt(cursor.getColumnIndex("przystanek_koncowy")));

                result.add(bus);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<String> getBusNumbers()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"idlinia_autobusowa"};
        String tableName="linia_autobusowa";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                result.add(cursor.getString(cursor.getColumnIndex("idlinia_autobusowa")));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<String> getBusStarts()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"przystanek_poczatkowy"};
        String tableName="linia_autobusowa";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                result.add(cursor.getString(cursor.getColumnIndex("przystanek_poczatkowy")));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<String> getBusEnds()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"przystanek_koncowy"};
        String tableName="linia_autobusowa";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                result.add(cursor.getString(cursor.getColumnIndex("przystanek_koncowy")));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Bus> getBusById(int id)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"idlinia_autobusowa", "przystanek_poczatkowy", "przystanek_koncowy"};
        String tableName="linia_autobusowa";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect,"idlinia_autobusowa LIKE ?",new String[]{"%"+id+"%"},null,null,null);
        List<Bus> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Bus bus = new Bus();
                bus.setIdlinia_autobusowa(cursor.getInt(cursor.getColumnIndex("idlinia_autobusowa")));
                bus.setPrzystanek_poczatkowy(cursor.getInt(cursor.getColumnIndex("przystanek_poczatkowy")));
                bus.setPrzystanek_koncowy(cursor.getInt(cursor.getColumnIndex("przystanek_koncowy")));

                result.add(bus);
            } while (cursor.moveToNext());
        }
        return result;
    }


}
