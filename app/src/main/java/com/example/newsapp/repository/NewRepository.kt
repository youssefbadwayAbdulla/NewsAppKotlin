package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.dp.ArticleDatabase
import com.example.newsapp.models.Article

class NewRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.articleDao().upsert(article)
    fun getSavedNews() = db.articleDao().getAllArticles()
    suspend fun deleteArticle(article: Article) = db.articleDao().deleteArticle(article)
}