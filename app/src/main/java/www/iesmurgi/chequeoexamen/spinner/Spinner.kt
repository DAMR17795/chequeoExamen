package www.iesmurgi.chequeoexamen.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.chequeoexamen.R

class Spinner: AppCompatActivity() {
    private var miSpinner: Spinner?= null
    private var miVersion: TextView?= null
    private var miApi: TextView?= null
    private var miCar: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner)

        miSpinner = findViewById(R.id.spinner)
        miVersion = findViewById(R.id.txtVersion)
        miApi = findViewById(R.id.txtAPI)
        miCar = findViewById(R.id.txtCar)

        val listaAndroids = Android.androidSource

        var adaptador: ArrayAdapter<Android> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAndroids)
        miSpinner?.adapter = adaptador

        miSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                miVersion?.text = Android.androidSource[miSpinner?.selectedItemPosition!!].version
                miApi?.text =
                    Android.androidSource[miSpinner?.selectedItemPosition!!].api.toString()
                miCar?.text =
                    Android.androidSource[miSpinner?.selectedItemPosition!!].caracteristica
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
    }
}