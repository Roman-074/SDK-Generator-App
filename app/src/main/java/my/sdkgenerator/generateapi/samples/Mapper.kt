package samples

import com.squareup.kotlinpoet.FunSpec

class Mapper {

    private var output : String? = null

    fun mapModel(input_value : String) : String? {
        return when(transform(input_value)){
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

    private fun transform(value : String) : String {
        output = "$value example"
        return if (output == null)
            "error"
        else
            "output"
    }

}


fun mapperGenerator(value : String){
    val genTransformFun = FunSpec.builder("transform")
        .returns(String::class)
        .addStatement("output = \"$value example\"")
//        .beginControlFlow()


}