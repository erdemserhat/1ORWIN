import com.erdemserhat.a1orwin.model.Player
import android.widget.TextView
import com.erdemserhat.a1orwin.controller.Constants
import com.erdemserhat.a1orwin.databinding.ActivityMainBinding
import com.erdemserhat.a1orwin.model.IPlayer

class Updatement{

    private val binding:ActivityMainBinding=Constants.binding
    private val player1:IPlayer=Constants.player1
    private val player2:IPlayer=Constants.player2

    fun updateTotalScoresOfUser1(updatedScore:String){
        //Update Model
        player1.addScore(updatedScore.toFloat())
        //Update UI
        binding.player1TotalScore.text=player1.takeTotalScore().toString()
        binding.player1TakenScore.text=updatedScore
    }

    fun updateTotalScoresOfUser2(updatedScore:String){
        //Update Model
        player2.addScore(updatedScore.toFloat())

        //Update UI
        binding.player2TotalScore.text=updatedScore
        binding.player2TakenScore.text=player2.takeTotalScore().toString()
    }


}