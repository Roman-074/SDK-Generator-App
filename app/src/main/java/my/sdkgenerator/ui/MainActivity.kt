package my.sdkgenerator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import my.sdkgenerator.MainPipeline
import my.sdkgenerator.R
import my.sdkgenerator.databinding.ActivityMainBinding
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

    }

}