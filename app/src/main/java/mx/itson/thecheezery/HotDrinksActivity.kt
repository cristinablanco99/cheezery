package mx.itson.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.encabezado_view.view.*
import kotlinx.android.synthetic.main.producto_view.view.*

class HotDrinksActivity : AppCompatActivity() {

    var hotDrinks = ArrayList <Product>()
    var logo=ArrayList<Logo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        cargarProductos()
        var adaptador=AdaptadorProductos(this,hotDrinks)
        listview.adapter=adaptador

        cargarLogo()
        var adaptador2=AdaptadorLogo(this,logo)
        layout_producto.adapter=adaptador2

    }
    fun cargarLogo(){
        logo.add(Logo(R.drawable.hotdrinks))
    }

    fun cargarProductos(){
        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6))

        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5))

        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4))

        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6))

        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7))

        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2))
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
    private class AdaptadorProductos: BaseAdapter {
        var productos= ArrayList<Product>()
        var contexto: Context? =null
        constructor(contexto: Context, productos:ArrayList<Product>){
            this.contexto=contexto
            this.productos=productos
        }
        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod= productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista= inflador.inflate(R.layout.producto_view,null)
            vista.producto_img.setImageResource(prod.image)
            vista.producto_nombre.setText(prod.name)
            vista.producto_desc.setText(prod.description)
            vista.producto_precio.setText("$${prod.price}")
            return vista

        }

    }

}
