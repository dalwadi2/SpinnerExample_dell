package com.example.admin.spinnerexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 09/10/2015.
 */
public class Dbhelper extends SQLiteOpenHelper {

    public static final String my_database = "database_NEW";
    public static final String my_tbl_register = "tbl_register";
    public static final String my_tbl_state = "tbl_state";
    public static final String my_tbl_district = "tbl_district";
    public static final String my_tbl_city = "tbl_city";
    public static final String my_tbl_area = "tbl_area";
    public static final String my_tbl_donation_history = "tbl_donation_history";

    public static final String my_tbl_feedback = "tbl_feedback";

    public static final String column_register_id = "register_id";
    public static final String column_category = "category";
    public static final String column_name = "name";
    public static final String column_email_id = "email_id";
    public static final String column_password = "password";
    public static final String column_contact = "contact";
    public static final String column_blood_group = "blood_group";
    public static final String column_gender = "gender";
    public static final String column_birthdate = "birthdate";
    public static final String column_address = "address";
    public static final String column_district = "district";
    public static final String column_state = "state";
    public static final String column_city = "city";
    public static final String column_area = "area";
    public static final String column_state_id = "state_id";
    public static final String column_district_id = "district_id";
    public static final String column_city_id = "city_id";
    public static final String column_area_id = "area_id";
    public static final String column_state_name = "state_name";
    public static final String column_district_name = "district_name";
    public static final String column_city_name = "city_name";
    public static final String column_area_name = "area_name";

    public static final String column_donation_history_id = "donation_history_id";
    public static final String column_donor_name = "donor_name";
    //public static final String column_donated_to= "donated_to";
    public static final String column_recipient_name = "recipient_name";
    public static final String column_donation_date = "donation_date";
    public static final String column_bloodgroup = "blood_group";

    public static final String column_feedback_id = "f_id";
    public static final String column_feedbcak_rating = "f_rating";
    public static final String column_feedback_comment = "f_comment";


    public Dbhelper(Context context) {
        super(context, my_database, null, 15);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            //fullname,contact_no,bloodgroup,gendervalue,birthdate,address,state,district,city,area);
            //delete   db.execSQL("CREATE TABLE " + my_tbl_register + "(" + column_register_id + " integer primary key autoincrement , " + column_name + " varchar(30) not null ," + column_contact + " integer not null ," + column_blood_group + " varchar(3) not null ," + column_gender + "varchar(6) not null ," + column_birthdate + " varchar(10) not null," + column_address + " varchar(50) not null," + "FOREIGN KEY(" + column_state_id + ")REFERENCES " + my_tbl_state + "(" + column_state_id + "), " + "FOREIGN KEY(" + column_district_id + ")REFERENCES " + my_tbl_district + "(" + column_district_id + ")," + "FOREIGN KEY(" + column_city_id + ")REFERENCES " + my_tbl_city + "(" + column_city_id + ")," + "FOREIGN KEY(" + column_area_id + ")REFERENCES " + my_tbl_area + "(" + column_area_id + "))");
            //db.execSQL("CREATE TABLE " + my_tbl_donation_history + " (" + column_donation_history_id + " integer primary key autoincrement , " + column_recipient_name + "varchar(30) not null , " + column_donor_name + " varchar(30) not null , " + column_donation_date + " varchar(10) not null , " + column_bloodgroup + "varchar(3) not null )");
            db.execSQL("CREATE TABLE " + my_tbl_register + " (" + column_register_id + " integer primary key autoincrement, " + column_name + " text ," + column_contact + " varchar2(10) ," + column_blood_group + " varchar(3) , " + column_gender + " varchar(6) ," + column_birthdate + " varchar(10) ," + column_address + " varchar(50) ," + column_state + " varchar(20) ," + column_district + " varchar(20) , " + column_city + " varchar(20), " + column_area + " varchar(25) )");
            db.execSQL("CREATE TABLE " + my_tbl_state + " (" + column_state_id + " integer primary key autoincrement , " + column_state_name + " varchar(25) not null)");
            db.execSQL("CREATE TABLE " + my_tbl_district + " (" + column_district_id + " integer primary key autoincrement , " + column_state_id + " integer , " + column_district_name + " varchar(25) not null )");
            db.execSQL("CREATE TABLE " + my_tbl_city + " (" + column_city_id + " integer primary key autoincrement , " + column_state_id + "integer , " + column_district_id + "integer , " + column_city_name + "integer not null )");
            db.execSQL("CREATE TABLE " + my_tbl_area + " (" + column_area_id + " integer primary key autoincrement , " + column_state_id + "integer , " + column_district_id + "integer , " + column_city_id + "integer , " + column_area_name + "integer not null )");
            db.execSQL("CREATE TABLE " + my_tbl_feedback + " (" + column_feedback_id + " integer primary key autoincrement , " + column_feedbcak_rating + " integer , " + column_feedback_comment + " varchar(100) )");
            db.execSQL("CREATE TABLE " + my_tbl_donation_history + " (" + column_donation_history_id + " integer primary key autoincrement , " + column_recipient_name + " varchar(30) not null , " + column_donor_name + " varchar(30) not null , " + column_donation_date + " varchar(10) not null , " + column_bloodgroup + " varchar(3) not null )");

            // Log.e("vidhi", "tables created ");*/
            // db.execSQL("CREATE TABLE " + my_tbl_register + " (" + column_register_id + " integer primary key autoincrement, " + column_name + " text ," + column_contact + " varchar2(10) ," + column_blood_group + " varchar(3) , " + column_gender + " varchar(6) ," + column_birthdate + " varchar(10) ," + column_address + " varchar(50) ," + column_state + " varchar(20) ," + column_district + " varchar(20) , " + column_city + " varchar(20), " + column_area + " varchar(25) )" );
        } catch (Exception e) {
            Log.d("vidhi", "" + e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            //db.execSQL("DROP TABLE IF EXISTS" + my_tbl_register);
            db.execSQL("DROP TABLE IF EXISTS tbl_register"); // aa joe leje me fix table name aapididhu che. aa bi chalsej
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(db);

    }
    /*
     public int updateStudent(int id,String name,String enroll,String mob,String pass,
                             String role,String dep,String div,int sem,String mname,String bname,
                             String gender,int app_disapp)
    {
        int cnt=0;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues mcontentvalues=new ContentValues();
        mcontentvalues.put(COLUMN_NAME,name);
        mcontentvalues.put(COLUMN_ENROLLMENT_NO, enroll);
        mcontentvalues.put(COLUMN_MOBILE_NO,mob);
        mcontentvalues.put(COLUMN_PASSWORD,pass);
        mcontentvalues.put(COLUMN_ROLE,role);
        mcontentvalues.put(COLUMN_DEPARTMENT,dep);
        mcontentvalues.put(COLUMN_DIVISION,div);
        mcontentvalues.put(COLUMN_SEMESTER,sem);
        mcontentvalues.put(COLUMN_MENTORS_NAME,mname);
        mcontentvalues.put(COLUMN_BATCHNAME,bname);
        mcontentvalues.put(COLUMN_GENDER,gender);
        mcontentvalues.put(COLUMN_APPROVE_DISAPPROVE,app_disapp);
        String param[]={""+id};

            cnt = db.update(TABLE_NAME, mcontentvalues, COLUMN_STUDENT_ID + "=?", param);


        return cnt;
    }

     */

    public boolean insertdata(String Fullname, String Contact, String Bloodgroup, String Gendervalue, String Birthdate, String Address, String State, String District, String City, String Area) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        try {
            cv.put(column_name, Fullname);
            cv.put(column_contact, Contact);
            cv.put(column_blood_group, Bloodgroup);
            cv.put(column_gender, Gendervalue);
            cv.put(column_birthdate, Birthdate);
            cv.put(column_address, Address);
            cv.put(column_state, State);
            cv.put(column_district, District);
            cv.put(column_city, City);
            cv.put(column_area, Area);


        } catch (Exception e) {
            e.printStackTrace();
        }

        db.insert(my_tbl_register, null, cv);
        return true;

    }

    public boolean insert_donation_history(String Recipient, String Donor, String Date, String Bloodgroup) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        try {
            cv.put(column_recipient_name, Recipient);
            cv.put(column_donor_name, Donor);
            cv.put(column_donation_date, Date);
            cv.put(column_bloodgroup, Bloodgroup);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.insert(my_tbl_donation_history, null, cv);
        return true;
    }


    public boolean insertfeedback(String FRATING, String FCOMMENT) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        try {


            cv.put(column_feedbcak_rating, FRATING);
            cv.put(column_feedback_comment, FCOMMENT);
        } catch (Exception e) {
            Log.e("error in insertfeedback", " " + e);
        }
        db.insert(my_tbl_feedback, null, cv);

        return true;
    }

   /* public int updatedb(String oldName, String newcontact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues mContentValues = new ContentValues();
        mContentValues.put(column_contact, newcontact);
        String[] param = {oldName};
        //Update Student set Name='LDRP' where Name='Jashvant Dave'
        int cnt = db.update(my_tbl_register, mContentValues, column_contact + " =? ", param);
        return cnt;
    }
*/
    //



    public List<String> getName(String mBloodGroup ,String mDistrict){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] param={mBloodGroup,mDistrict};
        Cursor mCursor = db.rawQuery("Select " + column_name + " , " + column_contact + " From " + my_tbl_register + " where " + column_blood_group + " = ? AND " + column_district + " = ? ", param);
        mCursor.moveToFirst();
        int cnt = mCursor.getCount();
        Log.d("vidhi", String.valueOf(cnt));
        List<String> mList = new ArrayList<>();
        mList.add(mCursor.getString(mCursor.getColumnIndex(column_name)));
        mList.add(mCursor.getString(mCursor.getColumnIndex(column_contact)));

        return mList;
    }

   public List<objectfile> getData(String bloodgroup_s, String state_s, String district_s, String city_s, String area_s) {
        // ContentValues cv = new ContentValues();
        SQLiteDatabase db1 = this.getReadableDatabase();

      String[] param = {bloodgroup_s, state_s, district_s, city_s, area_s};
      // String[] param = {bloodgroup_s};
        Log.d("vidhi",bloodgroup_s);
        Log.d("vidhi", state_s);
        Log.d("vidhi",district_s);
        Log.d("vidhi",city_s);
        Log.d("vidhi",area_s);

        //Cursor mCursor = db1.rawQuery("SELECT " + column_name + " , " + column_contact + " FROM " + my_tbl_register + " where " + column_blood_group + " = ? AND " + column_state + " = ? AND " + column_district + " = ? AND " + column_city + " = ? AND " + column_area + " = ? ", param);


        String execute;
        execute = "SELECT " + column_name + " , " + column_contact + " FROM " + my_tbl_register + " where " + column_blood_group + " = ? AND " + column_state + " = ? AND " + column_district + " = ? AND " + column_city + " = ? AND " + column_area + " = ? ";
       // execute = "SELECT * FROM " + my_tbl_register + " where " + column_blood_group + " = 'A+' ";
        Cursor mCursor = db1.rawQuery(execute,null);
        Log.d("vidhi",execute);


        //Cursor mCursor=null;
        mCursor.moveToFirst();
        List<objectfile> mStudentList = new ArrayList<>();

        while (mCursor.isAfterLast() == false) {
            Log.d("vidhi","Loop Called");
            objectfile mStudent = new objectfile();
            mStudent.setId(mCursor.getInt(mCursor.getColumnIndex(column_register_id)));
            mStudent.setDonor_name(mCursor.getString(mCursor.getColumnIndex(column_name)));
            mStudent.setContact_number(mCursor.getString(mCursor.getColumnIndex(column_contact)));
            mStudentList.add(mStudent);
            mCursor.moveToNext();
/*
  Student mStudent = new Student();
            mStudent.setId(mCursor.getInt(mCursor.getColumnIndex(COLUMN_ID)));
            mStudent.setName(mCursor.getString(mCursor.getColumnIndex(COLUMN_NAME)));
            mStudentList.add(mStudent);
            mCursor.moveToNext();
 */
        }

        Log.d("vidhi",String.valueOf(mStudentList.size()));
        return mStudentList;
    }



      /*
       // Cursor mCursor = db1.rawQuery("SELECT name, contact FROM tbl_register  where   state = 'Gujarat'",null);
         //      Cursor mCursor = db1.rawQuery("SELECT name, contact FROM tbl_register  where blood_group ='?'" ,new String[] {column_blood_group});
        List<objectfile> mStudentList = new ArrayList<>();
        objectfile mStudent = new objectfile();
        mStudent.setId(1);
        mStudent.setDonor_name("vidhi");
        mStudent.setContact_number("123");
        mStudentList.add(mStudent);
        return mStudentList ;*/
        }








