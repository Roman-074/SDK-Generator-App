package my.sdkgenerator.generateapi.generate

import android.util.Log
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.asTypeName
import org.json.JSONArray

open class Generator {

    fun orderFilterExecute(
        inputFileName : String = "Filter",
        inputClassName : String = "OrderFilter",
        inputFunName : String = "execute"
    ){
//        val greeterClass = ClassName("", inputClassName)

        val funExecute = FunSpec.builder(inputFunName)
            .addParameter(
                "dataInput",
                JSONArray::class.asTypeName().copy(nullable = true))
            .addParameter(
                "onSuccess",
                LambdaTypeName.get(returnType = Unit::class.asTypeName()))
            .addParameter(
                "onError",
                LambdaTypeName.get(returnType = Unit::class.asTypeName()))
            .addStatement("FilterSnap(")
            .addStatement("dataInput = dataInput,")
            .addStatement("onSuccess = { it1 ->")
            .addStatement("onSuccess(it1)")
            .addStatement("FilterSnap(")
            .addStatement("dataInput = it1,")
            .addStatement("onSuccess = { it2 ->")
            .addStatement("onSuccess(it2)")
            .addStatement("FilterSnap(")
            .addStatement("dataInput = it2,")
            .addStatement("onSuccess = { it3 ->")
            .addStatement("onSuccess(it3)")
            .addStatement("},")
            .addStatement("onError = { it3 -> onError(it3) })")
            .addStatement("},")
            .addStatement("onError = { it2 -> onError(it2) })")
            .addStatement("},")
            .addStatement("onError = { it1 -> onError(it1) }")
            .addStatement(")")
            .build()


        Log.d("my", "res >>> $funExecute")
    }

}