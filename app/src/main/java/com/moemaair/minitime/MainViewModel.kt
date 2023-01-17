import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel(){

    val timeCountDown = flow<Int>{
        val startVal = 10
       var currentVal = startVal

        emit(currentVal)
        while (currentVal > 0){
            delay(1500L)
            currentVal--
            emit(currentVal)
        }
    }

}