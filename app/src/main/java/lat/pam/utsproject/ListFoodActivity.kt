package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor, 15000),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad, 20000),
            Food("Cappucino", "Kopi cappucino asli dari kopi Arabica", R.drawable.cappuchino, 25000),
            Food("Cireng", "Makanan khas Bandung yang renyah dan kenyal", R.drawable.cireng, 10000),
            Food("Cheesecake", "Kue nastar dengan taburan keju di atasnya", R.drawable.cheesecake, 30000),
            Food("Donut", "Roti bundar dengan isi kacang yang renyah", R.drawable.donut, 12000),
            Food("Mie Goreng", "Mie goreng dengan bumbu kacang yang lezat", R.drawable.mie_goreng, 18000),
            Food("Nasi Goreng", "Nasi goreng dengan berbagai macam pilihan rempah", R.drawable.nasigoreng, 20000),
            Food("Sparkling Tea", "Teh yang menyegarkan dengan rasa yang menggugah", R.drawable.sparkling_tea, 15000),
            Food("Kopi Hitam", "Kopi hitam yang terbuat dari biji kopi Arabika", R.drawable.kopi_hitam, 12000)
        )

        adapter = FoodAdapter(foodList) { selectedFood ->
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("food_name", selectedFood.name)
            intent.putExtra("food_image_id", selectedFood.imageResourceId)
            intent.putExtra("food_price", selectedFood.price)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
