package HelloKotiln

//코틀린에선 같은 패키지 안이라도 final 으로 클래스가 선언되어 있기에 상속을 할 수가 없음.
//그렇기에 open 이라는 것을 클래스 앞에 붙여줘야 함.
open class Human constructor(val name:String = "Anonymous"){//이러한 constructor 가 생성자의 역할을 함. 물론 constructor 는 생략 가능. -> 주 생성.
                                     //그리고 밑에 val name 을 지우고 생성자에 val name:String  으로 하면 자동으로 name 이 만들어짐.
                                     //또한 이렇게 생성자에서 디폴트 매개변수를 정할 수 있음. 만약 인자가 아무것도 없다면 무조건 name 은 Anonymous 가 됨.
    constructor(name:String,age:Int):this(name){//->부 생성자. 부 생성자는 주 생성자의 위임을 받기에 this(name) 이렇게 해야함.
    println("my name is ${name}, ${age} years old")
}
    init{// -> 주 생성자의 일부.
    println("New human has been born!!")
}
    fun eatingCake(){
        println("This is so YUMMY~~~~~")
    }

    open fun singASong(){//메소드 또한 final 이므로 override 하기 위해선 앞에 open 을 붙여야 함.
        println("lalala")
    }
}

class Korean : Human(){//코틀린에선 이렇게 상속함.
    override fun singASong(){
    super.singASong()//부모 클래스 메소드 갖고오기.
        println("라라랄")
        println("my name is ${name}")
    }

}

fun main(){
//    val human=Human("minsu")//코틀린에서는 new 라는 표현이 필요 없음.
//    val stranger = Human()
//    human.eatingCake()
//    val mom=Human("Kuri",52)
//    println("this human's name is ${mom.name}")//실행할 때 주생성자,주생성자의 일부 그 후에 부 생성자가 실행됨.
    val korean=Korean()
    korean.singASong()
}