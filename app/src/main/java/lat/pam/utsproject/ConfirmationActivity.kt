package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("food_name")
        val servings = intent.getStringExtra("servings")
        val orderingName = intent.getStringExtra("ordering_name")
        val additionalNotes = intent.getStringExtra("additional_notes")

        val tvFoodName: TextView = findViewById(R.id.tvFoodName)
        val tvServings: TextView = findViewById(R.id.tvServings)
        val tvOrderingName: TextView = findViewById(R.id.tvOrderingName)
        val tvAdditionalNotes: TextView = findViewById(R.id.tvAdditionalNotes)

        tvFoodName.text = "Food Name: $foodName"
        tvServings.text = "Number of Servings: $servings"
        tvOrderingName.text = "Ordering Name: $orderingName"
        tvAdditionalNotes.text = "Additional Notes: $additionalNotes"

        val backToMenuButton: Button = findViewById(R.id.backtoMenu)

        backToMenuButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
