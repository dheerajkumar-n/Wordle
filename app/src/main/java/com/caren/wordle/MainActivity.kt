package com.caren.wordle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.caren.wordle.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val random = FourLetterWordList.getRandomFourLetterWord();
        var attempts =0;
        fun checkGuess(guess: String) : String {
            var result = ""
            val wordToGuess=random;
            for (i in 0..3) {

                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val name = findViewById<EditText>(R.id.input);
        val button = findViewById<Button>(R.id.button1);
        val first = findViewById<TextView>(R.id.textView3)
        val second = findViewById<TextView>(R.id.textView4)
        val third = findViewById<TextView>(R.id.textView5)
        val correctAnswer = findViewById<TextView>(R.id.textView7)
        correctAnswer.visibility= View.GONE;
        button.setOnClickListener{
            attempts+=1;
            if(attempts==1){
                first.setText("Guess 1: "+name.text+" \nCheck: "+checkGuess(name.text.toString().toUpperCase()))
            } else if (attempts==2){
                second.setText("Guess 2: "+name.text+" \nCheck: "+checkGuess(name.text.toString().toUpperCase()))
            } else if (attempts==3){
                third.setText("Guess 3: "+name.text+" \nCheck: "+checkGuess(name.text.toString().toUpperCase()))
                correctAnswer.setText(random)
                correctAnswer.visibility=View.VISIBLE;
            } else {
                Toast.makeText(it.context, "3 is the limit", Toast.LENGTH_SHORT).show()
            }
        }
    }
}