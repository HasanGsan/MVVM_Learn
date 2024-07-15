package com.example.learn_mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learn_mvvm.databinding.ActivityMainBinding
import com.example.learn_mvvm.ui.theme.Learn_MVVMTheme
import com.example.learn_mvvm.ui.theme.VmActivity

class MainActivity : ComponentActivity() {


    private lateinit var vm: VmActivity

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edText = findViewById<EditText>(R.id.refactor_text)
        var buttonRefactor = findViewById<Button>(R.id.btn_refactor)
        var buttonSaveText = findViewById<Button>(R.id.btn_save)

        Log.e("AAA", "Активность создана")

        vm = ViewModelProvider(this).get(VmActivity::class.java) //Идет что-то типо подключения

        vm.getResultLiveData().observe(this, Observer{ text ->

            edText.setText(text)

        })

        buttonSaveText.setOnClickListener{
            val text = edText.text.toString()
            vm.save(text)
        }

        buttonRefactor.setOnClickListener{
            vm.load()
        }


    }
}

