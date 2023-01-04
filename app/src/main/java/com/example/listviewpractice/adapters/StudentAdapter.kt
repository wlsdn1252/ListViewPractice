package com.example.listviewpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

        return row

    }


 }