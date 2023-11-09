import com.erdemserhat.a1orwin.model.Player
import android.widget.TextView
import com.erdemserhat.a1orwin.databinding.ActivityMainBinding

class Updatement(val binding: ActivityMainBinding, val player: Player) {

    fun <T:TextView> updateTotalScoresOfUser1(updatedScore:String){
        //Update Model
        player.totalScore=updatedScore.toFloat()

        //Update UI
        binding.player1TotalScore.text=updatedScore

    }

    fun <T:TextView> updateTotalScoresOfUser2(updatedScore:String){
        //Update Model
        binding.player2TotalScore.text=updatedScore

        //Update UI
        binding.player2TotalScore.text=updatedScore
    }

    fun <T:TextView> updateTakenScoreOfUser1(updatedTakenScore:String){
        //Update Model
        player.totalScore+=updatedTakenScore.toFloat()

        //Update UI
        binding.player1TakenScore.text=updatedTakenScore
    }

    fun <T:TextView> updateTakenScoreOfUser2(updatedTakenScore:String){
        //Update Model
        player.totalScore+=updatedTakenScore.toFloat()

        //Update UI
        binding.player2TakenScore.text=updatedTakenScore
    }

}