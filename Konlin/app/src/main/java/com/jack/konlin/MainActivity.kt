package com.jack.konlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
// 使用来自主代码集的 R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "控件内容"
        textView.setOnClickListener {
            toast("Kotlon吐司")
            startActivity<SecondActivity>()
        }
//        textView.text = " " + sum(3, 5)
        DefineValue()
    }

    /**
      定义函数
     */
//    fun sum(a: Int, b: Int): Int {
//        return a + b
//    }
//    fun sum(a: Int, b: Int) = a + b

    /**
     *  定义局部变量
     */
    fun DefineValue (){
//        val a: Int = 1  // 立即初始化
//        val b = 2   // 推导出Int型
//        val c: Int  // 当没有初始化值时必须声明类型
//        c = 3       // 赋值
//        println("a = $a, b = $b, c = $c")
        var a = 5;
        a +=1
        println("a= $a")
    }
}
