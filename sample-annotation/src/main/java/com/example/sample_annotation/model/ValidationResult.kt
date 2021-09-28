package com.example.sample_annotation.model

data class ValidationResult(
    var isValid: Boolean = true,
    val invalidFieldNameAndTags: MutableList<FieldNameAndTag> = mutableListOf()
)