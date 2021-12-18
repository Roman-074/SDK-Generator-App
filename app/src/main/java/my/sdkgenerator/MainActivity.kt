package my.sdkgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import my.sdkgenerator.databinding.ActivityMainBinding
import my.sdkgenerator.mock.JsonData
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            MainPipeline().execute(
                JSONArray(JsonData.getData()),
                {
                    binding.textView.text = it.toString()
                },
                {
                    binding.textView.text = it.toString()
                })
        }

    }

}