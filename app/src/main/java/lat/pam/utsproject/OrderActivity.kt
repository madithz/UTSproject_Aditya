package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("food_name")
        val foodImageId = intent.getIntExtra("food_image_id", 0)
        val foodPrice = intent.getStringExtra("food_price") ?: "0" // Mendapatkan harga

        val tvFoodName: TextView = findViewById(R.id.etFoodName)
        val ivFoodImage: ImageView = findViewById(R.id.ivFoodImage)
        val tvFoodPrice: TextView = findViewById(R.id.tvFoodPrice) // TextView untuk harga

        val etServings: EditText = findViewById(R.id.etServings)
        val etName: EditText = findViewById(R.id.etName)
        val etNotes: EditText = findViewById(R.id.etNotes)

        val btnPlaceOrderActivity: Button = findViewById(R.id.btnOrder)
        val btnBack: Button = findViewById(R.id.btnBack)

        tvFoodName.text = foodName
        ivFoodImage.setImageResource(foodImageId)
        tvFoodPrice.text = foodPrice // Menampilkan harga makanan

        // Set click listener untuk tombol Place Order
        btnPlaceOrderActivity.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("food_name", foodName)
            intent.putExtra("food_price", foodPrice) // Mengirim harga
            intent.putExtra("servings", etServings.text.toString())
            intent.putExtra("ordering_name", etName.text.toString())
            intent.putExtra("additional_notes", etNotes.text.toString())
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
