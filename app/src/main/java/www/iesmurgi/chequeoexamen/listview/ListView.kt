package www.iesmurgi.chequeoexamen.listview

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.chequeoexamen.databinding.ListviewBinding

class ListView: AppCompatActivity() {
    private lateinit var miLista: ListView
    private lateinit var tvPais: TextView
    private lateinit var binding: ListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        //Asignacion a variables
        //miLista = findViewById(R.id.miLista)
        miLista = binding.miLista
        //tvPais = findViewById(R.id.tvPais)
        tvPais = binding.tvPais


        //Array con los Paises
        val misAndroids = arrayOf("Android 1.0 - API 1", "Android 1.1 - API 2", "Android 1.5 -  API 3", "Android 1.6 - API 4", "Android 2.0 - API 5",
            "Android 2.1 - API 7", "Android 2.2 - API 8", "Android 2.3 - API 9", "Android 3.0 - API 11", "Android 3.1 - API 12", "Android 3.2 - API 13",
            "Android 4.0 - API 14", "Android 4.4 - API 19", "Android 5.0 - API 21", "Android 6.0 - API 23", "Android 7.0 - API 24", "Android 8.0 - API 26",
            "Android 9.0 - API 28", "Android 10.0 - API 29", "Android 11.0 - API 30", "Android 12.0 - API 32", "Android 13.0 - API 33")
        //ArrayAdapter para asignar los paises a la varible miLista
        ArrayAdapter(this, R.layout.simple_list_item_1, misAndroids).also {
                adaptador -> miLista.setAdapter(adaptador)}

        //Metodo para al clickar obtener el elemento y
        //realizar setText() a tvPais
        miLista.setOnItemClickListener { parent, view, position, id ->
            //1.- Llamando al padre
            val android = parent.getItemAtPosition(position).toString()
            //2.- Llamando al adaptador
            //Dan el mismo resultado
            val pais2 = parent.adapter.getItem(position).toString()
            tvPais.setText(android)
        }
    }
}