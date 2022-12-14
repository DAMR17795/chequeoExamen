package www.iesmurgi.chequeoexamen.autocomplete

data class Poblacion(val nombre:String, val distancia:Int, val descripcion: String) {
    companion object {
        val poblacionSource = listOf(
            Poblacion("Almeria", 40, "Ciudad costera del sur")
            ,Poblacion("Almerimar", 15, "Ciudad aun más costera")
            ,Poblacion("Aguadulce", 25, "Al lado de Roquetas")
            ,Poblacion("Adra", 30, "Pegando a Motril")
            ,Poblacion("Azahara de los Atunes", 100, "Ciudad de Sevilla")
            ,Poblacion("Albolote", 65, "Esta perdido")
            ,Poblacion("Alcaudique", 70, "Ni idea de donde está")

        )
    }

    override fun toString(): String {
        return nombre
    }
}
