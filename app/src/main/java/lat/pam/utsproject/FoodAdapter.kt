package lat.pam.utsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(
    private val foodList: List<Food>,
    private val onItemClick: (Food) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImage: ImageView = view.findViewById(R.id.foodImage)
        val foodName: TextView = view.findViewById(R.id.foodName)
        val foodDescription: TextView = view.findViewById(R.id.foodDescription)
        val foodPrice: TextView = view.findViewById(R.id.foodPrice)

        fun bind(food: Food) {
            foodName.text = food.name
            foodDescription.text = food.description
            foodImage.setImageResource(food.imageResourceId)
            foodPrice.text = "Rp ${food.price}"

            itemView.setOnClickListener { onItemClick(food) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size
}
