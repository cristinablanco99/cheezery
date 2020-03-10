package mx.itson.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_combos.*
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.combo_view.view.*
import kotlinx.android.synthetic.main.encabezado_view.view.*

class CombosActivity : AppCompatActivity() {

    var adapter: CombosAdapter? = null
    var coldDrinks = ArrayList<Product>()
    var logo=ArrayList<Logo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combos)

        cargarCombos()


        adapter = CombosAdapter(this, coldDrinks)
       gridview.adapter=adapter
        cargarLogo()
        var adaptador2= CombosActivity.AdaptadorLogo(this, logo)
        prod_list.adapter=adaptador2

    }

    fun cargarLogo(){
        logo.add(Logo(R.drawable.sweets))
    }

    fun cargarCombos(){
        //Cargar películas
        coldDrinks.add(Product("Churros + Hot Chocolate", R.drawable.churro, "Perfect for cold weathers", 15))

        coldDrinks.add(Product("Hamburguer + Fries", R.drawable.hamburguesa, "Delicious  beef with seasoned fries on the side", 17))

        coldDrinks.add(Product("Waffles + Icecream", R.drawable.wafflenieve, "Tower of waffles with scoups of various ice creams on top", 20))

        coldDrinks.add(Product("Pancakes + Fruit", R.drawable.pancakes, "A delicious and healthy option to start your day .", 12))

    }

    class CombosAdapter: BaseAdapter {
        var combos = ArrayList<Product>()
        var context: Context? = null

        constructor(context: Context, peliculas: ArrayList<Product>){
            this.context = context
            this.combos = peliculas
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var combo = combos[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.combo_view, null)
            vista.img_product.setImageResource(combo.image)
            vista.name_product.setText(combo.name)
            vista.precio_product.setText("$${combo.price}")
            vista.desc_product.setText(combo.description)


            return vista

        }

        override fun getItem(p0: Int): Any {
            return combos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return combos.size
        }

    }

    private class AdaptadorLogo: BaseAdapter {
        var logo= ArrayList<Logo>()
        var contexto: Context? =null
        constructor(contexto: Context, productos:ArrayList<Logo>){
            this.contexto=contexto
            this.logo=productos
        }
        override fun getItem(position: Int): Any {
            return logo[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return logo.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod= logo[position]
            var inflador = LayoutInflater.from(contexto)
            var vista= inflador.inflate(R.layout.encabezado_view,null)
            vista.img_productos_logo.setImageResource(prod.image)
            return vista

        }

    }


}
