package com.example.listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviewpractice.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("강진우",1997))
        mStudentList.add(Student("정호석",1991))
        mStudentList.add(Student("남민재",1992))
        mStudentList.add(Student("백승민",1993))
        mStudentList.add(Student("반나",1994))
        mStudentList.add(Student("이봉준",1995))

    }
}