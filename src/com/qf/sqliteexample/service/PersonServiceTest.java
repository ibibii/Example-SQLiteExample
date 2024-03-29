package com.qf.sqliteexample.service;

import android.test.AndroidTestCase;

import java.util.List;  

 

import com.qf.sqliteexample.person.Person;

import android.test.AndroidTestCase;  
import android.util.Log;  
public class PersonServiceTest extends AndroidTestCase {
	private static final String TAG = "PersonServiceTest";  
	  
    public void testCreateDB() throws Throwable{  
        DBOpenHelper dbOpenHelper = new DBOpenHelper(this.getContext());  
        dbOpenHelper.getWritableDatabase();//第一次调用该方法就会创建数据库  
    }  
      
    public void testSave() throws Throwable{  
        PersonService personService = new PersonService(this.getContext());  
        Person person = new Person();  
        person.setName("xiaoxiao");  
        personService.save(person);  
          
        person = new Person();  
        person.setName("zhangliming");  
        personService.save(person);  
          
        person = new Person();  
        person.setName("libaobao");  
        personService.save(person);  
          
        person = new Person();  
        person.setName("taobao");  
        personService.save(person);  
    }  
      
    public void testUpate() throws Throwable{  
        PersonService personService = new PersonService(this.getContext());  
        Person person = personService.find(1);    
        person.setName("lili");  
        personService.update(person);  
    }  
      
    public void testDelete() throws Throwable{  
        PersonService personService = new PersonService(this.getContext());  
        personService.delete(1);  
    }  
      
    public void testFind() throws Throwable{  
        PersonService personService = new PersonService(this.getContext());  
        Person person = personService.find(1);  
        Log.i(TAG, person.toString());  
    }  
      
    public void testGetScrollData() throws Throwable{  
        PersonService personService = new PersonService(this.getContext());  
        List<Person> persons = personService.getScrollData(0, 3);  
        for(Person person : persons){  
            Log.i(TAG, person.toString());  
        }  
    }  
      
    public void testGetCount() throws Throwable{  
        PersonService personService = new PersonService(this.getContext());  
        Log.i(TAG, personService.getCount()+"");  
    }  
}
