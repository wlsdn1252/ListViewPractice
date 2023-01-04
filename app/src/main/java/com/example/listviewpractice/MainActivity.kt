package com.example.listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listviewpractice.adapters.StudentAdapter
import com.example.listviewpractice.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter  // 나중에 값을 채울게

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("강진우",1997))
        mStudentList.add(Student("정호석",1991))
        mStudentList.add(Student("남민재",1992))
        mStudentList.add(Student("백승민",1993))
        mStudentList.add(Student("반나",1994))
        mStudentList.add(Student("이봉준",1995))

        //                       어떤 화면에서 보일건가,  무슨 xml파일을 보일건가,  어떤 양식으로 보일건가
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)
        studentListView.adapter = mAdapter

        // 리스트뷰의 한줄을 클릭했을떄
        studentListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = mStudentList[position]
            Toast.makeText(this, "${clickedStudent.name}이 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // 리스트뷰의 한줄을 길게 클릭할 떄
        studentListView.setOnItemLongClickListener { parent, view, position, id ->
            
//            val longClickedStudent = mStudentList[position]
//            Toast.makeText(this, "${longClickedStudent.name} 길게 클릭됨", Toast.LENGTH_SHORT).show()

            // 목록에서 제거
            mStudentList.removeAt(position)
            // 리스트뷰의 내용이 변경되면 새롭게 반영해달라
            mAdapter.notifyDataSetChanged()

            return@setOnItemLongClickListener true

        }

    }
}