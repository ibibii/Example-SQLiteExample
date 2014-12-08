package com.qf.sqliteexample.service;

import java.util.ArrayList;
import java.util.List;

import com.qf.sqliteexample.person.Person;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonService {
	private DBOpenHelper dbOpenHelper;
	public PersonService(Context context){
		this.dbOpenHelper = new DBOpenHelper(context);
	}
	public void save(Person person){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("insert into person (name) values(?)", new Object[]{person.getName()}); 
	}
	public void update(Person person){  
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();  
        db.execSQL("update person set name=? where personid=?",   
                new Object[]{person.getName(),person.getId()});  
    }
	public void delete(Integer id){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("delete from person where personid=?", new Object[]{id.toString()});
	}
	public Person find(Integer id){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person where personid =?", new String[]{id.toString()});
		if(cursor.moveToFirst()){
			int personid = cursor.getInt(cursor.getColumnIndex("personid"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			return new Person(personid,name);
		}
		return null;
	}
	public List<Person> getScrollData(Integer offset,Integer maxResult){
		List<Person> persons = new ArrayList<Person>();
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person limit ?,?", new String[]{offset.toString(),maxResult.toString()});
		while(cursor.moveToNext()){
			int personid = cursor.getInt(cursor.getColumnIndex("personid"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			Person person = new Person(personid,name);
			persons.add(person);
		}
		cursor.close();
		return persons;
	}
	public long getCount(){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from person", null);
		cursor.moveToFirst();
		return cursor.getLong(0);
	}
}
