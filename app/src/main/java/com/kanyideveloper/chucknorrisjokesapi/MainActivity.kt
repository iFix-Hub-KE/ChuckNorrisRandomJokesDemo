package com.kanyideveloper.chucknorrisjokesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.kanyideveloper.chucknorrisjokesapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { JokesAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getResponse()


        binding.buttonRetry.setOnClickListener {
            binding.progressBar.isVisible = true
            binding.textViewError.isVisible = false
            binding.buttonRetry.isVisible = false
            getResponse()
        }
    }

    fun getResponse(){
        JokesApi.retrofitService.getJokes().enqueue(object: Callback<Jokes> {
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                binding.progressBar.isVisible = false
                Timber.d(response.body()?.value?.get(0)?.joke)
                binding.recyler.adapter = adapter
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                binding.progressBar.isVisible = false
                binding.textViewError.text = t.localizedMessage
                binding.textViewError.isVisible = true

                binding.buttonRetry.isVisible = true

                Timber.d(t.localizedMessage)
            }
        })
    }
}