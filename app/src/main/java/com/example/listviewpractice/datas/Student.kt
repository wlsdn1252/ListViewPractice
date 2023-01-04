package com.example.listviewpractice.datas

import android.util.Log
import kotlin.math.log

// 학생 하위정보 - 이름, 출생년도
// 한 줄의 리스트에 뿌려질 정보

class Student(  // 생성자
    val name : String,
    val birthYear : Int) {

    fun getMyAgeIn2023() : Int{
        val myAge = 2023 - this.birthYear + 1

        return myAge
    }
}