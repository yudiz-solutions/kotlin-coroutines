package com.yudiz.coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.yudiz.coroutines.adapters.Adapter
import com.yudiz.coroutines.api.Retrofit
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        GlobalScope.launch(Dispatchers.Main) {
            val request = Retrofit.getRetrofitInstance().getCountries()
            val response = request.await()
            pb.visibility = View.GONE
            response.body()?.let {
                rv.adapter = Adapter(this@MainAct, it)
            }
        }
    }
}
