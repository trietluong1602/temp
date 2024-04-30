package com.kroger.android.interview.hackernews

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.recyclerview.widget.LinearLayoutManager
import com.kroger.android.interview.hackernews.ui.adapter.NewsAdapter
import com.kroger.android.interview.hackernews.databinding.ActivityMainBinding
import com.kroger.android.interview.hackernews.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * This Activity shows the Hacker News home screen
 *
 * The Challenge:
 *
 * Recreate the Hacker News home screen in the app. The UI can be simple.
 *
 * For reference: https://news.ycombinator.com/
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var app: HackerNewsApp
    private val viewModel: MainViewModel by viewModels()
    private val adapter = NewsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = application as HackerNewsApp

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.topStories.observe(this) { stories ->
            adapter.setItems(stories)
        }
    }
}



