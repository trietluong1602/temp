package com.kroger.android.interview.hackernews.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kroger.android.interview.hackernews.repository.HackerNewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for [com.kroger.android.interview.hackernews.MainActivity]
 */



@HiltViewModel
class MainViewModel @Inject constructor(private val repository: HackerNewsRepository) : ViewModel() {
    val topStories = liveData {
        val storyIds = repository.getTopStories()
        val stories = storyIds.map { repository.getItem(it) }
        emit(stories)
    }
}


