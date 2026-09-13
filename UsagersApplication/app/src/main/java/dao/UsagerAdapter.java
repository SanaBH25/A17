package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import modele.Usager;

public class UsagerAdapter {
    private DbHelper helper;
    private SQLiteDatabase db;

    public UsagerAdapter(Context context) {
        helper = new DbHelper(context, DbHelper.DB_NOM, null, DbHelper.VERSION_BD);
    }

    private void openDB(){
        db = helper.getWritableDatabase();

    }

    private void closeDB() {
        db.close();
    }

    public void inserer (Usager usager){
        openDB();
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.COL_NOM, usager.getNom());
        cv.put(DbHelper.COL_AGE, usager.getAge());
        db.insert(DbHelper.TABLE_USAGER,null,cv);
        closeDB();

    }

    public ArrayList<Usager> lister(){
        openDB();
        String[] cols = {DbHelper.COL_ID, DbHelper.COL_NOM, DbHelper.COL_AGE};
        ArrayList<Usager> resultat = new ArrayList<>();
        Cursor cursor = db.query(DbHelper.TABLE_USAGER, cols, null, null,
                null, null, null);
        // transformation de cursor en liste
        String nom;
        int id,age;
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            id= cursor.getInt(0);
            nom = cursor.getString(1);
            age = cursor.getInt(2);
            Usager u = new Usager(age, id, nom);
            resultat.add(u);
            cursor.moveToNext();
        }
        closeDB();
        return resultat;

    }

}
