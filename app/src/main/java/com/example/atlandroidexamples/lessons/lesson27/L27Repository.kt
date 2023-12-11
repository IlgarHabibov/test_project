package com.example.atlandroidexamples.lessons.lesson27

import javax.inject.Inject

class L27Repository @Inject constructor(
    private val networkHelper: NetworkHelper
) {

    fun getMyName() = networkHelper.getFullName()
}