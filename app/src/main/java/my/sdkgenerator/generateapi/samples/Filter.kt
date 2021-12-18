package my.sdkgenerator.generateapi.samples

class Filter {

    private var output : String? = null

    fun filterModel(input_value : String) : String? {
        return when(filter(input_value)){
            "error" -> {
                "error_value"
            }
            "output" -> {
                output
            }
            else -> {
                null
            }
        }
    }

    private fun filter(value : String) : String {
        output = "$value example"
        return if (output == null)
            "error"
        else
            "output"
    }

    data class FilterModel(
        val filter : String? = "extension"
    )

}