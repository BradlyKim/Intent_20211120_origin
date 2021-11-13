package com.nepplus.intent_20211113

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    멤버변수
    val REQ_FOR_NICKNAME = 1000
    val REQ_FOR_EMAIL = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOther.setOnClickListener {

//            OtherActivity 화면으로 이동하기

            val myIntent = Intent( this, OtherActivity::class.java )
            startActivity(myIntent)
        }

        btnSendMessage.setOnClickListener {

//            ViewMessageActivity 화면으로 이동하기 + 입력한 문구도 가지고 이동하기

//            1. 입력한 내용을 기록해두자 (변수에 담아두자)

            val inputMessage = edtMessage.text.toString()

//            2. 화면 이동
            val myIntent = Intent(this, ViewMessageActivity::class.java)

//            inputMessage에 담긴 내용을 myIntent에 첨부
            myIntent.putExtra("message", inputMessage)



        }

        btnEditNickname.setOnClickListener {
            val myIntent = Intent(this, EditNicknameActivity::class.java)

//            닉네임을 받기 위한 왕복이다라고, 왜 가는건지 구별
//            구별에 사용하는 수자 ->  REQUEST_CODE 라고 부름

            startActivityForResult(myIntent, REQ_FOR_NICKNAME )

        }

    }
}