package my.sdkgenerator.generateapi.parse

import com.beust.klaxon.Klaxon
import java.io.InputStream
import java.nio.charset.Charset

object FileParser {

    fun getResJson(): String {
        val inputFile = javaClass.getResource("test_scheme.json")
        val inputAsString = inputFile?.openStream()?.readTextAndClose()
        return inputAsString.toString()
    }

    private fun InputStream.readTextAndClose(charset: Charset = Charsets.UTF_8): String {
        return this.bufferedReader(charset).use { it.readText() }
    }


    fun parseMyParams(inputJson : String) : ResultModel? {
        val parseResult = Klaxon().parse<InputDataModel>(inputJson)
        println("result serial >> ${parseResult?.serial}")
        println("result version >> ${parseResult?.version}")
        println("result snap_map >> ${parseResult?.snap_map}")
        println("result target_runtime >> ${parseResult?.target_runtime}")
        val result = parseResult?.let {
            ResultModel(
                version = it.version,
                serial = it.serial,
                target_runtime = it.target_runtime
            )
        }
        return result
    }


}