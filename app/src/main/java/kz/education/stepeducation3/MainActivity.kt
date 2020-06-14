package kz.education.stepeducation3

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.core.view.children
import androidx.core.view.forEachIndexed

class MainActivity : AppCompatActivity() {
    var buttonCheck : Button? = null
    var layoutProducts : LinearLayout? = null
    var products : ArrayList<String> = arrayListOf("Back to Nature",
            "Danish",
            "Cobblestone",
            "Dave's Killer Bread",
            "Entenmann's",
            "Home Pride",
            "Hovis[2]",
            "Kits",
            "McVitie's",
            "Mother's Pride",
            "Nabisco[3]",
            "Nature's Own",
            "Newman's Own",
            "Pepperidge Farm",
            "Roman Meal",
            "Sunbeam Bread",
            "Tastykake",
            "Warburtons",
            "Westminster Cracker Company[4]",
            "Wonder Bread")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeElements()
        addListeners()
    }

    fun initializeElements(){
        buttonCheck = findViewById(R.id.button_check_products)
        layoutProducts = findViewById(R.id.layout_products)
        (0 until 15).forEach {
            var product = products.shuffled().first()
            var cb : CheckBox = CheckBox(getApplicationContext());
            cb.setText(product);
            products.remove(product);
            layoutProducts?.addView(cb);
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun addListeners(){
        buttonCheck?.setOnClickListener(View.OnClickListener {
            layoutProducts?.forEachIndexed { index, view ->
                    (view as CheckBox).setButtonTintList(getColorStateList(R.color.colorAccent))
                    (view as CheckBox).setTextColor(getColorStateList(R.color.colorAccent))
                   if((view as CheckBox).isChecked()==false){
                       (view as CheckBox).setButtonTintList(getColorStateList(R.color.red))
                       (view as CheckBox).setTextColor(getColorStateList(R.color.red))
                   }
            }


        })
    }
}