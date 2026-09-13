package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NOM = "bdeb.sdb";
    public static final int VERSION_BD = 1;
    public static final String TABLE_USAGER = "USAGERS";
    public static final String COL_ID = "_ID";
    public static final String COL_NOM = "NOM";
    public static final String COL_AGE = "AGE";
    private static final String USAGER_DDL = "CREATE TABLE "+TABLE_USAGER+
            "( "+
            COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NOM + " TEXT, " +
            COL_AGE + " INTEGER " +
            ")" ;

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USAGER_DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
