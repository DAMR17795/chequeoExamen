package www.iesmurgi.chequeoexamen.autocomplete

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import www.iesmurgi.chequeoexamen.R

class PoblacionAdapter (context: Context, zonas:List<Poblacion>):ArrayAdapter<Poblacion>(context, 0, zonas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val vista=convertView?: LayoutInflater.from(context).inflate(R.layout.esqueleto_poblaciones, parent, false)
        getItem(position)?.let { poblacion ->
            vista.findViewById<TextView>(R.id.tfDistancia).apply {
                text=poblacion.nombre
            }
            vista.findViewById<TextView>(R.id.tfDistancia2).apply {
                text=poblacion.distancia.toString()
            }
        }
        return vista
        //end getView
    }
}