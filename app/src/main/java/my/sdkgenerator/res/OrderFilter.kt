package my.sdkgenerator.res

import my.sdkgenerator.snaps.FilterSnap
import org.json.JSONArray

class OrderFilter {

    fun execute(
        dataInput: JSONArray,
        onSuccess: (JSONArray) -> Unit,
        onError: (JSONArray) -> Unit
    ) {
        FilterSnap(null, dataInput,
            {
                FilterSnap(
                    null, it,
                    {
                        FilterSnap(
                            null, it,
                            { onSuccess(it) },
                            { onError(it) }
                        )
                    },
                    { onError(it) }
                )
            },
            {
                onError(it)
            })

        val data1 = await FilterSnap(null, dataInput)
        val data2 = await FilterSnap(null, data1)
    }


}


fun ex(){

    fun nextSnap(
        dataInput: JSONArray,
    ) {
        FilterSnap(
            null, it,
            {
                FilterSnap(
                    null, it,
                    { onSuccess(it) },
                    { onError(it) }
                )
            },
            { onError(it) }
        )
    }

    fun execute(
        dataInput: JSONArray,
        onSuccess: (JSONArray) -> Unit,
        onError: (JSONArray) -> Unit
    ) {
        FilterSnap(null, dataInput,
            {
                nextSnap(
                    dataInput,
                    onSuccess,

                )
            },
            {
                onError(it)
            })
    }




}













