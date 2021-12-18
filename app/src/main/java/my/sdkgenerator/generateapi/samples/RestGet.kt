package samples

import com.beust.klaxon.Json
import com.beust.klaxon.JsonObject


interface IRestGet {
    fun onError()
    fun onSuccess()
}


class RestGet : IRestGet {

    private var output : GetModel? = null

    override fun onError() {
        sendModel(null)
    }

    override fun onSuccess() {
        sendModel(output)
    }

    fun sendModel(output_value: GetModel?){
        val out = JsonObject()
    }

    data class GetModel(
        @Json("url")
        val url : String? = "url",

        @Json("body")
        val body : String? = "body",

        @Json("header")
        val header : String? = "header"
    )

}
