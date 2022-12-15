package www.iesmurgi.chequeoexamen.pizzeria

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.chequeoexamen.databinding.ActivitySegundaBinding

class Activity_Segunda : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mostrar()
        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b -> valoracion() }
        binding.btVolver.setOnClickListener{onBackPressed()}

    }

    fun mostrar() {
        val mibundle=intent.extras
        val nombre = mibundle?.getString("PRECIO")
        val tamano = mibundle?.getString("TAMANO")
        val ingrediente = mibundle?.getString("INGREDIENTE")
        val tvIngrediente = binding.tvIngrediente
        val tvTamano = binding.tvTamano
        val tvPrecio=binding.txtPrecio
        tvPrecio.setText("Importe final: " + nombre)
        tvTamano.setText("Tamaño: " + tamano)
        tvIngrediente.setText("Ingredientes: " + ingrediente)

    }

    fun valoracion() {
        val barra = binding.ratingBar
        var valoracion = binding.tvValoracion

        if (barra.getRating().toString().equals("2.5")) {
            valoracion.setText("Valoracion: " + barra.getRating().toString() + ", ¡Gracias por tu valoracion!")
        } else if (barra.getRating() < 2.5) {
            valoracion.setText("Valoracion: " + barra.getRating().toString() + ", ¡Intentaremos mejorar!")
        } else if (barra.getRating() > 2.5) {
            valoracion.setText("Valoracion: " + barra.getRating().toString() + ", ¡Seguiremos dandote el mejor servicio!")
        }
    }
}