package my.sdkgenerator.generateapi.samples

import my.sdkgenerator.snaps.FilterSnap
import org.json.JSONArray

class OrderFilter {

//    fun execute(
//        dataInput: JSONArray,
//        onSuccess: (JSONArray) -> Unit,
//        onError: (JSONArray) -> Unit
//    ) {
//        FilterSnap(null, dataInput,
//            {
//                FilterSnap(
//                    null, it,
//                    {
//                        FilterSnap(
//                            null, it,
//                            { onSuccess(it) },
//                            { onError(it) }
//                        )
//                    },
//                    { onError(it) }
//                )
//            },
//            {
//                onError(it)
//            })
//
//    }


    fun execute(
        dataInput: JSONArray? = null,
        onSuccess: (JSONArray) -> Unit,
        onError: (JSONArray) -> Unit
    ) {
        FilterSnap(
            dataInput = dataInput,
            onSuccess = { it1 ->
                onSuccess(it1)
                FilterSnap(
                    dataInput = it1,
                    onSuccess = { it2 ->
                        onSuccess(it2)
                        FilterSnap(
                            dataInput = it2,
                            onSuccess = { it3 ->
                                onSuccess(it3)
                            },
                            onError = { it3 -> onError(it3) })
                    },
                    onError = { it2 -> onError(it2) })
            },
            onError = { it1 -> onError(it1) }
        )
    }


}













