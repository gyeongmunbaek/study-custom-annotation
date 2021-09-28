package com.example.annotationsample.model

import com.example.sample_annotation.annotation.DataValidation
import com.example.sample_annotation.annotation.MaxLength
import com.example.sample_annotation.annotation.MaxValue
import com.example.sample_annotation.annotation.MinLength
import com.example.sample_annotation.annotation.MinValue
import com.example.sample_annotation.annotation.Nested
import com.example.sample_annotation.annotation.NotNull
import com.example.sample_annotation.annotation.Regex

@DataValidation
data class Book(
    @MinLength(10, "title length minimum is 10")
    @MaxLength(50, "title length maximum is 50")
    val title: String,
    @MinValue(1, "book is not free")
    @MaxValue(100000, "book is too expensive")
    val price: Int,
    @MaxLength(10, "author name is too long")
    val authorName: String,
    @Regex("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", "authorEmail is invalid")
    val authorEmail: String,
    @NotNull("publisher should is null")
    @Nested
    val publisher: Publisher
)

@DataValidation
data class Publisher(
    @MaxLength(10, "publisher name is too long")
    val name: String
)