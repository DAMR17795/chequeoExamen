package www.iesmurgi.chequeoexamen.autocomplete

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.chequeoexamen.R

class Autocomplete: AppCompatActivity() {
    private lateinit var  miPoblacion:AutoCompleteTextView
    private lateinit var miDescripcion:EditText
    private lateinit var miDistancia:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autocomplete)
        miPoblacion=findViewById(R.id.actPoblacion)
        miDistancia=findViewById(R.id.etDistancia)
        miDescripcion=findViewById(R.id.etDescripcion)

        //1.-Poblar desde <String-array>
        //setOpcionArrays()

        //2.-Poblar desde Listener-Adapter-ArrayAdapter
        setOpcionList()
    }

    private fun setOpcionList() {
        PoblacionAdapter(this, Poblacion.poblacionSource).also{ adapter ->
            miPoblacion.setAdapter(adapter)

        }

        //Ponemos el escuchador
        miPoblacion.setOnItemClickListener { parent, view, position, l ->
            val pueblo=parent.adapter.getItem(position) as Poblacion
            this.miDistancia.setText(pueblo.distancia.toString())
            this.miDescripcion.setText(pueblo.descripcion)
        }
    } //end fun set

    private fun setOpcionArrays(){
        val poblaciones=resources.getStringArray(R.array.muchaspoblaciones)
        ArrayAdapter(this, android.R.layout.simple_list_item_1, poblaciones).also {arrayAdapter -> miPoblacion.setAdapter(arrayAdapter)}
    }
}