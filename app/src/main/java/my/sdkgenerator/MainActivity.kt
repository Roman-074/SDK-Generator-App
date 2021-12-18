package my.sdkgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.sdkgenerator.generateapi.generate.Generator
import my.sdkgenerator.generateapi.parse.FileParser.getResJson
import my.sdkgenerator.generateapi.parse.FileParser.parseMyParams
import my.sdkgenerator.generateapi.parse.ResultModel

class MainActivity : AppCompatActivity() {

    private var resultModel: ResultModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val stringJson : String = getResJson()
//        resultModel = parseMyParams(stringJson)

//        Generator().restGetModel()

    }

}