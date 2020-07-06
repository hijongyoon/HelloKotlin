package HelloKotiln

fun main(){
    ignoreNulls("fuck")
}

//1.함수.

fun helloWorld(){//반환형이 아무 것도 없을 땐 Unit 을 붙여줘야함. 생략해도 됨.
    println("Hello World!")
}

fun add(a: Int,b:Int): Int{//코틀린에서 매개변수는 변수이름: 변수타입 순으로 전달하고 반환형인 : Int 이렇게 전달함. 생략 안됨.
    return a+b
}

//2.val vs var
//val=value

fun hi(){
    val a : Int =10//val 은 절대 변할 수 없음.
    var b:Int=9//var 은 변할 수 있음.
    var e:String // 초기화 안하는거 가능 var e 하고 초기화 안하는 것은 불가능(val 도 똑같음)
    b=100
    val c = 100// 이렇게 뒤의 자료형은 생략 가
    var d = 100
    var name ="joyce"
}
//3. String Template
fun writeSomething(){
    val name="Joyce"
    val lastName="Hong"
    println("my name is ${name+" "+lastName}")//이렇게 문자열 안에 변수를 사용해서 출력하고 싶다면 $를 이용함. 대신 그 뒤는 자동적으로 띄어쓰기가 되므로
    //띄어쓰기가 싫다면 대괄호로 변수를 묶음.
    println("this is 2\$a")//$을 써야한다면 \을 사용함.
}
//4. 조건식.
fun maxBy(a:Int,b:Int) :Int{
    if(a>b) return a
    else return b
}

fun maxBy2(a:Int,b:Int) : Int =if(a>b)a else b//코틀린에서는 우리가 알고 있는 삼항 연산자가 없음. -> Expression

fun checkNum(score:Int){
    when(score){//switch 같은 것.
        0 -> println("this is 0")//score 가 0일 때.
        1 -> println("this is 1")// -> Statement
        2,3->println("this is 2 or 3")
        else -> println("nothing")
    }
    var b = when(score){ // -> Expression
        1->1//score 가 1이면 b를 1로 초기화
        2->2
        else -> 3//대신 else 가 무조건 있어야함.
    }
    println("b: ${b}")
    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}
//Expression vs Statement
//Expression 은 어떠한 것을 반환함. Statement 는 반환을 하지 않음.
//코틀린에서 모든 함수는 Expression 왜냐면 무조건 Unit 이라는 것을 반환하기 때문.

//5. Array and List
//Array 는 기본적으로 mutable.
//List 1. List 2. MutableList

fun array(){
    val array=arrayOf(1,2,3)//arrayOf로 초기화.
    val list=listOf(1,2,3)//listOf로 초기화. -> immutable List
    val array2=arrayOf(1,"d",3.4f)//각각 다른 타입이 들어가도 상관없음.
    val list2=listOf(1,"d",11L)

    array[0]=3//list[0]=3 은 안됨.
    var result=list.get(0)
    val arrayList= arrayListOf<Int>()//이것이 MutableList
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0]=20
}

//6. For / While
fun forAndWhile(){
    val students=arrayListOf("joyce","james","jenny","jennifer")
    for(name in students){
        println("${name}")
    }
    for((index,name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }
    var sum:Int=0
    for(i in 1..10){
        sum+=i
    }
    println(sum)
    for(i in 1..10 step 2){//1,3,5,7,9 이런식으로 2씩 늘어남.
        sum+=i
    }
    for(i in 10 downTo 1){//10,9,8,....1 까지 내려감.
        sum+=i
    }
    for(i in 1 until 100){//1..99까지 감.
        sum+=i
    }
    var index =0
    while(index < 10){
        println("current index : ${index}")
        index++
    }
}

//7. Nullable/ NonNull
fun nullCheck(){
    //NPE : Null pointer Exception -> 자바에서는 실행을 해봐야 알 수 있었지만 코틀린은 실행하기 전에 알 수 있음.
    var name ="Joyce"//NonNull
    var nullName : String? =null//자료형 뒤에 ?를 붙여줌으로써 Nullable 이 됨.
    var nameInUpperCase =name.toUpperCase()
    var nullNameInUpperCase=nullName?.toUpperCase()//?가 없다면 컴파일러가 nullName 이 null 인지 아닌지 알 수 없기에 오류를 띄움
    //하지만 ?를 붙여준다면 null 이 아니면 toUpperCase 에서 반환한 것을 받고 null 이라면 null 을 반환.
    //?: 연산자.
    val lastName:String?=null
    val fullName:String=name+" "+(lastName?: "No lastName")//?: 연산자는 null 이 아니면 그냥 가지고 있는 값을 출력하고 null 이라면 default 로 정의된
    // 것을 출력하라는 의미.
    println(fullName)
}

fun ignoreNulls(str: String?){
    //!! 연산자.
    val notNull : String =str!!//사용자가 컴파일러에게 str 은 null 이 확신시켜 주는 것. 안쓰는게 좋음.
    val upper=notNull.toUpperCase()

    val email="joycehongXXXX@nana.com"
    email?.let{//let 은 살짝 람다 같은 느낌. null 이 아니라면 let 다음것을 실행.
        println("my email is ${email}")
    }
}

