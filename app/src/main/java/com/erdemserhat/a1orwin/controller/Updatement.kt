import com.erdemserhat.a1orwin.model.Player
import android.widget.TextView
import com.erdemserhat.a1orwin.controller.Constants
import com.erdemserhat.a1orwin.databinding.ActivityMainBinding
import com.erdemserhat.a1orwin.model.IPlayer

class Updatement {

    companion object {
        private val binding: ActivityMainBinding = Constants.binding
        private val player1: IPlayer = Constants.player1
        private val player2: IPlayer = Constants.player2

        fun updateCurrentScoreOfUser1(updatedScore: String) {
            //Update Model
            //-> hold button does player1.addScore(updatedScore.toFloat())
            //Update UI
            //-> hold button does binding.player1TotalScore.text=player1.takeTotalScore().toString()
            binding.player1TakenScore.text = updatedScore
        }

        fun updateCurrentScoreOfUser2(updatedScore: String) {
            //Update Model
            //---> player2.addScore(updatedScore.toFloat())

            //Update UI
            //---> binding.player2TotalScore.text=updatedScore
            binding.player2TakenScore.text = updatedScore
        }




        fun updateEnableStatus(
            player1HoldStatus:Boolean = true,
            player1RollDice:Boolean = true,
            player2HoldStatus:Boolean = true,
            player2RollDice:Boolean = true
        ){
            Constants.binding.player1Hold.isEnabled=player1HoldStatus
            Constants.binding.player1rollDice.isEnabled=player1RollDice
            Constants.binding.player2HoldDice.isEnabled=player2HoldStatus
            Constants.binding.player2RollDice.isEnabled=player2RollDice


        }



    }


}