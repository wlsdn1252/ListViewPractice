package com.example.listviewpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listviewpractice.R
import com.example.listviewpractice.datas.Student

class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext,resId,mList){ // ArrayAdapter클래스를 상속

    val inf = LayoutInflater.from(mContext) // 객체로 변환해주는(화면에 뿌리도록 도와주는) 변수를 맴버변수로 생성

    // 우리가 원하는 모양으로 뿌려지게 하려고 한 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!

        val studentData = mList[position]

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val birthYearTxt = row.findViewById<TextView>(R.id.birthYearTxt)

        nameTxt.text = studentData.name
        
        // 출생년도를 가지고 나이(2023년 기준)로 변환
        val koreaAge = 2023 - studentData.birthYear + 1
        
        //birthYearTxt.text = "(${studentData.birthYear}년생)"
        birthYearTxt.text = "(${koreaAge}세)"

        return row

    }


 }