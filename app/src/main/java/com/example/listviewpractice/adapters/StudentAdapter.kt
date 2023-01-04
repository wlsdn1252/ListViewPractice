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
            // 해당줄에 리스트가 없으면 inflate하라(inflate : 코드의 재사용성?? 화면에 너무 많은 객체가 있으면 OOM(Out Of Memory)이 발생) 어플이 죽어버림
            // 이를 방지하기 위해 inflate 화면밖에 나간 리스트는 재사용을 위해 다시 화면 제일 윗(밑)줄로 돌아온다.
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!

        val studentData = mList[position]   // 리스트의 해당 줄의 인덱스 번호를 담는다.


        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val birthYearTxt = row.findViewById<TextView>(R.id.birthYearTxt)

        nameTxt.text = studentData.name
        
        // 출생년도를 가지고 나이(2023년 기준)로 변환
        //val koreaAge = 2023 - studentData.birthYear + 1

        
        //birthYearTxt.text = "(${studentData.birthYear}년생)"
        birthYearTxt.text = "(${studentData.getMyAgeIn2023()}세)"

        return row

    }


 }