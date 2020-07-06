package HelloKotiln

data class Ticket(val companyName:String,val name:String,var date:String, var seatNumber :Int)
//toString(), hashCode(), equals(), copy() 가 data class 에서 자동으로 만들어 짐.
class TicketNormal(val companyName:String,val name:String,var date:String, var seatNumber :Int)


fun main(){
    val ticketA=Ticket("koreanAir","joyceHong","2020-02-16",14)
    val ticketB=TicketNormal("koreanAir","joyceHong","2020-02-16",14)
    println(ticketA)
    println(ticketB)
}