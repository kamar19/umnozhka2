package com.example.umnozhka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GradebookActivity extends AppCompatActivity {
    List<LessonSummary> lessonSummaryList = new ArrayList<>();
    private SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradebook);
        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(this, lessonSummaryList);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {

        db = getBaseContext().openOrCreateDatabase("lessonSummary.db", MODE_PRIVATE, null);


        cursor = db.rawQuery("SELECT * FROM lessons ", null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            //  ( 'id'=?, '" + lessonSummary.getNameUser() + "', " + lessonSummary.getCountPoints() +", '" + lessonSummary.getDateLesson() + "' , '" + lessonSummary.getImage()
            //                + "', '" + lessonSummary.getStringPrimerovTasks() + "', '" + lessonSummary.getStringMDSA() + "', '" + lessonSummary.getStringMultiplyNumbers() + "')";
            LessonSummary tempLessonSummary = new LessonSummary(
//    public LessonSummary(String nameUser, String imageFileName, int countPoints, String stringPrimerovTasks, String stringMDSA, String stringMultiplyNumbers) {
//                    cursor.getInt(1),//ID
                    cursor.getString(1),//getNameUser()
                    cursor.getString(2),//getCountPoints
                    cursor.getInt(3),//getDateLesson
                    cursor.getString(4),//getImage
                    cursor.getString(5),//getStringPrimerovTasks
                    cursor.getString(6));//getStringMDSA
                    cursor.getString(7);//getStringMultiplyNumbers
            lessonSummaryList.add(tempLessonSummary);
        }
        cursor.close();


    }

    public void OpenDBtoLessonSummary(SQLiteDatabase db) {
//        ContentValues contentValues = new ContentValues();
//        SQLiteDatabase db = openOrCreateDatabase("lessons.db", Context.MODE_PRIVATE, null);
//        SQLiteDatabase db = new SQLiteDatabase();
//        String string0=""
        // Удалю таблицу, через создание новой БД?
//      db.delete("lessons", null, null);
//        if (db.isOpen()) db.close();

//        String string = "CREATE TABLE IF NOT EXISTS lessons ('id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
//                "'nameUser' TEXT, 'countPoints' INTEGER, 'dateLesson' TEXT, 'imageFileName' TEXT, " +
//                " 'stringPrimerovTasks' TEXT, 'stringMDSA' TEXT, 'stringMultiplyNumbers' TEXT )";
//        db.execSQL(string);
//        String string2 = "INSERT INTO lessons VALUES ( 'id'=?, '" + lessonSummary.getNameUser() + "', " + lessonSummary.getCountPoints() + ", '" + lessonSummary.getDateLesson() + "' , '" + lessonSummary.getImage()
//                + "', '" + lessonSummary.getStringPrimerovTasks() + "', '" + lessonSummary.getStringMDSA() + "', '" + lessonSummary.getStringMultiplyNumbers() + "')";
//        db.execSQL(string2);
////        нужно ли в БД первую запись делать с ноунем и ноуфото?
//        db.close();

//        String string = "CREATE TABLE IF NOT EXISTS lessons ('id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
//                "nameUser TEXT, countPoints INTEGER, dateLesson TEXT, image INTEGER, idResultLesson INTEGER, " +
//                " stringPrimerovTasks TEXT, stringMDSA TEXT, stringMultiplyNumbers TEXT )";
//        db.execSQL(string);
//        String string2 ="INSERT INTO lessons VALUES ('" + this.nameUser + "', " + this.countPoints +", '" + this.dateLesson + "' , " + this.imageFileName
//                + ", '" + this.stringPrimerovTasks + "', '" + this.stringMDSA + "', '" + this.stringMultiplyNumbers + "')";
//                db.execSQL(string2);
////        нужно ли в БД первую запись делать с ноунем и ноуфото?
//        db.close ();
    }
}