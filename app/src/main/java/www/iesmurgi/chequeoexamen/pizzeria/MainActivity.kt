package www.iesmurgi.chequeoexamen.pizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import www.iesmurgi.chequeoexamen.R
import www.iesmurgi.chequeoexamen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Variables de titulo e imagen
        var miTexto = binding.titulo
        var imagen = binding.imageView

        //Animaciones
        val escala = AnimationUtils.loadAnimation(this, R.anim.escala)
        val aparicion = AnimationUtils.loadAnimation(this, R.anim.aparicion)
        miTexto.startAnimation(escala)
        imagen.startAnimation(aparicion)

        //Listener radio button
        binding.rbGrande.setOnClickListener{tamano()}
        binding.rbMediano.setOnClickListener{tamano()}
        binding.rbPeque.setOnClickListener{tamano()}

        //Listener checkbox
        binding.cbAtun.setOnClickListener{ingredientes()}
        binding.cbYork.setOnClickListener{ingredientes()}
        binding.cbAceitunas.setOnClickListener{ingredientes()}
        binding.cbChamp.setOnClickListener{ingredientes()}
        binding.cbSalami.setOnClickListener{ingredientes()}

        //Listener boton
        binding.btPedir.setOnClickListener{pedir()}

    }

    //Contador para el precio
    var contador=0.0


    //Funcion para establecer el precio del tamaño
    fun tamano () {
        //Tamaños
        val tamanioPequenio = binding.rbPeque
        val tamanioMediano = binding.rbMediano
        val tamanioGrande = binding.rbGrande
        val precio = binding.tvPrecio

        //Ingredientes
        val atun = binding.cbAtun
        val champ = binding.cbChamp
        val salami = binding.cbSalami
        val aceitunas = binding.cbAceitunas
        val york = binding.cbYork

        //If para poner en el precio el valor del tamaño
        if (tamanioGrande.isChecked) {
            contador+=15
            atun.setChecked(false)
            champ.setChecked(false)
            atun.setChecked(false)
            salami.setChecked(false)
            aceitunas.setChecked(false)
            york.setChecked(false)

        }
        if (tamanioMediano.isChecked) {
            contador+=10
            atun.setChecked(false)
            champ.setChecked(false)
            atun.setChecked(false)
            salami.setChecked(false)
            aceitunas.setChecked(false)
            york.setChecked(false)
        }
        if (tamanioPequenio.isChecked) {
            contador+=5
            atun.setChecked(false)
            champ.setChecked(false)
            atun.setChecked(false)
            salami.setChecked(false)
            aceitunas.setChecked(false)
            york.setChecked(false)
        }

        precio.setText(" " + contador + " €")

        contador=0.0

    }

    //Obtener tamano para realizar operaciones
    fun  obtenerTamano():String{
        var tamano:String = "";
        if (binding.rbGrande.isChecked && !binding.rbMediano.isChecked && !binding.rbPeque.isChecked){
            tamano = "Grande"
        }
        if (!binding.rbGrande.isChecked && binding.rbMediano.isChecked && !binding.rbPeque.isChecked){
            tamano = "Mediano"
        }
        if (!binding.rbGrande.isChecked && !binding.rbMediano.isChecked && binding.rbPeque.isChecked){
            tamano = "Pequeño"
        }
        return tamano;
    }

    //Ingredientes con los checkBox
    fun ingredientes() {

        //Ingredientes
        val atun = binding.cbAtun
        val champ = binding.cbChamp
        val salami = binding.cbSalami
        val aceitunas = binding.cbAceitunas
        val york = binding.cbYork
        val precio = binding.tvPrecio

        //Tamaños
        val tamanioPequenio = binding.rbPeque
        val tamanioMediano = binding.rbMediano
        val tamanioGrande = binding.rbGrande

        precio.setText("")

        if (!tamanioGrande.isChecked && !tamanioMediano.isChecked && !tamanioPequenio.isChecked) {
            Toast.makeText(this, "Debe seleccionar un tamaño " +
                    "antes de seleccionar los ingredientes", Toast.LENGTH_SHORT).show()
            atun.setChecked(false)
            champ.setChecked(false)
            atun.setChecked(false)
            salami.setChecked(false)
            aceitunas.setChecked(false)
            york.setChecked(false)
        } else {

            //Ifs para establecer el contador con los ingredientes
            if(obtenerTamano().equals("Grande")) {
                contador= 15.0
            }

            if(obtenerTamano().equals("Mediano")) {
                contador= 10.0
            }

            if(obtenerTamano().equals("Pequeño")) {
                contador= 5.0
            }

            //Ifs para poner el precio de los ingredientes
            if (atun.isChecked) {
                contador+=1
            }
            if (champ.isChecked) {
                contador+=0.5
            }
            if (salami.isChecked) {
                contador+=0.5
            }
            if (aceitunas.isChecked) {
                contador+=0.5
            }
            if (york.isChecked) {
                contador+=0.5
            }

            precio.setText(" " + contador + " €")
            contador=0.0
        }
    }


    fun pedir() {

        //Tamaño de las pizzas
        val tamanioPequenio = binding.rbPeque
        val tamanioMediano = binding.rbMediano
        val tamanioGrande = binding.rbGrande
        val precio = binding.tvPrecio

        //Ingredientes
        val atun = binding.cbAtun
        val champ = binding.cbChamp
        val salami = binding.cbSalami
        val aceitunas = binding.cbAceitunas
        val york = binding.cbYork

        if (!tamanioGrande.isChecked && !tamanioMediano.isChecked && !tamanioPequenio.isChecked) {
            Toast.makeText(this, "Debe seleccionar un tamaño " +
                    "de pizza para poder continuar", Toast.LENGTH_SHORT).show()

        } else {
            val enviar = Intent(this, Activity_Segunda::class.java)

            enviar.putExtra("PRECIO", precio.text.toString())

            var tamanoIntent = ""

            if (tamanioPequenio.isChecked) {
                tamanoIntent = tamanioPequenio.getText().toString()
            }

            if (tamanioMediano.isChecked) {
                tamanoIntent = tamanioMediano.getText().toString()
            }

            if (tamanioGrande.isChecked) {
                tamanoIntent = tamanioGrande.getText().toString()
            }
            enviar.putExtra("TAMANO", tamanoIntent)

            var txtAtun = ""
            var txtChamp = ""
            var txtSalami = ""
            var txtAceituna = ""
            var txtYork = ""

            if (atun.isChecked) {
               txtAtun = atun.getText().toString()
            }
            if (champ.isChecked) {
                txtChamp= champ.getText().toString()
            }
            if (salami.isChecked) {
                txtSalami = salami.getText().toString()
            }
            if (aceitunas.isChecked) {
                txtYork = york.getText().toString()
            }
            if (york.isChecked) {
                txtAceituna = aceitunas.getText().toString()
            }

            var todos = txtAtun + " " + txtChamp + " " + txtSalami + " " + txtAceituna + " " + txtYork

            enviar.putExtra("INGREDIENTE", todos)

            Toast.makeText(this, "Pedido Realizado", Toast.LENGTH_SHORT).show()

            startActivity(enviar)

            //Volvemos a resetear
            contador=0.0
            precio.setText("")

            atun.setChecked(false)
            champ.setChecked(false)
            atun.setChecked(false)
            salami.setChecked(false)
            aceitunas.setChecked(false)
            york.setChecked(false)

            tamanioPequenio.setChecked(false)
            tamanioMediano.setChecked(false)
            tamanioGrande.setChecked(false)

        }
    }
}