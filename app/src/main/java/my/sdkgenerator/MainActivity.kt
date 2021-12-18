package my.sdkgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.sdkgenerator.generateapi.generate.Generator
import my.sdkgenerator.generateapi.parse.FileParser.getResJson
import my.sdkgenerator.generateapi.parse.FileParser.parseMyParams
import my.sdkgenerator.generateapi.parse.ResultModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            MainPipeline().execute(JSONArray(JsonData.getData()),
                {
                    binding.textView.text = it.toString()
                },
                {
                    binding.textView.text = it.toString()
                })
        }
    }
}