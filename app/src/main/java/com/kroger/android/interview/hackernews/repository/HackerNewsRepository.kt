package com.kroger.android.interview.hackernews.repository

import com.kroger.android.interview.hackernews.HackerNewsService
import javax.inject.Inject

/**
 *  Repository for fetching hacker news data
 */

class HackerNewsRepository @Inject constructor(private val service: HackerNewsService) {
    suspend fun getTopStories() = service.getTopStories()
    suspend fun getItem(id: Int) = service.getItem(id)
}


