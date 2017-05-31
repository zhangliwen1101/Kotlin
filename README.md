# Kotlin

## Kotlin是什么？
>Kotlin是由JetBrains创建的基于JVM的编程语言，IntelliJ正是JetBrains的杰作，而Android Studio是基于IntelliJ修改而来的。

>Kotlin是一门包含很多函数式编程思想的面向对象编程语言。

>Kotlin生来就是为了弥补Java缺失的现代语言的特性，并极大的简化了代码，使得开发者可以编写尽量少的样板代码。

##为什么要用Kotlin？
>1.它更容易表现，使用kotlin你可以少写很多代码，比如创建数据类等。

>2.它更安全，在用Java开发时，大多数代码都是预防性的。为了不遇到非预期的NullPointerException，在使用之前，要不断的检测对象是否为空。与许多其它语言一样，因为需要使用安全调用运算符显式指明对象是否能够为空（null），所以Kotlin是空类型安全的

>3.它是函数式的，Kotlin是基于面向对象的语言。但是就如其他很多现代的语言那样，它使用了很多函数式编程的概念，比如，使用lambda表达式来更方便地解决问题。其中一个很棒的特性就是Collections的处理方式。

>4.它可以扩展函数，这意味着我们可以扩展类的更多的特性，甚至我们没有权限去访问这个类

#Kotlin在Studio中的使用
#####第一步:在Studio中下载Kotlin的插件并且重启Studio

####第二步：配置Kotlin项目（注：通过studio自行去会很慢，我是手动配置的）
>1.project gradle下添加如下代码：

```
ext.kotlin_version = '1.1.1'
classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.1
```
栗如：
---
![loading.png](http://od6ro0ups.bkt.clouddn.com/project-gradle.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/500)

>1.app gradle下添加如下代码：

```
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

compile "org.jetbrains.anko:anko-common:0.8.2" 
compile "org.jetbrains.kotlin:kotlin-stdlib-jre7:1.1.1"

其中"org.jetbrains.anko:anko-common:0.8.2"这个依赖是kontlin为Android准备的一个库，可以简化好多代码，如果不想用，也可以不添加。
```
栗如：
---
![loading.png](http://od6ro0ups.bkt.clouddn.com/app-gradle.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/500)

####第三步：如果你编写的是java代码，需要将java代码变成Kotlin代码
>注：Studio装Kotlin插件后，Java可以直接转成Kotlin，通过Ctrl+Z可以撤回

>操作：Studio菜单栏code--->convert java file to kontlin file

栗如：
---
![loading.png](http://od6ro0ups.bkt.clouddn.com/javaToKotlin.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

>以上设置完成后java代码就变成kontlin代码了


#我的Kotlin学习之路
>[Kotlin中文文档][1]

```
设置控件文字内容：
textView.text="空间内容"
```
```
控件点击事件（页面跳转，吐司）
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity
textView.setOnClickListener {
            toast("Kotlon吐司")
			startActivity<SecondActivity>()
        }

```
```
定义函数：
1.定义一个函数接受两个 int 型参数，返回值为 int
fun sum(a: Int , b: Int) : Int{
        return a + b
    }
textView.text =" "+sum(3,5)
```
```
定义局部变量
常量（val）
fun DefineValue (){
        val a: Int = 1  // 立即初始化
        val b = 2   // 推导出Int型
        val c: Int  // 当没有初始化值时必须声明类型
        c = 3       // 赋值
        println("a = $a, b = $b, c = $c")
    }
变量（var）
var x = 5 // 推导出Int类型
  x += 1
  println("x = $x")
```
```
字符串模板
var a = 1
  // 使用变量名作为模板:
  val s1 = "a is $a"

  a = 2
  // 使用表达式作为模板:
  val s2 = "${s1.replace("is", "was")}, but now is $a"
  println(s2)
```
```
条件表达式
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
println("max of 0 and 42 is ${maxOf(0, 42)}")
把if当表达式：
fun maxOf(a: Int, b: Int) = if (a > b) a else b
```
```
当 str 中不包含整数时返回空
fun parseInt(str: String): Int? {
  return str.toIntOrNull()
}
```
```
使用值检查并自动转换
fun getStringLength(obj: Any): Int? {
  if (obj is String) {
    // obj 将会在这个分支中自动转换为 String 类型
    return obj.length
  }

  // obj 在种类检查外仍然是 Any 类型
  return null
}
```
```
使用循环
for循环
val items = listOf("apple", "banana", "kiwi")
  for (index in items.indices) {
    println("item at $index is ${items[index]}")
  }

while 循环
val items = listOf("apple", "banana", "kiwi")
  var index = 0
  while (index < items.size) {
    println("item at $index is ${items[index]}")
    index++
  }
```
```
when 表达式
when (x) {
    1 -> print("x == 1")
    2 -> print("x == 2")
    else -> { // Note the block
        print("x is neither 1 nor 2")
    }
}

when (x) {
    0, 1 -> print("x == 0 or x == 1")
    else -> print("otherwise")
}

when (x) {
    parseInt(s) -> print("s encodes x")
    else -> print("s does not encode x")
}

when (x) {
    in 1..10 -> print("x is in the range")
    in validNumbers -> print("x is valid")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}



fun describe(obj: Any): String =
when (obj) {
  1          -> "One"
  "Hello"    -> "Greeting"
  is Long    -> "Long"
  !is String -> "Not a string"
  else       -> "Unknown"
}
fun main(args: Array<String>) {
  println(describe(1))
  println(describe("Hello"))
  println(describe(1000L))
  println(describe(2))
  println(describe("other"))
}
```
```
使用ranges
if (i in 1..10) { // equivalent of 1 <= i && i <= 10
    println(i)
}
for (i in 1..4) print(i) // prints "1234"

for (i in 4..1) print(i) // prints nothing

for (i in 4 downTo 1) print(i) // prints "4321"

for (i in 1..4 step 2) print(i) // prints "13"

for (i in 4 downTo 1 step 2) print(i) // prints "42"

for (i in 1 until 10) { // i in [1, 10), 10 is excluded
     println(i)
}

```

[1]:https://github.com/huanglizhuo/kotlin-in-chinese

