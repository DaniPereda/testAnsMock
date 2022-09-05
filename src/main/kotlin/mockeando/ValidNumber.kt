package mockeando

class ValidNumber {
    fun check(o: Any?):Boolean
    {
        return if(o is Int)
            o in 0..9
        else
            false
    }

    fun checkZero(o: Any):Boolean
    {
        return if(o is Int && o == 0) {
            throw ArithmeticException("no admite cero")
        }
        else true
    }

    fun doubleToInt(o: Any?): Int{
        return if (o is Double) {
            o.toInt()
        }else
            0

    }


}