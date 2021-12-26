package my.sdkgenerator.snaps

import org.json.JSONArray
import org.json.JSONObject

class FilterSnap(
    private val schema: JSONObject?,
    private val dataInput: JSONArray,
    val onSuccess: (JSONArray) -> Unit,
    val onError: (JSONArray) -> Unit
) {

    fun execute() {
        val newArray = JSONArray()
        for (i in 0 until dataInput.length()) {
            val jsonObject = dataInput.getJSONObject(i)
            val aObj = jsonObject.get("orderQuantity")
            if (aObj is Int || aObj is Double) {
                if (jsonObject.getInt("orderQuantity") > 100)
                    newArray.put(jsonObject)
            } else if (aObj is String) {
                // do what you want
            }

        }
        onSuccess(newArray)
    }



    init {
        execute()
    }
}