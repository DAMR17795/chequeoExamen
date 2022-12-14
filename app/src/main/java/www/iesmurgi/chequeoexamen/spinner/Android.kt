package www.iesmurgi.chequeoexamen.spinner

data class Android(val version:String, val api:Int, val caracteristica:String){

    companion object{

        val androidSource = listOf(
            Android ("Android 1.0", 1,"Primera versión estable, no se utilizó comercialmente, nacimiento."),
            Android ("Android 1.1", 2,"Se corregieron errores de la 1.0"),
            Android ("Android 1.5 Cupcake", 3,"Primera versión con algún usuario, Diseño refinado, Teclado virtual"),
            Android ("Android 1.6 Donut", 4,"Permite busqueda avanzada en todo el dispositivo, Búsqueda rápida, Android Market renovado"),
            Android ("Android 2.0 Eclair", 5,"No cuenta con muchos usuarios, Rutas en Maps, Soporte para varias cuentas"),
            Android ("Android 2.1", 7,"Se sigue llamando Eclair"),
            Android ("Android 2.2 Froyo", 8,"Mejora en la ejecución de las apps."),
            Android ("Android 2.3 Gingerbread", 9,"Soporta mayores tamaños de pantalla"),
            Android ("Android 3.0 HoneyComb", 11,"Optimización para pantallas grandes."),
            Android ("Android 3.1", 12,"Se permite manejar dispositivos conectados por USB."),
            Android ("Android 3.2", 13,"Zoom compatible."),
            Android ("Android 4.0 Ice Cream Sandwich", 14,"Se unifican las dos versiones anteriores."),
            Android ("Android 4.1 Jelly Bean", 16,"Se mejora la fluidez de la interfaz de usuario"),
            Android ("Android 4.4 KitKat", 19,"Modo inmersivo"),
            Android ("Android 5.0 Lollipop", 21,"Material Design"),
            Android ("Android 6.0 Marshmallow", 23,"Modo Doze"),
            Android ("Android 7.0 Nougat", 24,"Modo Doze"),
            Android ("Android 8.0 Oreo", 26,"Project Treble"),
            Android ("Android 9.0 Pie", 28,"Bienestar digital"),
            Android ("Android 10.0 Quince Tart", 29,"Modo Oscuro"),
            Android ("Android 11.0 Red Velvet Cake", 30,"Burbujas de chat"),
            Android ("Android 12.0 Snow Cone", 32,"Diseño a dos columnas"),
            Android ("Android 13.0 Tiramisu", 33,"Lector QR"),

            )

    }

    override fun toString(): String {
        return version
    }


}
