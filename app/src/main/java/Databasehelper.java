import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String Database_name = "covid.db";
    public static final String Table_Name = "users";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Surname";
    public static final String COL_4 = "Password";

    public static final String Table_Name2 = "Location";

    public Databasehelper(@Nullable Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + "(ID INTERGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Surname TEXT, Password TEXT  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
    }
}
