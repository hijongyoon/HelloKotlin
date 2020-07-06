package HelloKotiln

//1. Lamda
//람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수.
//1)메소드의 파라미터로 넘겨줄 수 있음. fun maxBy(a:Int)
//2)return 값으로 사용할 수가 있음.

//람다의 기본정의
//val lamdaName: Type = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number -> number*number}//input Tye -> output Type = 매개변수 -> return 할 값. 여기서 input Type 은 소괄호를
                                                       //해야함. 왜냐하면 여러개일 수도 있기 때문.
val nameAge={name:String, age:Int ->
    "my name is ${name} I'm ${age}"
}

fun main(){
    println(square(12))
    println(nameAge("joyce",99))
    val a="joyce said"
    val b="mac said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("ariana",27))
    println(calculateGrade(97))

    val lamda={number:Double -> number==4.3213}
    println(invokeLamda(lamda))
    println(invokeLamda({it>3.22}))// 이것은 여기서 람다식을 정의하고 어떠한 변수에 저장하지 않고 그 자체를 매개변수로 넘긴 것.
    println(invokeLamda { it>3.22 })//마지막 매개변수가 람다식인 경우 소괄호를 생략할 수 있음.
}

//확장함수.
val pizzaIsGreat : String.() -> String ={// 이 의미는 사용자가 String 클래스에 어떤 메소드를 추가하고 싶을 때 사용하는 확장 함수.
    this+"Pizza is the best"//여기서 this 는 String 객체 자체.
}

fun extendString(name:String,age:Int):String{
    val introduceMyself : String.(Int) -> String={"I am ${this} and ${it} years old"}//이렇게 람다에 매개변수가 1개일 경우 it 을 사용할 수 있음.
    return name.introduceMyself(age)
}

//람다의 Return
val calculateGrade : (Int) -> String={
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100  -> "perfect"
        else -> "Error"//여기선 무조건 else 가 있어야 함. 왜냐하면 위의 수 이외의 수가 나온다면 반환을 하지 않게되므로 오류 발생하기 때문.
    }
}

//람다를 표현하는 2가지 방법.
fun invokeLamda(lamda:(Double)->Boolean) : Boolean{
// 이 invokeLamda 함수는 반환형이 Boolean 인데, 매개 변수로 람다식을 전달 받는데 이 람다식은 Double 형을 전달받아 Boolean 을 반환함.
// invokeLamda 는 거기서 반환된 Boolean 을 반환함.
    return lamda(5.2343)
}