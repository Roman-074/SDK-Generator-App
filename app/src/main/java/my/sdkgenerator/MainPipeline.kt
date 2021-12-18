package my.sdkgenerator

import com.maasglobal.sdkgeneerator.snaps.FilterSnap
import org.json.JSONArray

class MainPipeline() {

    fun execute(
        dataInput: JSONArray,
        onSuccess: (JSONArray) -> Unit,
        onError: (JSONArray) -> Unit
    ) {
        FilterSnap(null, dataInput,
            {
                FilterSnap(
                    null, it,
                    { onSuccess(it) },
                    { onError(it) }
                )
            },
            {
                onError(it)
            })
    }
}