package my.sdkgenerator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import my.sdkgenerator.snaps.MainPipeline
import my.sdkgenerator.R
import my.sdkgenerator.databinding.ActivityMainBinding
import my.sdkgenerator.generateapi.generate.Generator
import my.sdkgenerator.generateapi.samples.OrderFilter
import my.sdkgenerator.mock.JsonData
import org.json.JSONArray

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.button.setOnClickListener {
            MainPipeline().execute(
                JSONArray(JsonData.getData()),
                {
                    viewBinding.textView.text = it.toString()
                },
                {
                    viewBinding.textView.text = it.toString()
                })
        }


        OrderFilter().execute(JSONArray(JsonData.getData()), onSuccess = { }, onError = { })

        Generator().orderFilterExecute()

    }

}