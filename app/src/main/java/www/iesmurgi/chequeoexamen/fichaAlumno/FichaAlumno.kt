package www.iesmurgi.chequeoexamen.fichaAlumno

import android.os.Bundle
import android.text.InputType
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.chequeoexamen.databinding.FichaalumnoBinding

class FichaAlumno: AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var binding: FichaalumnoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FichaalumnoBinding.inflate(layoutInflater)
        //Le ponemos los inputType
        binding.etNombreAp.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_PERSON_NAME + InputType.TYPE_TEXT_FLAG_CAP_WORDS
        binding.etCalle.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
        binding.etNumero.inputType = InputType.TYPE_CLASS_NUMBER
        binding.etCPostal.inputType = InputType.TYPE_CLASS_NUMBER
        binding.etLocalidad.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_FLAG_CAP_WORDS
        binding.etCiudad.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_FLAG_CAP_WORDS
        binding.etTelefono.inputType = InputType.TYPE_CLASS_PHONE
        binding.etTelefonoUrgencias.inputType = InputType.TYPE_CLASS_PHONE
        binding.etNombrePadre.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_PERSON_NAME + InputType.TYPE_TEXT_FLAG_CAP_WORDS
        binding.etNombreMadre.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_PERSON_NAME + InputType.TYPE_TEXT_FLAG_CAP_WORDS
        binding.etPagina.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_URI
        binding.etFecha.inputType = InputType.TYPE_CLASS_DATETIME
        binding.etAltura.inputType = InputType.TYPE_CLASS_NUMBER + InputType.TYPE_NUMBER_FLAG_DECIMAL
        binding.etDescripcion.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
        binding.etEmail.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        binding.etAlergias.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_FLAG_MULTI_LINE
        binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_PASSWORD
        //Focus y setError
        binding.etNombreAp.error = "Debe introducir el nombre"
        binding.etNombreAp.requestFocus()
        binding.etFecha.error="Debe introducir la fecha de nacimiento"
        binding.etFecha.requestFocus()
        binding.etTelefono.error="Debe introducir el telefono"
        binding.etTelefono.requestFocus()
        binding.etPassword.error="Debe introducir la contraseña"
        binding.etPassword.requestFocus()
        binding.seekBar.setOnSeekBarChangeListener(this)
        setContentView(binding.root)

    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        binding.sliderText.text=p1.toString();
        binding.txtEstado.setText("Toque de Seguimiento...");
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        binding.txtEstado.setText("Arrastrando...");
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        binding.txtEstado.setText("Parado...");
    }

}